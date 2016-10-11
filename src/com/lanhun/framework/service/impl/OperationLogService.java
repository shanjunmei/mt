package com.lanhun.framework.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.lanhun.framework.orm.dao.IOperationLogDao;
import com.lanhun.framework.orm.po.OperationLog;
import com.lanhun.framework.orm.po.User;
import com.lanhun.framework.service.IOperationLogService;
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service
public class OperationLogService extends BaseService<OperationLog, String> implements IOperationLogService{

	@Resource
	private IOperationLogDao dao;
	@Override
	protected IOperationLogDao getDao() {
		return dao;
	}
	@Override
	public void addLog(String module,String operation,String content,User user) {
		OperationLog log=new OperationLog();
		log.setContent(content);
		log.setModule(module);
		log.setOperation(operation);
		log.setCreatedTime(new Date());
		log.setLastModifyTime(new Date());
		if(user!=null){
			log.setCreator(user);
			log.setLastModifier(user);
		}
		getDao().save(log);
		
	}
	@Override
	public void addLog(String module,String operation,String content) {
		addLog(module,operation,content,(User) null);
	}
	@Override
	public void addLog(String module,String operation,String content, HttpSession session) {
		User user=(User)session.getAttribute("CURRENT_lOGIN_USER");
		addLog(module,operation, content,user);
	}
	@Override
	public void addLog(String content) {
		addLog(null,null,content);
		
	}
	@Override
	public void addLog(String content, User user) {
		addLog(null, null, content, user);
		
	}
	@Override
	public void addLog(String content, HttpSession session) {
		addLog(null, null, content, session);
		
	}

	
}
