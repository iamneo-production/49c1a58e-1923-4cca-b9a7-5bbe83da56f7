package com.examly.springapp.api.controllers;

import java.util.List;
import com.examly.springapp.api.services.ProductService;

import com.examly.springapp.api.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @RequestMapping("/home")
    public List<Product> getProduct() {
        return productService.getAllProducts();
    }

    @RequestMapping("/admin/productDet/{id}")
    public Product productGetData(@PathVariable("id") String id) {
        return productService.getProduct(id);
    }

    @PostMapping("/admin/addProduct")
    public String addProduct(@RequestBody Product p) {
        Product query = productService.addProduct(p);
        
        if(query == null) {
            return "Could not be added";
        }else {
            return "Product added";
        }
    }

    @RequestMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        boolean query = productService.deleteProduct(id);
        
        if(query) {
            return "Product deleted";
        }else {
            return "Product could not be deleted";
        }
    }

    @PostMapping("/admin/productEdit")
    public String editProduct(@RequestBody Product p) {
        
        Product query = productService.editProduct(p);

        if(query == null) {
            return "Could not be edited";
        }else {
            return "Product edited";
        }
    }

}
