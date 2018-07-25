package com.lc.xljk.dao.mapper.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.lc.xljk.vo.user.UserVO;

public interface UserMapper {
	 @Select("SELECT * FROM lc_sm_user WHERE userid = #{telNo}")
	 UserVO getOneByTelNo(String telNo);
	 @Insert("INSERT INTO lc_sm_user(createtime,userid,usercode,appsession) VALUES(#{createtime}, #{userid},#{usercode}, #{appsession})")
	 void insertUserVO(UserVO userVO);
}
