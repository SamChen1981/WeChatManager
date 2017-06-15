package com.zjapl.weixin.transfer.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URLEncodedUtils;

/**
 * 微信Web授权数据.
 * 与子系统进行交互
 * @author yangb
 *
 */
public class TransferData {

	private String state;
	
	private String openid;
	
	private String data;

	private String scope;
	
	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getData() {
		return data == null ? "{}" : data;
	}

	public void setData(String data) {
		this.data = (data == null ? "{}" : data);
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	/**
	 * 将属性转为JSON格式
	 * @return
	 */
	public String parseJSON(){
		return "{\"state\":\""+ getState() +"\",\"openid\":\""+ getOpenid() +"\",\"user\":"+ getData() +"}";
	}
	
	/**
	 * @return
	 */
	@Deprecated
	public Map<String, String> parseMap(){
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("state", state);
		hashMap.put("openid", openid);
		return hashMap;
	}
	
	/**
	 * 解析参数
	 * @param encode 参数编码
	 * @return
	 */
	public String parseParam(String encode){
		StringBuilder sb = new StringBuilder("?");
		sb.append("openid"); 
		sb.append("=");
		sb.append(getOpenid());
		
		sb.append("&");
		
		sb.append("state"); 
		sb.append("=");
		sb.append(getState());
		
		sb.append("&");
		
		sb.append("data"); 
		sb.append("=");
		try {
			sb.append(URLEncoder.encode(getData(), encode));  //这里的编码需要根据浏览器的编码格式而定
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
}
