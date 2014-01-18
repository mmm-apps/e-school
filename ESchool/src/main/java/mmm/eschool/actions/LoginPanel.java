/*
 */
package mmm.eschool.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import mmm.eschool.Constants;
import mmm.eschool.model.User;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author MMihov
 */
public class LoginPanel extends ActionSupport implements SessionAware
{
  private Map<String, Object> session;

  @Override
  public void setSession(Map<String, Object> map) { this.session = map; }

  @Override
  public String execute()
  {
    final User sessionUser = (User) session.get(Constants.USER);
    if (sessionUser == null)
      return NONE;
    else 
    {
      String roleName = sessionUser.getRolesSet().get(0).getRoleName();
      if (roleName.equals(Constants.ADMINISTRATOR)) 
        return "admin";
      if(roleName.equals(Constants.PARENT))
        return "parent";
      if(roleName.equals(Constants.STUDENT))
        return "student";
      if(roleName.equals(Constants.TEACHER))
        return "teacher";
    }
    return ERROR;
  }
}
