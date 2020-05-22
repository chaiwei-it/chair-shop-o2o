package com.mood.user.service;

import com.mood.base.BaseVO;
import com.mood.user.service.command.LoginCommand;
import com.mood.user.service.vo.AdminVO;

/**
 * 应用模块
 * @author chaiwei
 * @time 2018-01-07 下午08:00
 */
public interface AdminService {

//    public Admin insert(Admin request);
//
//    public Admin update(Admin request);
//
//    public void delete(Admin request);
//
//    public Admin select(Admin request);
//
    public AdminVO selectById(Integer id);
//
//    public Admin selectList(Admin request);
//
//    public Admin selectPager(Admin request);
//
//    /**
//     * 注册
//     * @param request
//     * @return
//     */
//    public RegisterResponse register(RegisterRequest request);

    /**
     * 登录接口
     * @param request
     * @return
     */
    public BaseVO login(LoginCommand request);

    /**
     * 根据手机号获取用户
     * @param username
     * @return
     */
    public AdminVO selectByUsername(String username);
}
