package com.lc.xljk.dao.mapper.smscheck;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.lc.xljk.vo.smscheck.SmscheckVO;

public interface SmsCheckMapper {
	 @Insert("INSERT INTO lc_pub_smscheckcode(smscheckid,smscheckcode,createtime,disabletime,telno) "
	    		+ "VALUES(#{smscheckid}, #{smscheckcode}, #{createtime},#{disabletime},#{telno})")
	public void insert(SmscheckVO checkVO);
	 
	@Select("SELECT * FROM lc_pub_smscheckcode WHERE telNo = #{telno} and smscode = #{smscode}")
	public SmscheckVO getOne(String telno,String smscode);
}
