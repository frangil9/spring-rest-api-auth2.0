package com.group.system.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.system.dao.GenericDao;


public class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void saveOrUpdate(T entity) {
			getSession().saveOrUpdate(entity);
	}

	@Override
	public T findById(ID id) {
		T entity = (T) getSession().get(getEntityClass(), id);
		return entity;		
	}

	@Override
	public void delete(T entity) {
			getSession().delete(entity);
	}

	@Override
	public List<T> findAll() {		
		Query query = getSession().createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
		List<T> entities = query.list();
		return entities;	
	}

	 private Class<T> getEntityClass() {
		 return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}


	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public Serializable save(T entity) {
		return getSession().save(entity);
	}
}
