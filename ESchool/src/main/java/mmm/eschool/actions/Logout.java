/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import mmm.eschool.model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class Logout extends ActionSupport implements SessionAware  
{
  User user = new User();
  private Map<String,Object> session;

  @Override
  public String execute() throws Exception {
    session.remove("user");
    return SUCCESS;
  }

  @Override
  public void setSession(Map<String, Object> map) {
    this.session = map;
  }
}
