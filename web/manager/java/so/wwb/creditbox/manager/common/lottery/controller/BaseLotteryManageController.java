package so.wwb.creditbox.manager.common.lottery.controller;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.query.Criterion;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Direction;
import org.soul.web.controller.BaseCrudController;
import org.springframework.ui.Model;
import so.wwb.creditbox.common.dubbo.ServiceTool;
import so.wwb.creditbox.iservice.manager.lottery.ILotteryService;
import so.wwb.creditbox.manager.common.lottery.form.LotteryForm;
import so.wwb.creditbox.manager.common.lottery.form.LotterySearchForm;
import so.wwb.creditbox.manager.session.SessionManager;
import so.wwb.creditbox.model.enums.lottery.LotteryClassifyEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryModelEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryStatusEnum;
import so.wwb.creditbox.model.enums.lottery.LotteryTypeEnum;
import so.wwb.creditbox.model.manager.lottery.po.Lottery;
import so.wwb.creditbox.model.manager.lottery.po.LotteryType;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryTypeListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryVo;
import so.wwb.creditbox.web.cache.Cache;
import so.wwb.creditbox.web.tools.AuditAddLogTool;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 彩种管理基类
 * Created by jeremy on 18-4-23.
 */
public class BaseLotteryManageController extends BaseCrudController<ILotteryService, LotteryListVo, LotteryVo, LotterySearchForm, LotteryForm, Lottery, Integer> {
    private static final Log LOG = LogFactory.getLog(BaseLotteryManageController.class);
    /**彩种类型 key*/
    private static final String LOTTERY_TYPE = "lotteryType";
    /**彩种模式 key*/
    private static final String LOTTERY_MODEL = "lotteryModel";
    /**彩种状态 key*/
    private static final String LOTTERY_STATUS = "lotteryStatus";

    private static final String COMMAND = "command";

    //审计日志相关
    protected final static String LOTTERY_GENRE_SUCCESS ="lottery.genre.success";
    protected final static String LOTTERY_SORT_SUCCESS = "lottery.sort.success";
    protected final static String LOTTERY_SYNC_SUCCESS = "lottery.sync.success";
    protected final static String LOTTERY_TAKE_OFF_SUCCESS = "lottery.take.off.success";
    protected final static String LOTTERY_STATUS_SUCCESS = "lottery.status.success";
    protected final static String LOTTERY_ADD_OR_UPDATE_SUCCESS = "lottery.add.or.update.success";
    protected final static String LOTTERY_UPDATE_SUCCESS = "lottery.update.success";
    protected final static String LOTTERY_DELETE_SUCCESS = "lottery.delete.success";
    private final static String LOTTERY_IS_HOT = "lottery.isHot.success";
    private final static String LOTTERY_IS_NEW = "lottery.isNew.success";

    @Override
    protected String getViewBasePath() {
        return "";
    }


    /**
     * 设置默认列表数据 彩种类型、彩种模式、彩种状态
     * @param model
     * @return
     */
    protected void defaultListData(Model model){
        model.addAttribute(LOTTERY_TYPE, Cache.getLotteryType());
        model.addAttribute(LOTTERY_MODEL, EnumTool.getEnumMap(LotteryModelEnum.class));
        model.addAttribute(LOTTERY_STATUS, EnumTool.getEnumMap(LotteryStatusEnum.class));
    }
    /**
     * 设置列表查询参数
     * @param listVo
     */
    protected void queryListParams(LotteryListVo listVo){
        listVo.getQuery().addOrder(Lottery.PROP_ORDER_NUM, Direction.ASC);
    }

    /**
     * 获取排序数据
     * @param siteId 站点id
     * @param model
     */
    protected void sortListData(Integer siteId, Model model){
        LotteryListVo listVo = new LotteryListVo();
        listVo.getSearch().setSiteId(siteId);
        listVo.getQuery().addOrder(Lottery.PROP_ORDER_NUM,Direction.ASC);
        listVo.setPaging(null);
        model.addAttribute(COMMAND, ServiceTool.lotteryService().search(listVo));
    }

    /**
     * 设置站点
     * @return
     */
    protected Integer siteIdParam(String siteId){
        Integer site;
        if(StringTool.isEmpty(siteId)){
            site = SessionManager.getSiteId();
        }else {
            site = Integer.valueOf(siteId);
        }
        return site;
    }

