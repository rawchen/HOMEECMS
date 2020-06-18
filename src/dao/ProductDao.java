package dao;

import entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProduct();
}
