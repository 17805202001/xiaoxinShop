package com.czxy.xxs.zuul;

import com.czxy.xxs.config.FilterProperties;
import com.czxy.xxs.config.JwtProperties;
import com.czxy.xxs.util.JwtUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
@EnableConfigurationProperties({JwtProperties.class, FilterProperties.class})

public class LoginFilter extends ZuulFilter {


    @Autowired
    private JwtProperties jwtProperties;
    @Resource
    private FilterProperties filterProperties;

    private static  final Logger logger= Logger.getLogger(LoginFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        //获得请求路径
        //3.1获得上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //3.2获得request
        HttpServletRequest request = currentContext.getRequest();
        //3.3获得路径 /v1/auth-service/login
        String requestURI = request.getRequestURI();
        //如果路径为登录
        for(String path : filterProperties.getAllowPaths()){
            //  /v1/auth-service/login  --> ["","v1","auth-service","login"]
            String[] pathArr = requestURI.split("/");
            //只要有一个路径匹配的，过滤器不执行
            if(path.equals("/" + pathArr[3])){

                return false;
            }
        }
        //其他的执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();

        String token = request.getHeader("Authorization");
        try {
            JwtUtils.getInfoFromToken(token,jwtProperties.getPublicKey());
        } catch (Exception e) {
            currentContext.addOriginResponseHeader("content-type","text/html;charset=UTF-8");
            currentContext.addZuulResponseHeader("content-type","text/html;charset=UTF-8");
            currentContext.setResponseStatusCode( 403 );        //响应的状态码：403
            currentContext.setResponseBody("token失效或无效");
            currentContext.setSendZuulResponse( false );        //没有响应内容

        }
        return null;
    }

}
