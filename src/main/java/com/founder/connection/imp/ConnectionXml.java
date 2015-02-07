package com.founder.connection.imp;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.connection.ifc.ConnectionTest;
import com.founder.entity.ConnectionCfg;
import com.founder.impl.sdk.XDBDataSource;

public class ConnectionXml extends ConnectionTest {

	private XQDataSource dataSource = null;
	private XQConnection xConn = null;
	private XQExpression xExpression = null;
	private Log logger = LogFactory.getLog(ConnectionXml.class);
	public ConnectionXml(ConnectionCfg cfg){
		this.cfg=cfg;
	}

	/**
	 * 功能说明：初始化xml数据库
	 * @author liuqp
	 * @throws XQException
	 */
	public void init() throws XQException {
		
		//xExpression.executeCommand("setAutoCommit on");
		//xExpression.executeCommand("useDatabase SCSC_RT");
	}

	/**
	 * 功能说明：关闭数据库连接
	 * @author liuqp
	 * @throws XQException
	 */
	public void destory() throws XQException {
		if (xConn != null) {
			xConn.close();
		}
		if (xExpression != null) {
			xExpression.close();
		}
	}

	public String connectionTest() {
		String mes = "success";
		try {
			dataSource = new XDBDataSource();
			dataSource.setProperty("SERVERIP", cfg.getAddress());
			dataSource.setProperty("SERVERPORT", cfg.getPort().toString());
			//dataSource.setLoginTimeout(2000);//内部实现会报错
			xConn = dataSource.getConnection(cfg.getConName(), cfg.getConPwd());
			
			xExpression = xConn.createExpression();
			xExpression.executeCommand("setAutoCommit on");
			xExpression.executeCommand("useDatabase SCSC_RT");
			String sql = cfg.getStatement();
			logger.info(cfg);
			xExpression.executeQuery(sql);
		} catch (Exception e) {
			logger.error(e);
			mes = e.toString();
		} finally {
			try {
				this.destory();
			} catch (XQException e) {
				logger.error(e);
				mes = e.toString();
			}
		}
		return mes;
	}
}
