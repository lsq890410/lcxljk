package com.lc.xljk.controller.smscheck;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lc.xljk.controller.AbsXljkController;
import com.lc.xljk.vo.wxclientresult.WxClientResultVO;
@Controller
@RequestMapping("/sms/send")
public class XljkSmsCheckController extends AbsXljkController{
	public WxClientResultVO sendSmsCheck(@NotNull @RequestParam("telNo") String code) {
		//1.生产 随机编码
		return null;
	}
}
