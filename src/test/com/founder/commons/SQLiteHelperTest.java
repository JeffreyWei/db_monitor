package com.founder.commons;

import com.founder.common.DbHelperSQLite;

import junit.framework.TestCase;

public class SQLiteHelperTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testExecNoResult() {
		DbHelperSQLite dh=new DbHelperSQLite();
		//dh.execNoResult("select id,type from T_CON_TYPE");
	}

}
