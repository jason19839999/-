package com.imooc;

import com.imooc.Filter.CrosFilter;
import com.imooc.Filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AjaxserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AjaxserverApplication.class, args);
    }

    //拦截所有接口
//    @Bean
//    public FilterRegistrationBean registerFilter() {
//        FilterRegistrationBean bean = new FilterRegistrationBean();
//        bean.addUrlPatterns("/*");
//        bean.setFilter(new CrosFilter());
//        return bean;
//    }

    //拦截指定的接口
    @Bean
    public FilterRegistrationBean tokenFilter(){
        TokenFilter filter =  new TokenFilter();
        String [] arras = {"/get1"};  //拦截/get1
        return filtersGen(filter, Arrays.asList(arras),null, "tokenFilter", 1);
    }

    @Bean
    public FilterRegistrationBean crosFilter(){
        CrosFilter filter =  new CrosFilter();
        String [] arras = {"/get1"};  //拦截/get1
        return filtersGen(filter, Arrays.asList(arras),null, "tokenFilter", 1);
    }


    private FilterRegistrationBean filtersGen(Filter filter, List<String> uris, Map<String,String> params, String name, int order){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);

        if(uris != null && uris.size() > 0) {
            for(String uri : uris)
                registration.addUrlPatterns(uri);
        }

        if(params != null && params.size() > 0) {
            for(Map.Entry<String,String> entry : params.entrySet()){
                registration.addInitParameter(entry.getKey(),entry.getValue());
            }

        }

        registration.setName(name);
        registration.setOrder(order);
        return registration;
    }

}
