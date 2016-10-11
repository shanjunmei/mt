package com.lanhun.framework.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lanhun.framework.orm.dao.IBaseDao;
import com.lanhun.framework.service.IBaseService;
import com.lanhun.framework.utils.ServiceException;
import com.lanhun.framework.utils.page.EntityViewInfo;
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public abstract class BaseService<T,PK extends Serializable> implements IBaseService<T, PK>{

	protected Logger logger=LoggerFactory.getLogger(getClass());
	public  BaseService() {
		logger.info(" init");
		
	}
	protected IBaseDao<T, PK> getDao(){
		throw new RuntimeException(getClass()+" must implement getDao method");
	}
	@Override
	public T findByPk(PK pk) {
		return getDao().findByPk(pk);
	}

	@Override
	public T save(T intance) {
		return getDao().save(intance);
	}
	
	@Override
	public T modify(T intance) {
		return getDao().modify(intance);
	}

	@Override
	public void deleteByPk(PK pk) {
		 getDao().deleteByPk(pk);
	}

	@Override
	public int disableOrEnable(PK pk) {
		return getDao().disableOrEnable(pk);
		
	}
	@Override
	public List<T> listAll() {
		
		return getDao().listAll();
	}

	@Override
	public List<T> query(EntityViewInfo view) {
		return getDao().query(view);
	}

	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		return getDao().findByProperty(propertyName, value);
	}
	@Override
	public List<T> findAll() {
		return getDao().listAll();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryByHql(String hql){
		return getDao().queryByHql(hql);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> queryBySql(String hql) {
		return getDao().queryBySql(hql);
	}
	@Override
	public int excueteByHql(String hql) {
		return getDao().excueteByHql(hql);
	}
	@Override
	public int excueteBySql(String sql) {
		return getDao().excueteBySql(sql);
	}
	@Override
	public int excueteByHql(String hql, Object[] paramaters) {
		return getDao().excueteByHql(hql, paramaters);
	}
	@Override
	public int excueteBySql(String sql, Object[] paramaters) {
		return getDao().excueteBySql(sql, paramaters);
	}
	@Override
	public List<T> findByCollection(String hql,Collection<?> params) {
		return getDao().findByCollection(hql, params);
	}
	@Override
	public List<T> findByIds( Collection<?> ids) {
		return getDao().findByIds(ids);
	}
	@Override
	public int batchDelete(Collection<PK> pks) {
		int ret=0;
		for (PK pk : pks) {
			try{
				getDao().deleteByPk(pk);
				ret++;
			}catch(ServiceException e){
				logger.info(e.getMessage());
			}
			
		}
		return ret;
	}
}
