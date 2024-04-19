package com.dreamcoder.rediscache.service;

import com.dreamcoder.rediscache.entity.Product;
import com.dreamcoder.rediscache.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String deleteProductById(long id) {
        productRepository.deleteById(id);
        return "Successfully deleted";
    }

    @Override
    public Product editProductById(long id, Product product) {
        Product product1=getProductById(id);
        product1=product;
        return productRepository.save(product1);

    }

    @Override
    public Product getProductById(long productId) {

        Optional<Product> product = productRepository.findById(productId);
        return product.get();
    }

    @Override
    public Product saveProduct(Product product) {

        Product product1 = productRepository.save(product);
        return product1;
    }
}
