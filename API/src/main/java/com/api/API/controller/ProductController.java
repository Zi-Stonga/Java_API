package com.api.API.controller;

import com.api.API.model.Product;
import com.api.API.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController


public class ProductController {

    @Autowired
    private ProductService productService;

    //insert product into database
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    }


    //get a single product by its ID
    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam(name = "productId") long productId){
        Product product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //get all the products in the table in our database
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    //update an existing product in the database
    @PatchMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam(name = "productId") long productId, @RequestBody Product product){
        Product updateProduct = productService.updateProduct(productId, product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }


    //delete an existing product in the database
    @DeleteMapping("/product")
    public ResponseEntity<Product> deleteProduct(@RequestParam(name = "productId") long productId) {
        Product deleteProduct = productService.deleteProduct(productId);
        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
    }
    //get product by name using a raw SQL statement
    @GetMapping("/products-by-name")
    public List<Product> getProductsByName (@RequestParam(name = "productName") String productName) {
        return productService.getProductsByName(productName);

    }
}
