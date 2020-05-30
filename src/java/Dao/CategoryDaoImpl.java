package Dao;

import Model.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CategoryDaoImpl implements CategoryDao {

  @Autowired
  DataSource datasource;
  
  @Autowired
  JdbcTemplate jdbctemplate;
 
    @Override
    public List<Category> getAllcategory() {
       String query="SELECT * FROM category";  
        List<Category> category = jdbctemplate.query(query,new CategoryMapper());  
        return category;
    }

    @Override
    public Category getcategory(int id) {
        String query="SELECT * FROM category where id="+id;
        List<Category> catgeory = jdbctemplate.query(query,new CategoryMapper());
        return catgeory.size()>0? catgeory.get(0) : null;
    }

    @Override
    public boolean deleteCategory(int id) {
        String query="DELETE FROM category where id="+id;
        int up = jdbctemplate.update(query);
        if(up>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addCategoory(Category cat) {
       String sql = "insert into category (catname) values(?)";
        
        int i =  jdbctemplate.update(sql, new Object[] {
            cat.getCatname()
        });
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}


class CategoryMapper implements RowMapper<Category> {

  public Category mapRow(ResultSet rs, int arg1) throws SQLException {
    Category cate = new Category();

    cate.setId(rs.getInt("id"));
    cate.setCatname(rs.getString("catname"));
    
    return cate;
  }
}