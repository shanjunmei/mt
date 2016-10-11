package com.lanhun.framework.utils;

import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemPropertyUtils {
	
	protected final static Logger logger=LoggerFactory.getLogger(SystemPropertyUtils.class);

	/**
	 * @author Administrator
	 * @date: 2013-11-21
	 * @param args 
	 * @exception 
	 * @description:
	 */
	public static void main(String[] args) {
		
		printSystemProperties();
	}

	public static String getMemoryInfo() {
		StringBuilder sb=new StringBuilder();
		Runtime runtime=Runtime.getRuntime();
		sb.append("***************** BEGIN MEMORY STATISTICS **************************").append("\n");  
		sb.append("Free Memory: "+runtime.freeMemory()/(1024*1024)+"MB").append("\n");  
		sb.append("Max   Memory: "+runtime.maxMemory()/(1024*1024)+"MB").append("\n");  
		sb.append("Total Memory: "+runtime.totalMemory()/(1024*1024)+"MB").append("\n");  
		sb.append("Available Processors : "+runtime.availableProcessors()+"").append("\n"); 
		sb.append("********************* END MEMORY STATISTICS **************************").append("\n");
		return sb.toString();
	}

	public static String getSystemProperties(){
		StringBuilder sb=new StringBuilder();
		Properties properties=System.getProperties();
		for (Entry<Object,Object> entry : properties.entrySet()) {
			sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
		}
		return sb.toString();
	}
	public static void printSystemProperties(){
		System.out.println(getSystemProperties()+"\n"+getMemoryInfo());
	}
	
	public static void logSystemProperties(){
		logger.info(getSystemProperties()+"\n"+getMemoryInfo());
	}
}
