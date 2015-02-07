package com.founder.action;

import com.alibaba.fastjson.JSON;
import com.founder.common.DbHelperSQLite;
import com.founder.entity.ConnectionLog;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StatusAction {
	private static Log logger=LogFactory.getLog(StatusAction.class);
	public String Preview() {
		return "Preview";
	}
	private String startTime;
	private String endTime;
	public String queryStatusByAjax(){
		DbHelperSQLite dbHelper=new DbHelperSQLite();
		List<ConnectionLog> list=dbHelper.getConLog(startTime,endTime);
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE); 
		PrintWriter res=null;
		try {
			res=response.getWriter();
			res.write(JSON.toJSONString(list));
		} catch (IOException e) {
			logger.error(e);
		}
		res.close();
		return null;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
