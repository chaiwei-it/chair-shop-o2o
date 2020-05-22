package com.mood.base;


import com.mood.content.OauthContants;
import com.mood.user.service.vo.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class BaseController {

	@Autowired
	private RedisTemplate redisTemplate;


	public static final String project_id = "640FAAA324A25C3AE41B9D9A6658DAD2";

	public static final String role_admin_name = "ROLE_ADMIN";

	public AdminVO getLoginUser(HttpServletRequest request) {
		String access_token = request.getHeader("x-access-token");
		AdminVO admin = (AdminVO)redisTemplate.opsForValue().get(OauthContants.ACCESS_TOKEN + access_token);
		return admin;
	}

	// 获取登录用户id
	public Integer getUserId(HttpServletRequest request) {
		return Optional.ofNullable((Integer) request.getAttribute("userId")).orElse(0);
	}




}
