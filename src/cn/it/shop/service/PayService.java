package cn.it.shop.service;

import java.util.Map;

import cn.it.shop.model.SendData;

public interface PayService {
	public Map<String, Object> saveDataToRequest(Map<String, Object> request,
			SendData sendData);
}
