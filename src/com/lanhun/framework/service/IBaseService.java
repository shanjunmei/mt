package com.lanhun.framework.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lanhun.framework.utils.page.EntityViewInfo;

public interface IBaseService<T, PK extends Serializable> {
	T findByPk(PK pk);

	T save(T intance);

	void deleteByPk(PK pk);

	List<T> listAll();

	List<T> query(EntityViewInfo view);

	T modify(T intance);

	int disableOrEnable(PK pk);
	
	List<T> findByProperty(String propertyName, Object value);
	
	List<T> findAll();

	@SuppressWarnings("rawtypes")
	List<Map> queryByHql(String hql);
	
	@SuppressWarnings("rawtypes")
	List<Map> queryBySql(String hql);
	
	int excueteByHql(String hql);
	
	int excueteBySql(String sql);
	
	int excueteByHql(String hql,Object[] paramaters);
	
	int excueteBySql(String sql,Object[] paramaters);
	
	List<T> findByCollection(String hql,Collection<?> params);
	
	List<T> findByIds(Collection<?> ids);
	
	int batchDelete(Collection<PK> pks);
}
