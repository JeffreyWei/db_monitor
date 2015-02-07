package com.founder.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.common.DbHelperSQLite;



public class LoginFilter implements Filter {
	private static Log logger = LogFactory.getLog(LoginFilter.class);
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		//PrintWriter out = response.getWriter();
		if (session.getAttribute("USER_INFO") == null || session.isNew()) {
			 response.sendRedirect(request.getContextPath()
			 + "/login.jsp");
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void destroy() {

	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
