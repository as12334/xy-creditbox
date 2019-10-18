package so.wwb.lotterybox.web.regions.controller;

import org.soul.commons.collections.CollectionQueryTool;
import org.soul.commons.collections.ListTool;
import org.soul.commons.data.json.JsonTool;
import org.soul.commons.dict.DictTool;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.lang.string.I18nTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.model.sys.po.SysDict;
import org.soul.web.session.SessionManagerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import so.wwb.lotterybox.model.enums.base.DictEnum;
import so.wwb.lotterybox.model.manager.site.po.SiteOperateArea;
import so.wwb.lotterybox.web.cache.Cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tony on 15-12-29.
 */
@Controller
//region your codes 1
@RequestMapping("/regions")
public class RegionsController {

    private static final Log LOG = LogFactory.getLog(RegionsController.class);

    /**
     * 联动获取国家地区
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public String list(){
        //Map<String,String> i18nMap = I18nTool.getDictsMap(SessionManagerBase.getLocale().toString()).get("region").get("region");
        Map<String,String> i18nMap = I18nTool.getDictsMap(SessionManagerBase.getLocale().toString()).get(DictEnum.REGION_REGION.getModule().getCode()).get(DictEnum.REGION_REGION.getType());
        Map<String,SysDict> dictMap = DictTool.get(DictEnum.REGION_REGION);
        for (String key : dictMap.keySet()){
            if(i18nMap.containsKey(key)) {
                String i18n = i18nMap.get(dictMap.get(key).getDictCode()).toString();
                dictMap.get(key).setRemark(i18n);
            }else
            {
                LOG.error("缺少字典国际化Key1:"+key);
            }
        }
        return JsonTool.toJson(dictMap.values());
    }

    @RequestMapping("/states/{region}")
    @ResponseBody
    public String states(@PathVariable("region") String region){
         if(StringTool.isBlank(region))
            return region;
        Map<String, SysDict> dictMap = DictTool.getDict(DictEnum.REGION_STATE.getModule().getCode(),region);
        List<SysDict> states= CollectionQueryTool.andQuery(dictMap.values(), ListTool.newArrayList(new Criterion(SysDict.PROP_DICT_TYPE, Operator.EQ, region)), Order.asc(SysDict.PROP_ORDER_NUM));
        Map i18nMap = I18nTool.getDictsMap(SessionManagerBase.getLocale().toString()).get(DictEnum.REGION_STATE.getModule().getCode()).get(region);
        if(i18nMap==null){
            LOG.error("缺少字典国际化Key:"+region);
            return "[]";
        }
        for (SysDict state : states) {
            if(i18nMap.containsKey(state.getDictCode())) {
                String i18n = i18nMap.get(state.getDictCode()).toString();
                dictMap.get(state.getDictCode()).setRemark(i18n);
            }else
            {
                LOG.error("缺少字典国际化Key:"+state.getDictCode());
            }
        }
        if(states.size()==1){
            "null".equals(states.get(0).getDictCode());
            return "[]";
        }
        return JsonTool.toJson(states);
    }

    @RequestMapping("/cities/{region}-{state}")
    @ResponseBody
    public String cities(@PathVariable("region") String region,@PathVariable("state") String state){
        if(StringTool.isBlank(region))
            return "[]";
        if(StringTool.isBlank(state)){
            state="null";
        }
        String stateKey=region+"_"+state;
        Map<String, SysDict> dictMap = DictTool.getDict(DictEnum.REGION_CITY.getModule().getCode(), stateKey);
        List<SysDict> cities=CollectionQueryTool.query(dictMap.values(), Criteria.add(SysDict.PROP_DICT_TYPE, Operator.EQ, stateKey), Order.asc(SysDict.PROP_ORDER_NUM));
        Map i18nMap = I18nTool.getDictsMap(SessionManagerBase.getLocale().toString()).get(DictEnum.REGION_CITY.getModule().getCode()).get(stateKey);
        for (SysDict city : cities) {
            if(i18nMap.containsKey(city.getDictCode())) {
                String i18n = i18nMap.get(city.getDictCode()).toString();
                dictMap.get(city.getDictCode()).setRemark(i18n);
            }else
            {
                LOG.error("缺少字典国际化Key:"+ city.getDictCode());
            }
        }
        return JsonTool.toJson(cities);
    }

    @RequestMapping("/site")
    @ResponseBody
    public String site(){
        Map<String,SiteOperateArea> list= Cache.getSiteOperateArea(SessionManagerBase.getSiteId());
        Map<String,SysDict> dictMap = DictTool.get(DictEnum.REGION_REGION);
        Map<String,String> i18nMap = I18nTool.getDictsMap(SessionManagerBase.getLocale().toString()).get(DictEnum.REGION_REGION.getModule().getCode()).get(DictEnum.REGION_REGION.getType());
        List<SysDict> siteRegion=new ArrayList<>();
        for (String area : list.keySet()) {
            //使用中
            if("1".equals(list.get(area).getStatus()) && dictMap.containsKey(list.get(area).getCode())) {
                if (i18nMap.containsKey(list.get(area).getCode())) {
                    String i18n = i18nMap.get(list.get(area).getCode()).toString();
                    siteRegion.add(dictMap.get(list.get(area).getCode()));
                    dictMap.get(list.get(area).getCode()).setRemark(i18n);
                } else {
                    LOG.error("缺少字典国际化Key:" + list.get(area).getCode());
                }
            }else{
                LOG.error("缺少字典定义:" + list.get(area).getCode());
            }
        }
        return JsonTool.toJson(siteRegion);
    }

    @RequestMapping("/center")
    @ResponseBody
    public String center(){
        Map<String,SiteOperateArea> list= Cache.getSiteOperateArea(CommonContext.get().getSiteParentId());
        Map<String,SysDict> dictMap = DictTool.get(DictEnum.REGION_REGION);
        Map<String,String> i18nMap = I18nTool.getDictsMap(SessionManagerBase.getLocale().toString()).get(DictEnum.REGION_REGION.getModule().getCode()).get(DictEnum.REGION_REGION.getType());
        List<SysDict> siteRegion=new ArrayList<>();
        for (String area : list.keySet()) {
            //使用中
            if("1".equals(list.get(area).getStatus()) && dictMap.containsKey(list.get(area).getCode())) {
                if (i18nMap.containsKey(list.get(area).getCode())) {
                    String i18n = i18nMap.get(list.get(area).getCode()).toString();
                    siteRegion.add(dictMap.get(list.get(area).getCode()));
                    dictMap.get(list.get(area).getCode()).setRemark(i18n);
                } else {
                    LOG.error("缺少字典国际化Key:" + list.get(area).getCode());
                }
            }else{
                LOG.error("缺少字典定义:" + list.get(area).getCode());
            }
        }
        return JsonTool.toJson(siteRegion);
    }
}
