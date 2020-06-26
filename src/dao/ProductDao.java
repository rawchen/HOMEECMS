package dao;

import entity.Category;
import entity.PageBean;
import entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAllProduct();

    Product findProductById(int pId);

    void updateProductById(Product p);

    void delProductById(int productId);

    void addProduct(Product p);

    List<Product> findProductByCategoryCid(int productCid);

    List<Product> findProductTimeSort();

    List<Product> findProductSalesSort();

    List<Product> findProductByCategoryFid(int productFid);

    List<Product> findByPage(int start, int rows);

    int findTotalCount();

    List<Product> findProductListByKey(String key);
}
