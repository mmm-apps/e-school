package mmm.eschool;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
 
  public static final SessionFactory buildSessionFactory()
  {
    try 
    {
      return new Configuration().configure().buildSessionFactory();
    }
    catch (HibernateException ex) 
    {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
  
  public static final synchronized SessionFactory getSessionFactory() 
  {
    if (sessionFactory == null)
      return buildSessionFactory();
    else
      return sessionFactory;
  }
  
  public static final void add(Object entity)
  {
    final Session dataSession = getSessionFactory().openSession();
    dataSession.beginTransaction();
    dataSession.save(entity);
    dataSession.getTransaction().commit();
    dataSession.close();
  }
  
  public static final void del(Object entity)
  {
    final Session dataSession = getSessionFactory().openSession();
    dataSession.beginTransaction();
    dataSession.delete(entity);
    dataSession.getTransaction().commit();
    dataSession.close();
  }
  
  public static final void update(Object entity)
  {
    final Session dataSession = getSessionFactory().openSession();
    dataSession.beginTransaction();
    dataSession.update(entity);
    dataSession.getTransaction().commit();
    dataSession.close();
  }
}
