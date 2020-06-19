package service;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();

    Product findProductById(int pId);

    void updateProductById(Product p);
}
