package com.founder.connection.imp;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.connection.ifc.ConnectionTest;
import com.founder.entity.ConnectionCfg;

import redis.clients.jedis.Jedis;

public class ConnectionRedis extends ConnectionTest {
	private final String redisStatus = "TestRedisStatus";
	private static Log logger = LogFactory.getLog(ConnectionRedis.class);
	public ConnectionRedis(ConnectionCfg cfg){
		this.cfg=cfg;
	}
	public String connectionTest() {
		String mes="success";
		try {
			Jedis jedis = new Jedis(cfg.getAddress(), cfg.getPort());
			jedis.set(redisStatus, "OK");
			String value = jedis.get(redisStatus);
			if (StringUtils.equals(value, "OK")){
				jedis.del(redisStatus);
			}else {
				mes="Get wrong value from redis";
			}
		} catch (Exception e) {
			logger.error(e);
			mes=e.toString();
		}
		return mes;
	}
}
