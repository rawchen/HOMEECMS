package service;

import entity.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {

    List<Category> findCategoryListByName(String father);

    List<Category> findAllCategory();
}
