package com.jiangdaxian.seckill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiangdaxian.seckill.api.SeckillApi;


@Service
public class SeckillService {
	@Autowired
	private SeckillApi seckillApi;
	
	/**
	 * http请求，抢购资格
	 * @param seckillActivityMongoId
	 * @param goodsSkuId
	 * @param userId
	 * @throws Exception
	 */
	public void addQualification(String seckillActivityMongoId,Long goodsSkuId,Long userId) throws Exception {
		seckillApi.addQualification(seckillActivityMongoId, goodsSkuId, userId);
	}
}
