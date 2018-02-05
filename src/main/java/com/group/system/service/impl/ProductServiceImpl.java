package com.group.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.system.dao.ProductDao;
import com.group.system.model.Product;
import com.group.system.service.ProductService;
import java.util.*;

import javax.transaction.Transactional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productoDAO;

    @Transactional
	@Override
	public List<Product> findAllProductos() {
		return this.productoDAO.findAll();
	}
    @Transactional
    @Override
	public void saveProducto(Product producto) {
		this.productoDAO.save(producto);
		
	}
    @Transactional
	@Override
	public void deleteProducto(Product producto) {
		this.productoDAO.delete(producto);
	}
    @Transactional
	@Override
	public Product findByIdProducto(int idProducto) {
		return this.productoDAO.findById(idProducto);
	}
    @Transactional
	@Override
	public void updateProducto(Product producto) {
		this.productoDAO.update(producto);
	}
}
