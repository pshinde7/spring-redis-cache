package com.dreamcoder.rediscache.service;

import com.dreamcoder.rediscache.entity.Product;

public interface ProductService {
    String deleteProductById(long id);

    Product editProductById(long id, Product product);

    Product getProductById(long productId);

    Product saveProduct(Product product);
}
