package com.lc.xljk.dao.mapper.billno;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface BillNoMapper {
	@Select("SELECT max(id) FROM lc_pub_billno ")
	public int getMax();
	@Insert("INSERT INTO lc_pub_billno(createtime,codetype )values( #{createtime}, #{codetype})")
	public void insert(String createtime,String codetype);
}
