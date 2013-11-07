package mmm.eschool.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.EntityNotExistException;
import mmm.eschool.HibernateUtil;
import org.hibernate.classic.Session;

/**
 *
 * @author Mariyan
 */
public abstract class Manager<T>
{
  private static boolean toBeCalc = true; // may be not static?!???
  
  private synchronized Map<String, T> getEntityCollection()
  {
    if (toBeCalc)
      calculateEntities();
    return getCollection();
  }

  private void calculateEntities()
  {
    final Session dataSession = mmm.eschool.HibernateUtil.getSessionFactory().openSession();
    final List<T> newEntityData = dataSession.createQuery("from " + getEntityName()).list();
    dataSession.close();
    for (final T entity : newEntityData)
      getCollection().put(getId(entity), entity);
    toBeCalc = false;
  }
  
  public final boolean add(final T entity) throws EntityNotExistException
  {
    if (entity != null)
    {
      if (getEntityCollection().containsKey(getId(entity)))
        throw new EntityNotExistException(getId(entity));
      else
      {
        HibernateUtil.add(entity);
        if (!getEntityCollection().containsKey(getId(entity)))
        {
          getCollection().put(getId(entity), entity);
          toBeCalc = true;
        }
        return true;
      }
    }
    else
      return false;
  }
  
  public final T del(final String id) throws EntityNotExistException
  {
    if (id != null)
    {
      if (!getEntityCollection().containsKey(id))
        throw new EntityNotExistException(id);
      else
      {
        final T entity = getEntityCollection().get(id);
        HibernateUtil.del(entity);
        if (getEntityCollection().containsKey(getId(entity)))
        {
          getCollection().remove(getId(entity));
          toBeCalc = true;
        }
        return entity;
      }
    }
    else
      return null;
  }

  public final boolean update(T entity) throws EntityNotExistException
  {
    if (entity != null)
    {
      if (!getEntityCollection().containsKey(getId(entity)))
        throw new EntityNotExistException(getId(entity));
      {
        HibernateUtil.update(entity);
        getCollection().put(getId(entity), entity);
        toBeCalc = true;
      }
      return true;
    }
    else
      return false;
  }
  
  public final List<T> EntityList()
  {
    if (toBeCalc)
      calculateEntities();
    return new ArrayList(getCollection().values());
  }

  public final T getEntityById(String id)
  {
    return getEntityCollection().get(id);
  }
  
  abstract String getId(T entity);
  abstract String getEntityName();
  abstract Map<String, T> getCollection();
}
