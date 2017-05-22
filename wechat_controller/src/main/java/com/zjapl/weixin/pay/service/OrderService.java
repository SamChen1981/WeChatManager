package com.zjapl.weixin.pay.service;

import com.zjapl.weixin.transfer.bean.QueryOrderResult;

public interface OrderService {

	/**
	 * 根据订单号查询订单
	 * @param orderNum
	 * @return state
	 */
	public String queryOrder(String orderNum);
	
	
	/**
	 * 通知支付结果
	 */
	public void notifyPayResult(QueryOrderResult orderResult);
	
	
}
