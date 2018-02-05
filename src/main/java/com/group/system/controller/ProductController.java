package com.group.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.group.system.model.Product;
import com.group.system.service.ProductService;
import com.group.system.util.Uris;

import java.util.List;


@RestController
@RequestMapping(Uris.API+Uris.VERSION)
public class ProductController {

    @Autowired
    private ProductService productoService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/products", method = RequestMethod.GET, produces = "application/json")
    public List<Product> findAllProductos(){
    	List<Product> productos = this.productoService.findAllProductos();
    	return productos;
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/products/{idProducto}", method = RequestMethod.GET, produces = "application/json")
    public Product findByIdProducto(@PathVariable("idProducto") int idProducto){
        return this.productoService.findByIdProducto(idProducto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/products", method = RequestMethod.POST, headers ="Accept=application/json")
    public void saveProducto(@RequestBody Product producto){
        this.productoService.saveProducto(producto);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/products", method = RequestMethod.PUT, headers ="Accept=application/json")
    public void updateProducto(@RequestBody Product producto){
        this.productoService.updateProducto(producto);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/products/{idProducto}", method = RequestMethod.DELETE)
    public void deleteProducto(@PathVariable("idProducto") int idProducto){
        Product producto = this.productoService.findByIdProducto(idProducto);
        this.productoService.deleteProducto(producto);
    }

}
