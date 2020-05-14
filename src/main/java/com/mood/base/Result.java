package com.mood.base;

/**
 * Created by shihan on 2020/2/17.
 */
public class Result {

    /**
     * 因为服务异常响应 失败
     * @param stateCode 响应信息
     * @return
     */
    public static  <T> BaseVO Result(StateCode stateCode) {
        BaseVO baseVO = new BaseVO();
        baseVO.setStateCode(stateCode.getCode());
        baseVO.setMsg(stateCode.getDesc());
        return baseVO;
    }


    /**
     * 因为服务异常响应 失败
     * @param stateCode 响应信息
     * @return
     */
    public static  <T> BaseVO Result(StateCode stateCode,T t) {
        BaseVO baseVO = new BaseVO();
        baseVO.setStateCode(stateCode.getCode());
        baseVO.setMsg(stateCode.getDesc());
        baseVO.setData(t);
        return baseVO;
    }

    /**
     * 因为服务异常响应 失败
     * @param stateCode 响应信息
     * @return
     */
    public static  <T> BaseVO Result(T t) {
        BaseVO baseVO = new BaseVO();
        baseVO.setStateCode(StateCode.SUCCESS.getCode());
        baseVO.setMsg(StateCode.SUCCESS.getDesc());
        baseVO.setData(t);
        return baseVO;
    }

}
