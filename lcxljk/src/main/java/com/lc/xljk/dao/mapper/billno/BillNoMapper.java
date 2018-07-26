package com.lc.xljk.dao.mapper.billno;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.lc.xljk.vo.billno.BillnoVO;

public interface BillNoMapper {
	@Select("SELECT max(id) FROM lc_pub_billno ")
	public int getMax();
	@Insert("INSERT INTO lc_pub_billno(createtime,codetype ) values( #{createtime}, #{codetype})")
	public void insert(BillnoVO billnoVO);
}
