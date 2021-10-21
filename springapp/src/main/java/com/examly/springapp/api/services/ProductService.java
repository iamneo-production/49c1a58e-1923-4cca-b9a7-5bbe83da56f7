package com.examly.springapp.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.examly.springapp.api.models.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    private static List<Product> prod_list = new ArrayList<>();

    static {
        prod_list.add(new Product("car.html", "Toy Car", "500", "Model car for kids", 10));
        prod_list.add(new Product("shirt.html", "Shirt", "1500", "Shirt for kids", 5));
    }

    public List<Product> getAllProducts() {
        return prod_list;
        //return all products
    }

    public Product getProduct(String id) {
        // return single product given prod id
        List<Product> res = prod_list.stream()
        .filter(prod -> prod.getProductId().equals(id))
        .collect(Collectors.toList());

        Product ret = res.get(0);
        if(res.size() > 0) {
            return ret;
        }else
            return null;
    }

    public Product addProduct(Product product) {
        // add a product in db


        // check whether user id exists before or not
        Optional<Product> res = prod_list.stream()
        .filter(prod -> prod.getProductId() == product.getProductId())
        .findFirst();

        if(res.isPresent()) {
            //return null if could not be 
            //added or user already
            return null;
        }else {
            prod_list.add(product);
            return product;
        }
    }

    public boolean deleteProduct(String id) {
        return prod_list.removeIf(prod -> prod.getProductId().equals(id));
    }
    
    public Product editProduct(Product product) {
        //edit details of a product
        
        //delete the product if existing
        boolean status = deleteProduct(product.getProductId());

        if(status) {
            //add the new product 
            addProduct(product);
            return product;
        }else {
            //product could not be edited
            return null;
        }

    }

}
