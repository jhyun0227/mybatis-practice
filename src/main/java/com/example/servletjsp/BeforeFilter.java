package com.example.servletjsp;

import javax.servlet.*;
import java.io.IOException;

public class BeforeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("필터체인을 거치기 전");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("필터체인을 거친 후");
    }
}
