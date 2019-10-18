package so.wwb.creditbox.web.defense.biz.interceptor;

import org.springframework.web.method.HandlerMethod;
import so.wwb.creditbox.web.defense.biz.annotataion.Defense;

public class DefenseAnnotationResolver implements IDefenseAnnotationResolver {

    @Override
    public IDefense getDefense(Object handler) {
        //get annotation by handler method
        HandlerMethod handlerMethod = null;
        if (handler instanceof HandlerMethod) {
            handlerMethod = (HandlerMethod)(handler);
        }
        if (handlerMethod == null) return null;
        final Defense ann = handlerMethod.getMethodAnnotation(Defense.class);
        if (ann == null) return null;

        return new IDefense() {

            @Override
            public String action() {
                return ann.action().getCode();
            }

            @Override
            public String level() {
                return ann.level().getCode();
            }
        };
    }
}
