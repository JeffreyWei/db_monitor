package com.founder.connection.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.connection.ifc.ConnectionTest;
import com.founder.entity.ConnectionCfg;

public class ConnectionOra extends ConnectionTest {
	private static Log logger = LogFactory.getLog(ConnectionOra.class);
	private Connection con = null;// 创建一个数据库连接
	private PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
	private ResultSet result = null;// 创建一个结果集对象

public ConnectionOra(ConnectionCfg c){
	this.cfg=c;
}
	public String connectionTest() {
		String mes = "success";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
			String url = "jdbc:oracle:thin:@" + cfg.getAddress() + ":"
					+ cfg.getPort() + ":" + cfg.getInstance();// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
			String user = cfg.getConName();// 用户名,系统默认的账户名
			String password = cfg.getConPwd();// 你安装时选设置的密码
			con = DriverManager.getConnection(url, user, password);// 获取连接
			String sql = cfg.getStatement();// 预编译语句，“？”代表参数
			pre = con.prepareStatement(sql);// 实例化预编译语句
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			while (result.next())
				logger.info(result.getObject(1).toString());
		} catch (Exception e) {
			logger.error(e);
			mes = e.toString();
		} finally {
			try {
				// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
				// 注意关闭的顺序，最后使用的最先关闭
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				logger.error(e);
				mes = e.toString();
			}
		}
		return mes;
	}
}