    /**
     * 设置查询自主彩的参数
     * @param siteId
     * @return
     */
    protected LotteryListVo ownLotteryParam(String siteId){
        LotteryListVo listVo = new LotteryListVo();
        listVo.getSearch().setSiteId(siteIdParam(siteId));
        listVo.getSearch().setClassify(LotteryClassifyEnum.OWN.getCode());
        listVo.getSearch().setStatus(LotteryStatusEnum.NORMAL.getCode());
        return listVo;
    }


    @Override
    protected LotteryVo doCreate(LotteryVo objectVo, Model model) {

        LotteryTypeListVo listVo = new LotteryTypeListVo();
        listVo = ServiceTool.lotteryTypeService().search(listVo);
        model.addAttribute("ltype",listVo);
        return super.doCreate(objectVo, model);
    }


    protected void addAuditLog(LotteryVo objectVo, HttpServletRequest request, String msgKey) {
        try {
            if (objectVo.isSuccess()) {
                List<String> params = new ArrayList<>();
                if (StringTool.equals(LOTTERY_STATUS_SUCCESS, msgKey) || StringTool.equals(LOTTERY_IS_HOT, msgKey) || StringTool.equals(LOTTERY_IS_NEW, msgKey)) {
                    objectVo.getSearch().setId(objectVo.getResult().getId());
                    objectVo = this.getService().get(objectVo);
                }
                params.add(SessionManager.getSiteId().toString());
                if (StringTool.equals(LOTTERY_SORT_SUCCESS, msgKey)) {
                    LotteryListVo listVo = new LotteryListVo();
                    listVo.getSearch().setSiteId(SessionManager.getSiteId());
                    listVo.getQuery().addOrder(Lottery.PROP_ORDER_NUM, Direction.ASC);
                    listVo = this.getService().search(listVo);
                    if (CollectionTool.isNotEmpty(listVo.getResult())) {
                        String infoMsg = "";
                        for (Lottery lottery : listVo.getResult()) {
                            infoMsg += lottery.getName() + "(" + lottery.getOrderNum() + "); ";
                        }
                        params.add(infoMsg);
                        AuditAddLogTool.addLog(request, msgKey, params);
                        return;
                    }
                }
                params.add(objectVo.getResult().getName());
                params.add(objectVo.getResult().getCode());
                if (StringTool.equals(LOTTERY_STATUS_SUCCESS, msgKey)) {
                    params.add(AuditAddLogTool.installEnumMsg(LotteryStatusEnum.class, objectVo.getResult().getStatus()));
                    AuditAddLogTool.addLog(request, msgKey, params);
                    return;
                }
                if (StringTool.equals(LOTTERY_GENRE_SUCCESS, msgKey)) {
                    params.add(AuditAddLogTool.installEnumMsg(LotteryModelEnum.class, objectVo.getResult().getModel()));
                    AuditAddLogTool.addLog(request, msgKey, params);
                    return;
                }
                params.add(objectVo.getResult().getIsNew() ? "是" : "否");
                params.add(objectVo.getResult().getIsHot() ? "是" : "否");
                AuditAddLogTool.addLog(request, msgKey, params);
            }
        } catch (Exception e) {
            LOG.error("保存审计日志出错{0}", e.getMessage());
        }
    }

    /**
     * 全站操作相关审计日志
     *
     * @param listVo
     * @param request
     * @param msgKey
     */
    protected void addAuditLog(LotteryListVo listVo, HttpServletRequest request, String msgKey) {
        try {
            if (listVo.isSuccess()) {
                List<String> params = new ArrayList<>();
                if (StringTool.equals(LOTTERY_TAKE_OFF_SUCCESS, msgKey)) {
                    ArrayList ids = listVo.getLottery();
                    listVo.getQuery().setCriterions(new Criterion[]{
                            new Criterion(Lottery.PROP_ID, Operator.IN, ids)
                    });
                    listVo = this.getService().search(listVo);
                    if (CollectionTool.isNotEmpty(listVo.getResult())) {
                        String names = "";
                        for (Lottery lottery : listVo.getResult()) {
                            names += lottery.getName() + "(" + AuditAddLogTool.installEnumMsg(LotteryModelEnum.class, lottery.getModel()) + "); ";
                        }
                        params.add("全站");
                        params.add(names);
                        AuditAddLogTool.addLog(request, msgKey, params);
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("保存审计日志出错{0}", e.getMessage());
        }
    }

}
