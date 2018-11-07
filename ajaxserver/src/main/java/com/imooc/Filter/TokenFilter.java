package com.imooc.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenFilter extends OncePerRequestFilter {
    private static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    private static final String KEY_CODE_PRE_CONFUSION = "BeijingMiningTechnology";
    private static final String KEY_CODE_END_CONFUSION = "ZunjiaStock";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
         //进行逻辑判断
        //过滤请求，在这里可以验证用户的合法性
//        httpServletRequest.getRequestDispatcher("/NoAuthority").forward(httpServletRequest, httpServletResponse);

    }




}
