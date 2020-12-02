package com.chair.user.controller;

import com.chair.annotation.LoginRequired;
import com.chair.base.BaseController;
import com.chair.base.BaseVO;
import com.chair.user.controller.notes.LoginNote;
import com.chair.user.controller.param.LoginParam;
import com.chair.user.service.AdminService;
import com.chair.user.service.command.LoginCommand;
import com.chair.user.service.vo.AdminInfo;
import com.chair.user.service.vo.AdminVO;
import com.chair.utils.OrikaMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @time 2020-11-18 10:00
 */
@RestController
@RequestMapping(value = "/api/v1")
public class LoginController extends BaseController{

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = LoginNote.TITLE, notes = LoginNote.NOTES)
    @PostMapping("login")
    public BaseVO create(@Valid @RequestBody LoginParam request){
        return adminService.login(OrikaMapper.map(request, LoginCommand.class));
    }

    @ApiOperation(value = LoginNote.TITLE, notes = LoginNote.NOTES)
    @PostMapping("info")
    @LoginRequired
    public AdminInfo info(HttpServletRequest request
                          ){
        Integer adminId = getUserId(request);
        AdminVO adminVO = adminService.selectById(adminId);
        return OrikaMapper.map(adminVO, AdminInfo.class);
    }

}
