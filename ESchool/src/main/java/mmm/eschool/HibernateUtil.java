/*
 */

package mmm.eschool;

import mmm.eschool.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Mariyan
 */
public class HibernateUtil
{
  private static final SessionFactory sessionFactory = buildSessionFactory();
 
  public static SessionFactory buildSessionFactory()
  {
    try 
    {
      return new AnnotationConfiguration().addAnnotatedClass(User.class).configure().buildSessionFactory();
    }
    catch (HibernateException ex) 
    {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
  
  public static synchronized SessionFactory getSessionFactory() 
  {
    if (sessionFactory == null)
      return buildSessionFactory();
    else
      return sessionFactory;
  }
  
  public static synchronized Session getDataSession()
  {
    final Session dataSession = getSessionFactory().openSession();
    dataSession.beginTransaction();
    return dataSession;
  }
  
  public static synchronized void closeAndCommitDataSession(Session dataSession)
  {
    dataSession.getTransaction().commit();
    dataSession.close();
  }
}
