package com.founder.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {
	/** 保存用户指定编码 */
	protected String encoding = null;
	
	/**
	 * 初始化过滤器方法，由系统创建Filter时自动调用 把web.xml中用户指定的编码保存在本类的属性中
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	/**
	 * 执行过滤功能 将参数信息按指定的编码进行转换
	 */
	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		Map parameterMap = req.getParameterMap();
		if (!parameterMap.isEmpty()) {
			Iterator it = parameterMap.keySet().iterator();
			String value[] = null;
			while (it.hasNext()) {
				value = (String[]) parameterMap.get(it.next());
				for (int i = 0; i < value.length; i++) {
					value[i] = new String(value[i].getBytes("ISO-8859-1"),
							encoding);
				}
			}
		}		
		chain.doFilter(req, res);
	}

	/**
	 * 销毁方法，在系统销毁Filter之前由系统自动调用
	 */
	public void destroy() {
		this.encoding = null;
	}
}