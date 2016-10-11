package com.lanhun.framework.orm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import com.lanhun.framework.orm.dao.IBaseDao;
import com.lanhun.framework.orm.po.BaseEntity;
import com.lanhun.framework.utils.ServiceException;
import com.lanhun.framework.utils.em.Status;
import com.lanhun.framework.utils.page.EntityViewInfo;
@SuppressWarnings({"unchecked","rawtypes"})
public abstract class BaseDao<T, PK extends Serializable> implements
		IBaseDao<T, PK> {
	
	protected Logger logger=LoggerFactory.getLogger(getClass());
	private Class<T> entityClass;
	private String className;
	
	
	
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public String getClassName() {
		return className;
	}

	public BaseDao(){
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.className = entityClass.getSimpleName();
		logger.info("init");
	}
	
	@Resource
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	protected String getClassAlias() {
		// return this.className.substring(0,
		// 1).toLowerCase().concat(this.className.length()>1?
		// this.className.substring(1):"");
		return "instance";
	}
	@Override
	public T save(T intances) {
		getSession().save(intances);
		return intances;
	}

	@Override
	public T findByPk(PK pk) {
		return (T)(getSession().get(entityClass, pk));
	}

	@Override
	public List<T> listAll() {
		String hql = "FROM " + getClassName();
		return find(hql);
	}

	@Override
	public int deleteByPk(PK pk) {
		logger.debug("removing " + getClassName() + " instance");
		if(pk==null){
			throw new ServiceException("can't find entity :"+getEntityClass().getName()+"#"+pk);
		}
		T instance = (T) getSession().get(getEntityClass(), pk);
		if(instance==null){
			throw new ServiceException("can't find entity :"+getEntityClass().getName()+"#"+pk);
		}
		getSession().delete(instance);
//		getHibernateTemplate().flush();
		logger.debug("remove successful");
		return 0;
	}

	/**
	 * 0：找不到记录,1：启用成功，2：禁用成功
	 */
	@Override
	public int disableOrEnable(PK pk) {
		logger.debug("removing " + getClassName() + " instance");
		T instance = (T) getSession().get(getEntityClass(), pk);
		int flag=0;
		if(instance instanceof BaseEntity){
			if(Status.E.equals(((BaseEntity) instance).getEnabled())){
				flag=2;
				((BaseEntity) instance).setEnabled(Status.D);
			}else if(Status.D.equals(((BaseEntity) instance).getEnabled())){
				flag=1;
				((BaseEntity) instance).setEnabled(Status.E);
			}
		}
		getSession().update(instance);
//		getHibernateTemplate().flush();
		logger.debug("disableOrEnable result："+flag);
		return flag;
	}
	
	@Override
	public List<T> find(String hql) {
		logger.debug("finding the " + getClassName() + " instances by hql");
		Query query=getSession().createQuery(hql);
		return (List<T>) query.list();
	}
	@Override
	public List<T> query(EntityViewInfo view){
		if(view.getEntityClassName()==null){
			view.setEntityClassName(className);
		}
		String hql=view.getHQL();
		Query query=getSession().createQuery(hql);
		if(view.getFilter()!=null&&view.getFilter().getVals()!=null){
			setQueryParameter(query, view.getFilter().getVals());
		}
		query.setFirstResult(view.getFirst());
		query.setMaxResults(view.getPageSize());
		List<T> data=query.list();
		String chql=createCountQL(hql);
		query=getSession().createQuery(chql);
		if(view.getFilter()!=null&&view.getFilter().getVals()!=null){
			setQueryParameter(query, view.getFilter().getVals());
		}
		Number total=(Number)query.uniqueResult();
		view.setRowCount(total.intValue());
		return data;
	}
	private void setQueryParameter(Query query,Map<String,Object> vals){
		 Iterator<String> it = vals.keySet().iterator();
		  String key = null;
		  while(it.hasNext()){
			  key =  it.next();
			  if( vals.get(key) instanceof Collection){
					query.setParameterList(key, (Collection)vals.get(key));
				}else{
					query.setParameter(key, vals.get(key));
				}
	  }
	}
	protected static String createCountQL(String ql) {
		// TODO 处理DISTINCT
		Pattern pattern = Pattern.compile("^\\s*select.+?from",
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(ql);
		if (matcher.find()) {
			ql = matcher.replaceFirst("select count(*) from");
		} else if (ql.trim().toLowerCase().startsWith("from")) {
			ql = "select count(*) " + ql;
		} else {
			throw new IllegalArgumentException(
					"is not start with 'select...from' or 'from'");
		}
		//移除order by 
		pattern =Pattern.compile("\\border\\s+by\\s+[\\s\\S]*",Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(ql);
		if(matcher.find()){
			ql=matcher.replaceFirst(" ");
		}
		return ql;
	}

	@Override
	public T modify(T intances) {
		getSession().update(intances);
		return intances;
	}
	@Override
	public List<T> find(String hql, Object[] paramaters) {
		Query query=getSession().createQuery(hql);
		for(int i=0;i<paramaters.length;i++){
			query.setParameter("val"+i, paramaters[i]);
		}
		return (List<T>) query.list();
	}
	@Override
	public List<T> find(final String hql, final int firstResult,
			final int maxResult) {
		logger.debug("finding the " + getClassName() + " instances by hql");
		Query q=getSession().createQuery(hql);
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResult);
		return (List<T>)q.list();
	}
	@Override
	public List<T> find(String hql, Object paramater) {
		Object [] p={paramater};
		return this.find(hql, p);
	}
	@Override
	public List<T> find(final String hql, final Object[] paramaters,
			final int firstResult, final int maxResult) {
		logger.debug("finding the " + getClassName() + " instances by hql");
		
		Query q=getSession().createQuery(hql);
		for (int i = 0; i < paramaters.length; i++) {
			q.setParameter("val"+i, paramaters[i]);
		}
		q.setFirstResult(firstResult);
		q.setMaxResults(maxResult);
		return (List<T>)q.list();
	}
	@Override
	public List<T> find(String hql, Object paramater, int firstResult,
			int maxResult) {
		Object[] paramaters = { paramater };
		return find(hql, paramaters, firstResult, maxResult);
	}
	@Override
	public List<T> findByProperty(String[] propertyNames, Object[] values) {
		String queryString = "from " + getClassName() + " as "
				+ getClassAlias() + " where";
		for (int i = 0; i < propertyNames.length; i++) {
			queryString += " " + getClassAlias() + "." + propertyNames[i]
					+ "=:val"+i+" and";
		}
		queryString = StringUtils.removeEnd(queryString, "and");
		// queryString=addOrderBy(queryString);
		return this.find(queryString, values);
	}
	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		return this.findByProperty(new String[]{propertyName},new Object[] {value});
	}
	@Override
	public int countByProperty(String[] propertyNames, Object[] values){
		String queryString = "select count(*) from " + getClassName() + " as "
				+ getClassAlias() + " where";
		for (int i = 0; i < propertyNames.length; i++) {
			queryString += " " + getClassAlias() + "." + propertyNames[i]
					+ "=:val"+i+" and";
		}
		queryString = StringUtils.removeEnd(queryString, "and");
		
		Query q=getSession().createQuery(queryString);
		for (int i = 0; i < values.length; i++) {
			q.setParameter("val"+i, values[i]);
		}
		Number count=(Number)q.uniqueResult();
		return count.intValue();
	}
	@Override
	public int countByProperty(String property,Object value){
		return this.countByProperty(new String[]{property}, new Object[]{value});
	}
	@Override
	public List<Map> queryByHql(String hql){
		Query query = getSession().createQuery(hql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		return query.list();
		
	}
	@Override
	public List<Map> queryBySql(String hql){
		Query query = getSession().createSQLQuery(hql);
		query.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
		return query.list();
		
	}
	@Override
	public int excueteByHql(String hql) {
		Query query=getSession().createQuery(hql);
		return query.executeUpdate();
	}
	@Override
	public int excueteBySql(String sql) {
		Query query=getSession().createSQLQuery(sql);
		return query.executeUpdate();
	}
	@Override
	public int excueteByHql(String hql, Object[] paramaters) {
		Query query=getSession().createQuery(hql);
		for (int i = 0; i < paramaters.length; i++) {
			query.setParameter("val"+i, paramaters[i]);
		}
		return query.executeUpdate();
	}
	@Override
	public int excueteBySql(String sql, Object[] paramaters) {
		Query query = getSession().createSQLQuery(sql);
		for (int i = 0; i < paramaters.length; i++) {
			query.setParameter("val" + i, paramaters[i]);
		}
		return query.executeUpdate();
	}
	@Override
	public List<T> findByCollection(String hql,
			Collection<?> collection) {
		if(collection!=null&&collection.size()>0){
			Query query=getSession().createQuery(hql);
			query.setParameterList("val0", collection);
			query.list();
		}
		return new ArrayList();
	}
	@Override
	public List<T> findByIds(Collection<?> collection) {
		
		if(collection!=null&&collection.size()>0){
			String hql="From "+getClassName()+" where id in :val0";
			Query query=getSession().createQuery(hql);
			query.setParameterList("val0", collection);
			return query.list();
		}
		
		return new ArrayList();
	
	}
}
