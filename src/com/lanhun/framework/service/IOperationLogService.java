package com.lanhun.framework.service;

import javax.servlet.http.HttpSession;

import com.lanhun.framework.orm.po.OperationLog;
import com.lanhun.framework.orm.po.User;

public interface IOperationLogService extends IBaseService<OperationLog, String> {

	void addLog(String module,String operation,String content,User user);
	void addLog(String module,String operation,String content);
	void addLog(String module,String operation,String content,HttpSession session);
	void addLog(String content);
	void addLog(String content,User user);
	void addLog(String content,HttpSession session);
}
