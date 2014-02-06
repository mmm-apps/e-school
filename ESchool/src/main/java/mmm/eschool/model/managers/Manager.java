package mmm.eschool.model.managers;

import java.util.ArrayList;
import java.util.List;
import mmm.eschool.AnException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Mariyan
 */
public class Manager
{
  private final Class model;
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
  
  private static Session getDataSession() { return sessionFactory.openSession(); }

  public Manager(final Class model)
  {
    this.model = model;
  }
  
  public final boolean add(final Object entity) throws AnException
  {
    if (entity == null)
      return false;
    if (!entity.getClass().equals(model))
      return false;
    
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
    return true;
  }
  
  public final boolean del(final Integer id) throws AnException
  {
    if (id == null)
      return false;
    return del(getEntityById(id));
  }
  
  public final boolean del(final Object entity) throws AnException
  {
    if (entity == null)
      return false;
    if (!entity.getClass().equals(model))
      return false;
    
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
    return true;
  }

  public final boolean update(final Object entity) throws AnException
  {
    if (entity == null)
      return false;
    if (!entity.getClass().equals(model))
      return false;
    
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
    
    return true;
  }
  
  public final boolean saveOrUpdateInTransaction(final Object... entities)
  {
    final Session dataSession = getDataSession();
    dataSession.beginTransaction();
    try
    {
      for (final Object e : entities)
        dataSession.saveOrUpdate(e);
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
    
    return true;
  }
  
  public final ArrayList getEntityList()
  {
    final Session dataSession = getDataSession();
    final List<Object> newEntityData = dataSession.createQuery("from " + model.getSimpleName()).list();
    dataSession.close();
    return new ArrayList(newEntityData);
  }

  public final Object getEntityById(int id)
  {
    final Session dataSession = getDataSession();
    final Object entity = (Object) dataSession.get(model, id);
    dataSession.close();
    return entity;
  }
}
