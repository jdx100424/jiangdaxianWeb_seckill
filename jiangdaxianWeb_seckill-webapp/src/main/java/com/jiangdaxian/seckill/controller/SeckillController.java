package com.jiangdaxian.seckill.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jiangdaxian.seckill.service.SeckillService;

@Controller
public class SeckillController {
	private static final Logger LOG = LoggerFactory.getLogger(SeckillController.class);
	
	@Autowired
	private SeckillService seckillService;
	
	@RequestMapping("/seckillQualification")
	@ResponseBody
	public String seckillQualification(@RequestParam String seckillActivityMongoId,@RequestParam Long goodsSkuId) throws Exception {
		try {
			seckillService.addQualification(seckillActivityMongoId, goodsSkuId, Long.parseLong(Integer.toString(new Random().nextInt(150))));
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", 200);
			return JSONObject.toJSONString(map);
		}catch(Exception e) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("code", 99999);
			return JSONObject.toJSONString(map);
		}
	}
}
