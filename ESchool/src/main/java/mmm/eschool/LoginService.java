package mmm.eschool;

import mmm.eschool.model.User;
import org.hibernate.classic.Session;

/**
 *
 * @author Mariyan
 */
public class LoginService 
{
  public boolean getLoginResult(User user)
  {
    Session dataSession = HibernateUtil.getSessionFactory().openSession();
    dataSession.beginTransaction();
    User usr = (User) dataSession.get(User.class, user.getUsername());
    dataSession.close();
    return usr != null && usr.getUsername().equals(user.getUsername());
  }
}
