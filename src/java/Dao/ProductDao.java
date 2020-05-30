package Dao;

import Model.Product;
import java.util.List;

public interface ProductDao {
  List<Product> getAllproduct();
  Product getProduct(int id);
  boolean deleteProduct(int id);
  boolean updateProduct(Product product);
  boolean addProduct(Product product);
  List<String> getcatgeory();
  List<String> getCompany();
}
