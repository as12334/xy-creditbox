package so.wwb.creditbox.service.manager.gather;

import org.soul.commons.data.json.JsonTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.net.TransmissionProtocol;
import org.soul.commons.net.http.*;
import so.wwb.creditbox.model.enums.lottery.LotteryGatherConfEnum;
import so.wwb.creditbox.model.manager.lottery.LotteryGatherParam;
import so.wwb.creditbox.model.manager.lottery.po.LotteryGatherConf;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultListVo;
import so.wwb.creditbox.model.manager.lottery.vo.LotteryResultVo;

import java.util.Map;

/**
 * Created by mical on 2016/6/27.
 */
public abstract class AbstractLotteryGatherHandle implements ILotteryGatherHandle {
    private static final Log LOG = LogFactory.getLog(AbstractLotteryGatherHandle.class);

    @Override
    public LotteryResultVo doGather(LotteryGatherParam gatherParam) {
        return handleBaseLottery(gatherParam);
    }

    @Override
    public void doValid(LotteryGatherConf gatherConf) {
        String response = doRequest(gatherConf);
        valid(response);
    }

    protected void valid(String response) {
        return;
    }

    protected LotteryResultVo handleBaseLottery(LotteryGatherParam gatherParam) {
        String response = doRequest(gatherParam);
        return handleResponse(gatherParam, response);
    }


    protected String doRequest(LotteryGatherParam gatherParam) {
        String result = null;
        try {
            Map<String, Object> params = JsonTool.fromJson(gatherParam.getLotteryGatherConf().getJsonParam(), Map.class);
            HttpClientParam param = createHttpParam(gatherParam, params);
            HttpAsyncResult async = HttpClientTool.async(param);
            result = async.getString();
        } catch (Exception e) {
            LOG.error(e, "请求失败,参数:{0}", JsonTool.toJson(gatherParam));
        }
        return result;
    }

    protected String doRequest(LotteryGatherConf gatherConf) {
        String result = null;
        try {
            Map<String, Object> params = JsonTool.fromJson(gatherConf.getJsonParam(), Map.class);
            HttpClientParam param = createHttpParam(gatherConf, params);
            HttpAsyncResult async = HttpClientTool.async(param);
            result = async.getString();
        } catch (Exception e) {
            LOG.error(e, "请求失败,参数:{0}", JsonTool.toJson(gatherConf));
        }
        return result;
    }

    protected HttpClientParam createHttpParam(LotteryGatherParam gatherParam, Map<String, Object> params) {
        HttpClientParam httpParam = new HttpClientParam();
        httpParam.setAsync(false);
        LotteryGatherConf lotteryGatherConf = gatherParam.getLotteryGatherConf();
        httpParam.setUrl(lotteryGatherConf.getUrl());
        httpParam.setProtocol(TransmissionProtocol.HTTP);
        httpParam.setMethod(HttpRequestMethod.valueOf(lotteryGatherConf.getMethod()));
        httpParam.setReqContentType(HttpContentType.valueOf(lotteryGatherConf.getRequestContentType()));
        httpParam.setResContentType(HttpContentType.valueOf(lotteryGatherConf.getResponseContentType()));
        httpParam.setParams(params);
        return httpParam;
    }

    protected HttpClientParam createHttpParam(LotteryGatherConf lotteryGatherConf, Map<String, Object> params) {
        HttpClientParam httpParam = new HttpClientParam();
        httpParam.setAsync(false);
        httpParam.setUrl(lotteryGatherConf.getUrl());
        httpParam.setProtocol(TransmissionProtocol.HTTP);
        httpParam.setMethod(HttpRequestMethod.valueOf(lotteryGatherConf.getMethod()));
        httpParam.setReqContentType(HttpContentType.valueOf(lotteryGatherConf.getRequestContentType()));
        httpParam.setResContentType(HttpContentType.valueOf(lotteryGatherConf.getResponseContentType()));
        httpParam.setParams(params);
        return httpParam;
    }

    protected abstract LotteryResultVo handleResponse(LotteryGatherParam gatherParam, String response);

    @Override
    public LotteryResultListVo doCollection(LotteryGatherParam gatherParam) {
        String url = gatherParam.getLotteryGatherConf().getUrl() + "&date=" + gatherParam.getDate();
        if (LotteryGatherConfEnum.fhlm.getCode().equals(gatherParam.getLotteryGatherConf().getAbbrName())) {
            url = gatherParam.getLotteryGatherConf().getUrl();
        }
        gatherParam.getLotteryGatherConf().setUrl(url);
        String response = doRequest(gatherParam);
        return handleResponseForCollection(gatherParam, response);
    }

    protected abstract LotteryResultListVo handleResponseForCollection(LotteryGatherParam gatherParam, String response);

}
