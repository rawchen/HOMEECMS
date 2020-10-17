package service.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entity.Category;
import entity.PageBean;
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
    public PageBean<Product> findProductByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        //创建新的PageBean对象
        PageBean<Product> pb = new PageBean<Product>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始记录的索引
        int start = (currentPage - 1) * rows;
        List<Product>list = dao.findByPage(start,rows);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
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

    @Override
    public List<Product> findProductListByKey(String key) {
        return dao.findProductListByKey(key);
    }
}
