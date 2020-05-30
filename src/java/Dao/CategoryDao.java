package Dao;

import Model.Category;
import java.util.List;

public interface CategoryDao {
  List<Category> getAllcategory();
  Category getcategory(int id);
  boolean deleteCategory(int id);
  boolean addCategoory(Category cat);
}
