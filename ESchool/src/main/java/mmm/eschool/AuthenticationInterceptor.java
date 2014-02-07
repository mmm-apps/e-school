/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmm.eschool;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;
import mmm.eschool.model.User;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author MMihov
 */
public class AuthenticationInterceptor implements Interceptor 
{
  @Override
  public void destroy() {}

  @Override
  public void init() {}

  @Override
  public String intercept(ActionInvocation ai) throws Exception 
  {
    Map<String, Object> session = ai.getInvocationContext().getSession();
    final String requestURI = ServletActionContext.getRequest().getRequestURI();
    
    User user = (User) session.get(Constants.USER);
    
    if (user == null)
      return ActionSupport.LOGIN;
    else 
    {
      final String roleName = user.getRolesSet().get(0).getRoleName();
      if (getRequestedPage(requestURI).contains("student") && (roleName.equals(Constants.STUDENT) || roleName.equals(Constants.PARENT)))
        return ai.invoke();
      else if (roleName.equals(Constants.TEACHER))
        return ai.invoke();
      else if (roleName.equals(Constants.ADMINISTRATOR))
        return ai.invoke();
      else if ((getRequestedPage(requestURI).contains("parent") || getRequestedPage(requestURI).contains("viewChild")) && roleName.equals(Constants.PARENT))
        return ai.invoke();
      else
        return ActionSupport.ERROR;
    }
  }

  private String getRequestedPage(final String requestURI) 
  {
    int firstSlash = requestURI.indexOf("/", 1);
    String requestedPage = null;
    if (firstSlash != -1)
      requestedPage = requestURI.substring(firstSlash + 1, requestURI.length());
    return requestedPage;
  }
}
