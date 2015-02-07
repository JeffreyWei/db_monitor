package com.founder.dbcon;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.common.DbHelperSQLite;
import com.founder.connection.ifc.ConnectionTest;
import com.founder.connection.imp.ConnectionOra;
import com.founder.connection.imp.ConnectionRedis;
import com.founder.connection.imp.ConnectionXml;
import com.founder.entity.ConnectionCfg;

public class DbProperty {
	private static Log logger = LogFactory.getLog(DbProperty.class);
	private static List<ConnectionCfg> cfgs;
	static {

		refreshCfg();
	}

	private static ArrayList<ConnectionTest> conList;

	public static void refreshCfg() {
		DbHelperSQLite sqlite = new DbHelperSQLite();
		cfgs = sqlite.getConCfgs();
	}

	public static ArrayList<ConnectionTest> getCons() {
		conList = new ArrayList<ConnectionTest>();
		for (ConnectionCfg cfg : cfgs) {
			if (StringUtils.equals(cfg.getType(), "Oracle")) {
				conList.add(new ConnectionOra(cfg));
			} else if (StringUtils.equals(cfg.getType(), "Redis")) {
				conList.add(new ConnectionRedis(cfg));
			} else if (StringUtils.equals(cfg.getType(), "Xmldb")) {
				conList.add(new ConnectionXml(cfg));
			}
		}
		return conList;
	}
}
