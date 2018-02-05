package com.group.system.service;


import java.util.List;

import com.group.system.model.Product;


public interface ProductService {
	public void saveProducto(Product producto);
	public void updateProducto(Product producto);
	public void deleteProducto(Product producto);
	public Product findByIdProducto(int idProducto);
    public List<Product> findAllProductos();
}
