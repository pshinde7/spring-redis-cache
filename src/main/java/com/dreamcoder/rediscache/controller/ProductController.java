    package com.dreamcoder.rediscache.controller;


    import com.dreamcoder.rediscache.entity.Product;
    import com.dreamcoder.rediscache.service.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.cache.annotation.CacheEvict;
    import org.springframework.cache.annotation.CachePut;
    import org.springframework.cache.annotation.Cacheable;
    import org.springframework.web.bind.annotation.*;

    @RestController
    public class ProductController {


        @Autowired
        private ProductService productService;



        @PostMapping("/product")
        public Product saveProduct(@RequestBody Product product){

            return productService.saveProduct(product);
        }

        @GetMapping("/product/{id}")
        @Cacheable(value = "product", key = "#id")
        public Product getProductById(@PathVariable long id) {
            return productService.getProductById(id);
        }


        @PutMapping("/product/{id}")
        @CachePut(cacheNames = "product", key = "#id")
        public Product editProduct(@PathVariable long id, @RequestBody Product product) {
            return productService.editProductById(id,product);
        }

        @DeleteMapping("/product/{id}")
        @CacheEvict(cacheNames = "product", key = "#id", beforeInvocation = true)
        public String removeProductById(@PathVariable long id) {
            return productService.deleteProductById(id);
        }
    }
