package com.founder.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.entity.ConnectionCfg;
import com.founder.entity.ConnectionLog;

public class DbHelperSQLite {
	private static Log logger = LogFactory.getLog(DbHelperSQLite.class);
	private Connection connection = null;
	private Statement statement = null;
	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
	}

	public void executeSql(String sqlStr) {
		try {
			initSqliteConn();
			statement.executeQuery(sqlStr);
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			closeSqliteConn();
		}
	}

	private String sqlitePath() {
		return ConfigParameter.getLoaclDbPath();
	}

	public List<ConnectionCfg> getConCfgsAll() {
		return getConCfgs("");

	}

	public List<ConnectionCfg> getConCfgs() {
		return getConCfgs("T");

	}

	private List<ConnectionCfg> getConCfgs(String valid) {
		List<ConnectionCfg> cfgs = new ArrayList<ConnectionCfg>();
		try {
			initSqliteConn();
			String sqlStr = "select * from V_CON_LIST";
			if (!StringUtils.isBlank(valid)) {
				sqlStr += " where valid='" + valid + "'";
			}
			logger.info(sqlStr);
			ResultSet rs = statement.executeQuery(sqlStr);
			while (rs.next()) {
				ConnectionCfg cfg = new ConnectionCfg();
				cfg.setId(rs.getInt(1));
				cfg.setTypeId(rs.getInt(2));
				cfg.setAddress(rs.getString(3));
				cfg.setPort(rs.getInt(4));
				cfg.setInstance(rs.getString(5));
				cfg.setConName(rs.getString(6));
				cfg.setConPwd(rs.getString(7));
				cfg.setStatement(rs.getString(8));
				cfg.setAliasName(rs.getString(9));
				cfg.setValid(rs.getString(10));
				cfg.setType(rs.getString(11));
				logger.info(cfg);
				cfgs.add(cfg);
			}
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			closeSqliteConn();
		}
		logger.info(cfgs);
		return cfgs;
	}

	private void initSqliteConn() {
		try {
			//logger.info(sqlitePath());
			connection = DriverManager.getConnection("jdbc:sqlite:"
					+ sqlitePath());
			statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	private void closeSqliteConn() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	public void insertLog(Integer conid, String success, String date,
			String error, Long timer) {
		try {
			initSqliteConn();
			String sql = "insert into T_CON_LOG (CONID,SUCCESS,DATE,ERROR,CONTIME) values("
					+ conid
					+ ",'"
					+ success
					+ "','"
					+ date
					+ "','"
					+ error
					+ "'," + timer + ")";
			logger.info(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			closeSqliteConn();
		}
	}

	public List<ConnectionLog> getConLog(String startTime, String endTime) {
		List<ConnectionLog> list = new ArrayList<ConnectionLog>();
		initSqliteConn();
		String sqlStr = "select T_CON_CFG.ALIASNAME,sum,fail from ((select CONID,count (1) as sum from T_CON_LOG where date>="
				+ startTime
				+ " and date<="
				+ endTime
				+ " GROUP BY CONID) a LEFT JOIN (SELECT CONID,count(1) as 'fail' FROM T_CON_LOG where date>="
				+ startTime
				+ " and date<="
				+ endTime
				+ " and SUCCESS =='fail' GROUP BY CONID) b on a.CONID=b.CONID) c,T_CON_CFG where c.CONID=T_CON_CFG.ID and T_CON_CFG.VALID='T'";
		logger.info(sqlStr);
		ResultSet rs;
		try {
			rs = statement.executeQuery(sqlStr);
			while (rs.next()) {
				ConnectionLog log = new ConnectionLog();
				log.setAliasName(rs.getString(1));
				log.setSum(rs.getInt(2));
				log.setFail(rs.getInt(3));
				logger.info(log);
				list.add(log);
			}
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			closeSqliteConn();
		}
		return list;
	}
}
