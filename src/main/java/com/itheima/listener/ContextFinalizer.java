package com.itheima.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class ContextFinalizer implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        try {
            while (drivers.hasMoreElements()) {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
                logger.info(" 消除数据库连接驱动 --> : Driver {} deregistered", d);
            }
        } catch (SQLException ex) {
            logger.error("Error: deregistering driver {} exceptionName:{} detail:{}", d, ex.getClass().getName(), ex.getMessage());
        } finally {
                AbandonedConnectionCleanupThread.checkedShutdown();
        }

    }
}
