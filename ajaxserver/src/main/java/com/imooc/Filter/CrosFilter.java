package com.imooc.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class CrosFilter extends OncePerRequestFilter {



	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//过滤请求，在这里可以验证用户的合法性
		httpServletRequest.getRequestDispatcher("/NoAuthority").forward(httpServletRequest, httpServletResponse);


		//HttpServletResponse res = (HttpServletResponse) httpServletResponse;
		
		//HttpServletRequest req = (HttpServletRequest) httpServletResponse;
		
		String origin = httpServletRequest.getHeader("Origin");
		
		if (!org.springframework.util.StringUtils.isEmpty(origin)) {
			//带cookie的时候，origin必须是全匹配，不能使用*
			httpServletResponse.addHeader("Access-Control-Allow-Origin", origin);
		}

		httpServletResponse.addHeader("Access-Control-Allow-Methods", "*");
		
		String headers = httpServletRequest.getHeader("Access-Control-Request-Headers");
		
		// 支持所有自定义头
		if (!org.springframework.util.StringUtils.isEmpty(headers)) {
			httpServletResponse.addHeader("Access-Control-Allow-Headers", headers);
		}

		httpServletResponse.addHeader("Access-Control-Max-Age", "3600");
		
		// enable cookie
		httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");

		//filterChain.doFilter(httpServletRequest, httpServletResponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
