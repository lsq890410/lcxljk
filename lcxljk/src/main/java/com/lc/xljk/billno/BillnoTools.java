package com.lc.xljk.billno;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.lc.xljk.dao.mapper.billno.BillNoMapper;
import com.lc.xljk.pub.lang.LCDateTime;

/**
 * 单据号生成规则，这里要支持并发保证唯一
 * 
 * @author lisq
 * @date 2018年7月21日
 */
public class BillnoTools {
	@Autowired
	private BillNoMapper billNoMapper;
	/**
	 * 这里先简单用锁支持并发，集群下就要开始考虑用分布式锁了
	 * @return String 
	 * @author lisq
	 * @date 2018年7月21日
	 */
	public synchronized String getUserCode() {
		LCDateTime time =new LCDateTime(new Date());
		billNoMapper.insert(time.toString(), "USERCODE");
		int max = billNoMapper.getMax();
		return "LCUC"+max;
	}
}
