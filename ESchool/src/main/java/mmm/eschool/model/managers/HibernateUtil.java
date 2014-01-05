package mmm.eschool.model.managers;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
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
    catch(HibernateException ex) 
    {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
  
  private static SessionFactory getSessionFactory() { return sessionFactory; }
  
  private static void shutdown() { getSessionFactory().close(); }
  
  protected static Session getDataSession() { return sessionFactory.openSession(); }
  
  protected static final void add(Object entity)
  {
    final Session dataSession = getDataSession();
    dataSession.beginTransaction();
    try
    {
      dataSession.save(entity);
      dataSession.getTransaction().commit();
    }
    catch(TransactionException e)
    {
      dataSession.getTransaction().rollback();
    }
    finally
    {
      dataSession.close();
    }
  }
  
  protected static final void del(Object entity)
  {
    final Session dataSession = getDataSession();
    dataSession.beginTransaction();
    try
    {
      dataSession.delete(entity);
      dataSession.getTransaction().commit();
    }
    catch(TransactionException e)
    {
      dataSession.getTransaction().rollback();
    }
    finally
    {
      dataSession.close();
    }
  }
  
  protected static final void update(Object entity)
  {
    final Session dataSession = getDataSession();
    dataSession.beginTransaction();
    try
    {
      dataSession.update(entity);
      dataSession.getTransaction().commit();
    }
    catch(TransactionException e)
    {
      dataSession.getTransaction().rollback();
    }
    finally
    {
      dataSession.close();
    }
  }
  
  protected static final void addInTransaction(Object... entities)
  {
    final Session dataSession = getDataSession();
    dataSession.beginTransaction();
    try
    {
      for (Object e : entities)
        dataSession.save(e);
      dataSession.getTransaction().commit();
    }
    catch(TransactionException e)
    {
      dataSession.getTransaction().rollback();
    }
    finally
    {
      dataSession.close();
    }
  }
}
