package com.mood.user.controller;

import com.mood.annotation.LoginRequired;
import com.mood.base.BaseController;
import com.mood.base.BaseVO;
import com.mood.user.controller.notes.LoginNote;
import com.mood.user.controller.param.LoginParam;
import com.mood.user.service.AdminService;
import com.mood.user.service.command.LoginCommand;
import com.mood.user.service.vo.AdminInfo;
import com.mood.user.service.vo.AdminVO;
import com.mood.utils.OrikaMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 模块
 *
 * @author chaiwei
 * @time 2018-06-07 17:21
 */
@RestController
@RequestMapping(value = "/api/v1",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class LoginController extends BaseController{

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = LoginNote.title, notes = LoginNote.notes)
    @PostMapping("login")
    public BaseVO create(@Valid @RequestBody LoginParam request){
        return adminService.login(OrikaMapper.map(request, LoginCommand.class));
    }

//    @ApiOperation(value = LoginNote.title, notes = LoginNote.notes)
//    @PostMapping("info")
//    @LoginRequired
//    public AdminInfo info(HttpServletRequest request
//                          ){
//        Integer adminId = getUserId(request);
//        AdminVO adminVO = adminService.selectById(adminId);
//        return OrikaMapper.map(adminVO, AdminInfo.class);
//    }

}
