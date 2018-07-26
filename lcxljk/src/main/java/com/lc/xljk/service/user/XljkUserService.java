package com.lc.xljk.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.xljk.billno.BillnoTools;
import com.lc.xljk.dao.mapper.user.UserMapper;
import com.lc.xljk.exception.BusinessException;
import com.lc.xljk.pub.XljkClientTools;
import com.lc.xljk.vo.user.UserVO;

@Service
public class XljkUserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BillnoTools billNoTools;
	public String addUserAction(String telNo,String appsession) throws BusinessException {
		//	1. 判断用户存在不存在
		UserVO userVO = userMapper.getOneByTelNo(telNo);
		//  2. 存在提示用户已经存在
		if(userVO!= null) {
			throw new BusinessException(telNo+" 已经被注册！");
		}
		//  3. 不存在注册用户并且返回用户编码
		userVO = new UserVO();
		userVO.setTelno(telNo);
		userVO.setUsercode(billNoTools.getUserCode());
		userVO.setUserid(XljkClientTools.getUUID());
		userVO.setAppsession(appsession);
		userMapper.insertUserVO(userVO);
		return userVO.getUsercode();
	}
}
