package so.wwb.creditbox.web.defense.core.handle;

import so.wwb.creditbox.web.defense.biz.interceptor.IDefense;

import javax.servlet.http.HttpServletRequest;

public interface IDefenseHandler {
    void beforeHandle(HttpServletRequest request, IDefense defense);
    void afterHandle(HttpServletRequest request, IDefense defense);
}
