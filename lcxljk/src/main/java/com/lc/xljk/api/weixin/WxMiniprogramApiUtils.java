package com.lc.xljk.api.weixin;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.lc.xljk.conf.XljkProgramConfig;
import com.lc.xljk.exception.BusinessException;
import com.lc.xljk.pub.IXljkConstance;
import com.lc.xljk.utils.HttpClientUtil;
import com.lc.xljk.utils.LcJsonUtils;

/**
 * 微信小程序API
 * 
 * @author lisq
 * @date 2018年7月14日
 */
@Configuration
public class WxMiniprogramApiUtils {
	
	public WxMiniprogramApiUtils() {
		
	}
	@Autowired
	private XljkProgramConfig wxServerConfig;
	/**
	 * 执行小程序后端认证
	 * @return Map<String,String> 
	 * @author lisq
	 * @date 2018年7月14日
	 */
	public HashMap<String,Object> doWxApilogin(String requestCode) throws BusinessException{
		if(Boolean.valueOf(wxServerConfig.getMock()).booleanValue()) {
			HashMap<String,Object> weixinMock = new HashMap<String, Object>();
			weixinMock.put(IXljkConstance.__S_OPENID, UUID.randomUUID());
			return weixinMock;
		}
		String url = wxServerConfig.getWxsessionurl()+"?grant_type=authorization_code&appid="+wxServerConfig.getAppid()
				+"&secret="+wxServerConfig.getAppsecret()+"&js_code="+requestCode;
		String result =  HttpClientUtil.doHttpGet(url, null);
		return LcJsonUtils.toJavaObject(result, HashMap.class);
	}
	
}
