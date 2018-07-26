package com.lc.xljk.billno;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.lc.xljk.dao.mapper.billno.BillNoMapper;
import com.lc.xljk.pub.lang.LCDateTime;
import com.lc.xljk.vo.billno.BillnoVO;

/**
 * 单据号生成规则，这里要支持并发保证唯一
 * 
 * @author lisq
 * @date 2018年7月21日
 */
@Configuration
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
		BillnoVO billVO = new BillnoVO();
		billVO.setCreatetime(time.toString());
		billVO.setCodetype("USERCODE");
		billNoMapper.insert(billVO);
		int max = billNoMapper.getMax();
		return "LCUC"+max;
	}
	
	public static String createRandom(int ws) {
		String cs = "0";
		for (int i = 0; i < ws - 1; i++) {
			cs = cs + "0";
		}
		cs = "1" + cs;
		int stochastic = new Double(Math.random() * Integer.valueOf(cs)).intValue();

		String temp = "%0" + ws + "d";
		String stocha = String.format(temp, stochastic);
		return stocha;
	}
	
	public static void main(String[] args) {
		System.out.println(createRandom(4));
	}
}
