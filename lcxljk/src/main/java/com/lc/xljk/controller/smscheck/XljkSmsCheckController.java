package com.lc.xljk.controller.smscheck;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lc.xljk.billno.BillnoTools;
import com.lc.xljk.controller.AbsXljkController;
import com.lc.xljk.dao.mapper.smscheck.SmsCheckMapper;
import com.lc.xljk.exception.BusinessException;
import com.lc.xljk.pub.XljkClientTools;
import com.lc.xljk.pub.lang.LCDateTime;
import com.lc.xljk.vo.smscheck.SmscheckVO;
import com.lc.xljk.vo.wxclientresult.WxClientResultVO;
@Controller
@RequestMapping("/sms")
public class XljkSmsCheckController extends AbsXljkController{
	private SmsCheckMapper checkMapper;
	
	@RequestMapping("/send")
	@ResponseBody
	public WxClientResultVO sendSmsCheck(@NotNull @RequestParam("telNo") String code) {
		//1.生产 随机编码
		String smscode = BillnoTools.createRandom(4);
		//2.插入数据库
		SmscheckVO check =new SmscheckVO();
		check.setSmscheckcode(smscode);
		check.setSmscheckid(XljkClientTools.getUUID());
		check.setCreatetime(new LCDateTime(new Date()).toString());
		check.setTelno(code);
		checkMapper.insert(check);
		return XljkClientTools.getSuccessObj("smscode", smscode);
	}
	
	@RequestMapping("/check")
	@ResponseBody
	public WxClientResultVO sendSmsCheck(@NotNull @RequestParam("telNo") String code,@NotNull @RequestParam("smscode") String smscode) throws BusinessException {
		SmscheckVO checkVO =checkMapper.getOne(code, smscode);
		if(checkVO == null) {
			throw new BusinessException("验证码输入错误！！！");
		}
		if(new LCDateTime(new Date()).getMillisAfter( new LCDateTime(checkVO.getCreatetime()))>60*1000) {
			throw new BusinessException("验证码已经过期！！！");
		}
		return XljkClientTools.getSuccessObj();
	}
}
