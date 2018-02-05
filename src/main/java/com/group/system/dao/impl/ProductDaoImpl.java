package com.group.system.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group.system.dao.ProductDao;
import com.group.system.model.Product;

import java.util.List;

import javax.transaction.Transactional;

/**
 * Created by fran.
 */
@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao{
}
