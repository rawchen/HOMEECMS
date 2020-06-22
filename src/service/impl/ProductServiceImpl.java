package service.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entity.Category;
import entity.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao dao = new ProductDaoImpl();

    @Override
    public List<Product> findAllProduct() {
        return dao.findAllProduct();
    }

    @Override
    public Product findProductById(int pId) {
        return dao.findProductById(pId);
    }

    @Override
    public void updateProductById(Product p) {
        dao.updateProductById(p);
    }

    @Override
    public void delProductById(int productId) {
        dao.delProductById(productId);
    }

    @Override
    public void addProduct(Product p) {
        dao.addProduct(p);
    }

    @Override
    public List<Product> findProductByCategoryCid(int productCid) {
        return dao.findProductByCategoryCid(productCid);
    }

    @Override
    public List<Product> findProductTimeSort() {
        return dao.findProductTimeSort();
    }

    @Override
    public List<Product> findProductSalesSort() {
        return dao.findProductSalesSort();
    }

    @Override
    public List<Product> findProductByCategoryFid(int fid) {
        return dao.findProductByCategoryFid(fid);
    }
}
