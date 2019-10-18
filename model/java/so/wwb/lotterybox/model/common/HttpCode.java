package so.wwb.lotterybox.model.common;

/**
 * http 状态码
 * Create by Fei on 2018-01-02
 */
public interface HttpCode {

    // 以下为通用错误代码
    /** 请求成功 */
    int OK = 200;

    /** 新资源被创建 */
    int CREATED = 201;

    /** 已接受处理请求但尚未完成（异步处理） */
    int ACCEPTED = 202;

    /** 资源为空 */
    int NONE = 204;

    /** 资源的URI被更新 */
    int MOVED = 301;

    /** 坏请求 */
    int BAD_REQUEST = 400;

    /** 禁止访问 */
    int FORBIT = 401;

    /** 资源不可用 */
    int REJECT = 403;

    /** 资源不存在 */
    int NOT_FOUND = 404;

    /** 服务端不支持所需表示 */
    int NOT_ACCEPTABLE = 406;

    /** 通用冲突 */
    int CONFLICT = 409;

    /** 前置条件失败 */
    int PRECONDITION_FAILED = 412;

    /** 接受到的表示不受支持 */
    int UNSUPPORTED = 415;

    /** 服务器错误 */
    int SERVER_ERROR = 500;

    /** 服务当前无法处理请求 */
    int UNAVAILABLE = 503;

    /** 请求的token已失效 */
    int TOKEN_DUE = 701;

}
