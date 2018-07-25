package com.lc.xljk.dao.mapper.session;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lc.xljk.vo.session.SessionVO;

public interface SessionMapper {
	@Select("SELECT * FROM lc_sso_session")
    List<SessionVO> getAll();

    @Select("SELECT * FROM lc_sso_session WHERE id = #{id}")
    HashMap<String, Object> getMap(int id);

    @Insert("INSERT INTO lc_sso_session(skey,createtime,lastvisittime,sessionkey,appsession,openid) "
    		+ "VALUES(#{skey}, #{createtime}, #{lastvisittime},#{sessionkey}, #{appsession}, #{openid})")
    void insert(SessionVO user);

    @Update("UPDATE lc_sso_session SET sessionkey=#{sessionkey} WHERE id =#{id}")
    void update(SessionVO user);

    @Delete("DELETE FROM lc_sso_session WHERE id =#{id}")
    void delete(int id);
    
    @Select("SELECT * FROM lc_sso_session WHERE id = #{id}")
    SessionVO getOne(int id);
    
    @Select("SELECT * FROM lc_sso_session WHERE id = #{appsession}")
    SessionVO getOneByAppsession(String appsession);
    
    @Select("SELECT id FROM lc_sso_session WHERE id = #{id}")
    int getId(int id);
    
    @Select("SELECT * FROM lc_sso_session WHERE openid = #{openId}")
    SessionVO getOneByOpenID(String openId);
}
