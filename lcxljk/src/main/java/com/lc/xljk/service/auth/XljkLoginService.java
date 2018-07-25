package com.lc.xljk.service.auth;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.xljk.dao.mapper.session.SessionMapper;
import com.lc.xljk.exception.BusinessException;
import com.lc.xljk.pub.XljkClientTools;
import com.lc.xljk.pub.lang.LCDateTime;
import com.lc.xljk.service.AbsXljkService;
import com.lc.xljk.vo.session.SessionVO;
@Service
public class XljkLoginService extends AbsXljkService{
	@Autowired
	private SessionMapper userMapper;
	public String doLogin(Map<String,Object> result) throws BusinessException{
		//1.先查到:根据openid查到用户
		SessionVO userVO = userMapper.getOneByOpenID((String)result.get(__S_OPENID));
		if(userVO != null) {
			//2.1 有就更新：sessionkey 返回：appsession
			userVO.setSessionkey((String)result.get(__S_SESSIONKEY));
			userVO.setLastvisittime(new LCDateTime(new Date()).toString());
			userMapper.update(userVO);
		} else {
			//2.2 没有就新增条，返回appsession
			userVO = createNewUser(result);
		}
		return  userVO.getAppsession();
	}
	
	public String doCheckSession(String appsession) {
		SessionVO userVO = userMapper.getOneByAppsession(appsession);
		if(userVO != null) {
			return appsession;
		}
		return null;
	}
	
	
	private SessionVO createNewUser(Map<String,Object> result) {
		SessionVO user = new SessionVO();
		user.setAppsession(XljkClientTools.getUUID().replace("-", ""));
		user.setCreatetime(new LCDateTime(new Date()).toString());
		user.setLastvisittime(new LCDateTime(new Date()).toString());
		user.setOpenid((String)result.get(__S_OPENID));
		user.setSessionkey((String)result.get(__S_SESSIONKEY));
		user.setSkey(getProgramConfig().getSkey());
		userMapper.insert(user);
		return user;
	}
}
