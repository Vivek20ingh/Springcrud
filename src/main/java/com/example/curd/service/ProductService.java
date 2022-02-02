package com.example.curd.service;

import java.util.List;

import com.example.curd.VO.Fruit;
import com.example.curd.VO.ResponseTemplateVO;
import com.example.curd.entity.Product;
import com.example.curd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    @Autowired

    private ProductRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Product saveProduct(Product product)
    {
        return repository.save(product);
    }

    public List<Product> saveAllProduct(List<Product> products)
    {
        return repository.saveAll(products);
    }

     public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id)
    {
        repository.deleteById(id);
        return "product removed || "+id;
    }

    public  Product updateProduct(Product product)
    {
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);

    }

    public ResponseTemplateVO getProductWithFruit(int id)
    {
        ResponseTemplateVO vo= new ResponseTemplateVO();
        Product product= repository.findById(id).orElse(null);

        Fruit fruit=restTemplate.getForObject("http://localhost:8080/getFruit/"+id ,Fruit.class);
        vo.setFruit(fruit);
        vo.setProduct(product);
        return vo;
    }

}
