package dao;

import entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProduct();

    Product findProductById(int pId);

    void updateProductById(Product p);
}
