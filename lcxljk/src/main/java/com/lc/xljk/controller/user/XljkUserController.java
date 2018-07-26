package com.lc.xljk.controller.user;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lc.xljk.controller.AbsXljkController;
import com.lc.xljk.exception.BusinessException;
import com.lc.xljk.service.user.XljkUserService;
/**
 * 用户注册
 * 
 * @author lisq
 * @date 2018年7月21日
 */
@Controller
@RequestMapping("/user")
public class XljkUserController extends AbsXljkController{
	@Autowired
	private XljkUserService userService;
	@RequestMapping("/add")
	@ResponseBody
	public String addUser(@NotNull @RequestParam("telNo") String telNo,@RequestHeader("appsession")String appsession) throws BusinessException{
		return userService.addUserAction(telNo,appsession);
	}
}
