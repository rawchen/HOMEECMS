package dao;

import entity.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryDao {
    List<Category> findCategoryParentList();

    List<Category> findCategoryChildList();

    List<Category> findAllCategory();

    Category findCategoryByCid(int productCid);

    void addCategory(Category category);

    void delCategoryById(int cid2);

    void updateCategoryName(String categoryName, int categoryId);
}
