package service;

import entity.Category;
import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProduct();

    Product findProductById(int pId);

    void updateProductById(Product p);

    void delProductById(int productId);

    void addProduct(Product p);
}
