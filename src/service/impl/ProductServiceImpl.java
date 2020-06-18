package service.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entity.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao dao = new ProductDaoImpl();

    @Override
    public List<Product> findAllProduct() {
        return dao.findAllProduct();
    }
}
