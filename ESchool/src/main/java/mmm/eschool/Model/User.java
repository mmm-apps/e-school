package mmm.eschool.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Mariyan
 */
@Entity
@Table(schema = "eschool", name = "users")
public class User implements Serializable
{
  public enum Roles 
  { 
    ADMINISTRATOR("Администратор"), PARENT("Родител"), CLASSMASTER("Класен ръководител"), TEACHER("Учител"), STUDENT("Ученик"); 
    private final String roleName ;
    Roles(String roleName) { this.roleName = roleName; }
    
    public String getRoleName() { return roleName; }
  }
  
  @Id
  @Column(length = 20)
  private String username;
  @Column(nullable = false, length = 50)
  private String password;
  @Column(name = "user_role", nullable = false, length = 20)
  private String userRole;
 
  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getUserRole()
  {
    return userRole;
  }

  public void setUserRole(String userRole)
  {
    this.userRole = userRole;
  }
}
