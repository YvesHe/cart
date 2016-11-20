/**   
 * Filename:    Encoding.java   
 * Copyright:   Copyright (c)2016  
 * Company:     Yves  
 * @version:    1.0    
 * Create at:   2016-11-19 下午4:57:06   
 * Description:  
 *
 * Author       Yves He 
 */
package cn.com.yves.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

    private FilterConfig filterConfig;

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        /* 设置工程编码 */
        request.setCharacterEncoding(filterConfig
                .getInitParameter("requestEncoding"));
        response.setContentType(filterConfig
                .getInitParameter("responseEncoding"));

        chain.doFilter(request, response);// 继续传递过滤器
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

}
