package com.example.curd.controller;

import com.example.curd.VO.ResponseTemplateVO;
import com.example.curd.entity.Product;
import com.example.curd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addAllProduct")
    public  List<Product> addALLProduct(@RequestBody List<Product> products)
    {
        return service.saveAllProduct(products);
    }

    @GetMapping("/getProduct/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/getProductByName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public  String deletedProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @GetMapping("/getPf/{id}")
    public ResponseTemplateVO getProductWithFruit(@PathVariable int id)
    {
        return service.getProductWithFruit(id);
    }



}
