package mmm.eschool.model.managers;

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
 
  private static SessionFactory buildSessionFactory()
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
  
  protected static final synchronized SessionFactory getSessionFactory() 
  {
    if (sessionFactory == null)
      return buildSessionFactory();
    else
      return sessionFactory;
  }
  
  protected static final void add(Object entity)
  {
    final Session dataSession = getSessionFactory().openSession();
    dataSession.beginTransaction();
    dataSession.save(entity);
    dataSession.getTransaction().commit();
    dataSession.close();
  }
  
  protected static final void del(Object entity)
  {
    final Session dataSession = getSessionFactory().openSession();
    dataSession.beginTransaction();
    dataSession.delete(entity);
    dataSession.getTransaction().commit();
    dataSession.close();
  }
  
  protected static final void update(Object entity)
  {
    final Session dataSession = getSessionFactory().openSession();
    dataSession.beginTransaction();
    dataSession.update(entity);
    dataSession.getTransaction().commit();
    dataSession.close();
  }
  
  protected static final void addInTransaction(Object... entities)
  {
    final Session dataSession = getSessionFactory().openSession();
    dataSession.beginTransaction();
    for (Object e : entities)
      dataSession.save(e);
    dataSession.getTransaction().commit();
    dataSession.close();
  }
}
