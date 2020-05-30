package Dao;

import Model.Login;
import Model.User;

public interface UserDao {
  User validateUser(Login login);
}
