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

    List<Product> findProductByCategoryCid(int productCid);

    List<Product> findProductTimeSort();

    List<Product> findProductSalesSort();

    List<Product> findProductByCategoryFid(int fid);
}
