package com.kim.ex0803;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class SvlListener
 *
 */
// @WebListener (web.xml에 등록 시 사용 가능)
public class SvlListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SvlListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("contextDestroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("contextInitialized");
    }
	
}
