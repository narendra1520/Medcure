package Dao;

import Model.Company;
import Model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CompanyDaoImpl implements CompanyDao {

  @Autowired
  DataSource datasource;
  
  @Autowired
  JdbcTemplate jdbctemplate;

    @Override
    public List<Company> getAllcompany() {
        String query="SELECT * FROM company";  
        List<Company> company = jdbctemplate.query(query,new CompanyMapper());  
        return company;
    }

    @Override
    public Company getcompany(int id) {
        String query="SELECT * FROM company where id="+id;
        List<Company> company = jdbctemplate.query(query,new CompanyMapper());
        return company.size()>0? company.get(0) : null;
    }

    @Override
    public boolean deleteCompany(int id) {
        String query="DELETE FROM company where id="+id;
        int up = jdbctemplate.update(query);
        if(up>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updtaeCompany(Company company) {
       String query="Update company SET country=?, contactemail=? where id=?";  
        int i = jdbctemplate.update(query,new Object[]{ company.getCountry(), 
                company.getContactemail(), company.getId()
        });  
        if(i>0){
            return true;
        }else{
            return false;     
        }
    }

    @Override
    public boolean addCompany(Company company) {
      String sql = "insert into company (companyname,country,contactemail) values(?,?,?)";
        
        int i =  jdbctemplate.update(sql, new Object[] {
            company.getCompanyname(), company.getCountry(), company.getContactemail()
        });
        if(i>0){
            return true;
        }else{
            return false;
        }
    }
}


class CompanyMapper implements RowMapper<Company> {

  public Company mapRow(ResultSet rs, int arg1) throws SQLException {
    Company company = new Company();

    company.setId(rs.getInt("id"));
    company.setCompanyname(rs.getString("companyname"));
    company.setContactemail(rs.getString("contactemail"));
    company.setCountry(rs.getString("country"));
    
    return company;
  }
}