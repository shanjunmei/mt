package com.lanhun.framework.utils;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class SystemContextListener
 *
 */
@WebListener
public class SystemContextListener implements ServletContextListener {

	protected Logger logger = LoggerFactory
			.getLogger(SystemContextListener.class);

	/**
	 * Default constructor.
	 */
	public SystemContextListener() {
		logger.info("init ");
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				logger.info(String.format("deregistering jdbc driver: %s",
						driver));
			} catch (SQLException e) {
				logger.info(
						String.format("Error deregistering driver %s", driver),
						e);
			}

		}
		logger.info("driver deregistered");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("contextInitialized");
	}

}
