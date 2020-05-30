package Model;

import javax.validation.constraints.NotEmpty;


public class Login {

  @NotEmpty(message="reuired")
  private String username;
  
//  @Size(min=6,max=15,message = "Size not matched")
  private String password;
  
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
