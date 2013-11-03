package mmm.eschool.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mmm.eschool.EntityException;
import mmm.eschool.HibernateUtil;
import org.hibernate.classic.Session;

/**
 *
 * @author Mariyan
 */
public class UserManager implements EntityManager<User>
{
  private static final Map<String, User> users = new HashMap<String, User>();
  private static boolean toBeRecalc = true;
  
  @Override
  public boolean add(final User user) throws EntityException
  {
    if (user != null)
    {
      if (getUsers().containsKey(user.getUsername()))
        throw new EntityException("Потребителско име " + user.getUsername() + " вече съществува!");
      else
      {
        Session dataSession = mmm.eschool.HibernateUtil.getDataSession();
        dataSession.save(user);
        HibernateUtil.closeAndCommitDataSession(dataSession);
        addUser(user);
        return true;
      }
    }
    else
      return false;
  }

  @Override
  public User del(final String id) throws EntityException
  {
    if (id != null)
    {
      if (!getUsers().containsKey(id))
        throw new EntityException("Потребителско име " + id + " вече съществува!");
      else
      {
        User user = getUsers().get(id);
        Session dataSession = mmm.eschool.HibernateUtil.getDataSession();
        dataSession.delete(user);
        HibernateUtil.closeAndCommitDataSession(dataSession);
        delUser(user);
        return user;
      }
    }
    else
      return null;
  }

  @Override
  public boolean update(User user) throws EntityException
  {
    if (user != null)
    {
      if (!getUsers().containsKey(user.getUsername()))
        throw new EntityException("Потребителско име " + user.getUsername() + " вече съществува!");
      {
        Session dataSession = mmm.eschool.HibernateUtil.getDataSession();
        dataSession.update(user);
        HibernateUtil.closeAndCommitDataSession(dataSession);
        updateUser(user);
        return true;
      }
    }
    else
      return false;
  }

  @Override
  public List<User> objectList()
  {
    if (isToBeRecalc())
      calculateUsers();
    return (List<User>) getUsers().values();
  }

  @Override
  public User getById(String id)
  {
    return getUsers().get(id);
  }
  
  private synchronized void addUser(User user)
  {
    if (!getUsers().containsKey(user.getUsername()))
    {
      getUsers().put(user.getUsername(), user);
      setToBeRecalc(true);
    }
  }
  
  private synchronized void delUser(User user)
  {
    if (getUsers().containsKey(user.getUsername()))
    {
      getUsers().remove(user.getUsername());
      setToBeRecalc(true);
    }
  }
  
  private synchronized void updateUser(User user)
  {
    getUsers().remove(user.getUsername());
    setToBeRecalc(true);
  }

  private static boolean isToBeRecalc()
  {
    return toBeRecalc;
  }

  private static void setToBeRecalc(boolean toBeRecalc)
  {
    UserManager.toBeRecalc = toBeRecalc;
  }

  private synchronized Map<String, User> getUsers()
  {
    if (isToBeRecalc())
      calculateUsers();
    return users;
  }
  
  private void calculateUsers()
  {
    Session dataSession = mmm.eschool.HibernateUtil.getSessionFactory().openSession();
    List<User> newUsers = dataSession.createQuery("from User").list();
    dataSession.close();
    for (final User usr : newUsers)
      getUsers().put(usr.getUsername(), usr);
    setToBeRecalc(false);
  }
}
