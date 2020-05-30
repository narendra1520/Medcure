package Dao;

import Model.Login;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;
  
//  public int register(User user) {
//    String sql = "insert into users values(?,?,?,?,?,?,?)";
//
//    return jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
//        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
//  }

  public User validateUser(Login login) {
      
  JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
    String sql = "select * from admin where username='" + login.getUsername() +
            "' and password='" + login.getPassword()+ "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
  }

}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setName(rs.getString("name"));
    user.setUsername(rs.getString("username"));

    return user;
  }
}