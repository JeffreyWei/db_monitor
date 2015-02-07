package com.founder.quartzjob;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class DbMonitor implements Job {
	private static Log logger = LogFactory.getLog(DbMonitor.class);

	public void execute(JobExecutionContext context) {
//		if (ConfigParameter.getIsValid()) {
//			ConnTestFactory fac = new ConnTestFactory();
//			fac.dbStatus();
//		}
//		logger.info((new Date()).toString());
	}
	
}

