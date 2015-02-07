package com.founder.connection.ifc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.founder.connection.imp.ConnectionOra;
import com.founder.connection.imp.ConnectionRedis;
import com.founder.connection.imp.ConnectionXml;
import com.founder.entity.ConnectionCfg;


public class ConnectionTestTest {
	private ConnectionTest con;
	private ConnectionCfg cfg;
	private static Log logger = LogFactory.getLog(ConnectionTestTest.class);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testOra() {
		cfg = new ConnectionCfg();
		cfg.setAddress("10.16.12.127");
		cfg.setPort(1521);
		cfg.setInstance("orcl");
		cfg.setConName("wcr_trace");
		cfg.setConPwd("oraSCSC0427");
		cfg.setStatement("select 1 from dual");
		con = new ConnectionOra(cfg);
		logger.info(con.connectionTest());
	}
	@Test
	public void testRedis() {
		cfg = new ConnectionCfg();
		cfg.setAddress("10.16.12.134");
		cfg.setPort(6379);
		con = new ConnectionRedis(cfg);
		logger.info(con.connectionTest());
	}
	
	@Test
	public void testXmldb() {
		cfg = new ConnectionCfg();
		cfg.setAddress("10.16.12.127");
		cfg.setPort(8090);
		cfg.setConName("admin");
		cfg.setConPwd("123456");
		cfg.setStatement("doc(\"RT_COLLECTION/TortContents.xml\")/TortContents/TortContent[@worksSampleId=\"1\"]/Content/text()");
		//cfg.setStatement("doc(\"RT_COLLECTION/dual.xml\")/DUMMY/text()");
		con = new ConnectionXml(cfg);
		logger.info(con.connectionTest());
	}
}
