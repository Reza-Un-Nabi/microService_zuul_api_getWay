package com.example.zuul.proxy.filter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.ribbon.support.RibbonCommandContext;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import ch.qos.logback.classic.Logger;

public class ErrorFilter extends ZuulFilter{
	
	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Using Error Filter");
		RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponseStatusCode(); 		
        System.out.println("Using Error Filter1..............."+ctx.getResponseStatusCode());
        System.out.println("Using Error Filter2..............."+ctx.getResponse().getHeaderNames());
        System.out.println("Using Error Filter3..............."+ctx.getResponse().getStatus());
        RequestContext context = RequestContext.getCurrentContext();
       
        return null;
	}
	
	
	
}
