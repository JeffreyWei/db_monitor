package com.founder.service;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.founder.common.DbHelperSQLite;
import com.founder.connection.ifc.ConnectionTest;
import com.founder.dbcon.DbProperty;

public class ConnTestFactory {
	
	public void dbStatus(){
		 ArrayList<ConnectionTest> conTestList=DbProperty.getCons();
		 DbHelperSQLite sqlite=new DbHelperSQLite();
		 for (ConnectionTest connectionTest : conTestList) {
			 Integer conid=connectionTest.getCfg().getId();
			 Long timer=System.currentTimeMillis();
			 String res=connectionTest.connectionTest();
			 timer=System.currentTimeMillis()-timer;
			 String date=DateFormatUtils.format(new Date(),"yyyyMMddHHmmss");
			 String success="";
			 String error="";
			 if (StringUtils.equals(res, "success")){
				 success="success";
				 
			 }else {
				success="fail";
				error=res.replaceAll("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]", " ");
			}
			 sqlite.insertLog(conid,success,date,error,timer);
		}
		
	}
	
}
