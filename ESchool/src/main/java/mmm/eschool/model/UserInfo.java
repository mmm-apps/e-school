/*
 */

package mmm.eschool.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Mariyan
 */
@Embeddable
public class UserInfo implements Serializable 
{
  @Column(name = "first_name", nullable = false, length = 30)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 30)
  private String lastName;

  @Column(nullable = false, length = 40)
  private String phone;
  
  @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
  @Column(nullable = false, length = 40)
  private String email;

  @Column(nullable = false, length = 100)
  private String address;

  public UserInfo() {}

  public UserInfo(String firstName, String lastName, String phone, String email, String adress)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.address = adress;
  }
  
  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String adress)
  {
    this.address = adress;
  }
}
