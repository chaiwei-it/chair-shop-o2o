package com.mood.base;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-06-04 下午16:00
 */
public class Result {

    /**
     * 因为服务异常响应 失败
     * @param stateCode 响应信息
     * @return
     */
    public static  <T> BaseVO result(StateCode stateCode) {
        BaseVO baseVO = new BaseVO();
        baseVO.setStateCode(stateCode.getCode());
        baseVO.setMsg(stateCode.getMessage());
        return baseVO;
    }


    /**
     * 因为服务异常响应 失败
     * @param stateCode 响应信息
     * @return
     */
    public static  <T> BaseVO result(StateCode stateCode, T t) {
        BaseVO baseVO = new BaseVO();
        baseVO.setStateCode(stateCode.getCode());
        baseVO.setMsg(stateCode.getMessage());
        baseVO.setData(t);
        return baseVO;
    }

    /**
     * 成功
     * @param
     * @return
     */
    public static  <T> BaseVO success(T t) {
        BaseVO baseVO = new BaseVO();
        baseVO.setStateCode(StateCode.SUCCESS.getCode());
        baseVO.setMsg(StateCode.SUCCESS.getMessage());
        baseVO.setData(t);
        return baseVO;
    }

    /**
     * 成功
     * @param
     * @return
     */
    public static  <T> BaseVO success() {
        BaseVO baseVO = new BaseVO();
        baseVO.setStateCode(StateCode.SUCCESS.getCode());
        baseVO.setMsg(StateCode.SUCCESS.getMessage());
        return baseVO;
    }

    /**
     * 因为服务异常响应 失败
     * @param stateCode
     * @return
     */
    public static  <T> BaseVO error(StateCode stateCode) {
        BaseVO baseVO = new BaseVO();
        baseVO.setStateCode(stateCode.getCode());
        baseVO.setMsg(stateCode.getMessage());
        return baseVO;
    }


}
