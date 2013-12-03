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
import javax.servlet.http.HttpServletRequest;
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
//    Map<String, Object> session = ai.getInvocationContext().getSession();
//    HttpServletRequest request = ServletActionContext.getRequest();
//    
//    User user = (User) session.get("user");
//    
//    if (user == null)
//      return ActionSupport.LOGIN;
//    else 
//    {
//      if (getRequestedPage(request).contains("student") && !user.getStudentsSet().isEmpty())
//        return ai.invoke();
//      else if (getRequestedPage(request).contains("teacher") && !user.getTeachersSet().isEmpty())
//        return ai.invoke();
//      else if (getRequestedPage(request).contains("admin")&&user.getUsername().equals("admin"))
//        return ai.invoke();
//      else if (getRequestedPage(request).contains("parent") && !user.getParentsSet().isEmpty())
//        return ai.invoke();
//      else
//        return ActionSupport.ERROR;
//    }
    return ai.invoke();
  }

  private String getRequestedPage(final HttpServletRequest httpRequest) 
  {
    final String url = httpRequest.getRequestURI();
    int firstSlash = url.indexOf("/", 1);
    String requestedPage = null;
    if (firstSlash != -1)
      requestedPage = url.substring(firstSlash + 1, url.length());
    return requestedPage;
  }
}
