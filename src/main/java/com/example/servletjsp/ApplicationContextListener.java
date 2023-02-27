package com.example.servletjsp;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {

    /**
     * 서블릿 컨텍스트가 파괴될 떄 실행되는 메서드
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("컨텍스트 파괴 직전");
    }

    /**
     * 서블릿 컨텍스트가 생성될 때 실행되는 메서드
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("컨텍스트 생성 직후");
    }

}
