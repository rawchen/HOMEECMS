package service.impl;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import entity.Category;
import service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();

    @Override
    public List<Category> findCategoryListByName(String flag) {
        if (flag != null && flag.equals("father")){
            return dao.findCategoryParentList();
        }else{
            return dao.findCategoryChildList();
        }
    }

    @Override
    public List<Category> findAllCategory() {
        return dao.findAllCategory();
    }

    @Override
    public Category findCategoryByCid(int productCid) {
        return dao.findCategoryByCid(productCid);
    }

    @Override
    public void addCategory(Category category) {
        dao.addCategory(category);
    }

    @Override
    public void delCategoryById(int cid2) {
        dao.delCategoryById(cid2);
    }

    @Override
    public void updateCategoryName(String categoryName, int categoryId) {
        dao.updateCategoryName(categoryName,categoryId);
    }
}
