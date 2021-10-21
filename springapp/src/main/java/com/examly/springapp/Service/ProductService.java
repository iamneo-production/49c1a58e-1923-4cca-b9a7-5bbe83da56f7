package com.examly.springapp.Service;
import java.util.ArrayList;
import java.util.List;

import com.examly.springapp.Repository.ProductRepository;
import com.examly.springapp.Model.ProductModel;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addNewProduct(ProductModel product) {
        productRepository.save(product);
    }

    public boolean checkProductById(Long id) {
        return productRepository.existsById(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public ProductModel getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<ProductModel> getAllProducts() {
        List<ProductModel> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public void updateProductById(Long id, ProductModel data) {
        productRepository.updateProductById(id, data);
    }

}
