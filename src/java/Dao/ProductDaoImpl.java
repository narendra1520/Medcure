package Dao;

import Model.Category;
import Model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductDaoImpl implements ProductDao {

  @Autowired
  DataSource datasource;
  
  @Autowired
  JdbcTemplate jdbctemplate;
  
    @Override
    public boolean deleteProduct(int id) {
        String query="DELETE FROM product where id="+id;
        int up = jdbctemplate.update(query);
        if(up>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        String query="Update product SET ppunit=?, company=?, category=?, quantity=? where id=?";  
        int i = jdbctemplate.update(query,new Object[]{ product.getPriceperunit(), 
                product.getCompany(), product.getCategory(), product.getQuantity(),product.getId()
        });  
        if(i>0){
            return true;
        }else{
            return false;     
        }
    }

    @Override
    public List<Product> getAllproduct() {
        String query="SELECT * FROM product";  
        List<Product> products = jdbctemplate.query(query,new ProductMapper());  
        return products;
    }

    @Override
    public Product getProduct(int id) {
        String query="SELECT * FROM product where id="+id;
        List<Product> products = jdbctemplate.query(query,new ProductMapper());
        return products.size()>0? products.get(0) : null;
    }

    @Override
    public boolean addProduct(Product product) {
        String sql = "insert into product (productname,ppunit,company,category,quantity) values(?,?,?,?,?)";
        
        int i =  jdbctemplate.update(sql, new Object[] {
            product.getProductname(), product.getPriceperunit(), product.getCompany(),
            product.getCategory(), product.getQuantity()
        });
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<String> getcatgeory() {
        String query="SELECT catname FROM category";
        List<String> catgeory = jdbctemplate.query(query, new RowMapper<String>(){
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
        return catgeory;
    }

    @Override
    public List<String> getCompany() {
       String query="SELECT companyname FROM company";
        List<String> company = jdbctemplate.query(query, new RowMapper<String>(){
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        });
        return company;
    }
}


class ProductMapper implements RowMapper<Product> {

  public Product mapRow(ResultSet rs, int arg1) throws SQLException {
    Product product = new Product();

    product.setId(rs.getInt("id"));
    product.setProductname(rs.getString("productname"));
    product.setPriceperunit(rs.getFloat("ppunit"));
    product.setCompany(rs.getString("company"));
    product.setCategory(rs.getString("category"));
    product.setQuantity(rs.getInt("quantity"));
    
    return product;
  }
}