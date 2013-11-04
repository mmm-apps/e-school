package mmm.eschool.model;

import java.util.List;
import java.util.Map;
import mmm.eschool.EntityNotExistException;
import mmm.eschool.HibernateUtil;
import org.hibernate.classic.Session;

/**
 *
 * @author Mariyan
 */
public abstract class Manager<T> implements EntityManager<T>
{
  private static boolean toBeCalc = true;
  
  final void calculateEntities()
  {
    Session dataSession = mmm.eschool.HibernateUtil.getSessionFactory().openSession();
    List<T> newEntityData = dataSession.createQuery("from " + getEntityName()).list();
    dataSession.close();
    for (final T entity : newEntityData)
      getEntityCollection().put(getId(entity), entity);
    toBeCalc = false;
  }
  
  @Override
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
          getEntityCollection().put(getId(entity), entity);
          toBeCalc = true;
        }
        return true;
      }
    }
    else
      return false;
  }
  
  @Override
  public final T del(final String id) throws EntityNotExistException
  {
    if (id != null)
    {
      if (!getEntityCollection().containsKey(id))
        throw new EntityNotExistException(id);
      else
      {
        T entity = getEntityCollection().get(id);
        HibernateUtil.del(entity);
        if (getEntityCollection().containsKey(getId(entity)))
        {
          getEntityCollection().remove(getId(entity));
          toBeCalc = true;
        }
        return entity;
      }
    }
    else
      return null;
  }

  @Override
  public final boolean update(T entity) throws EntityNotExistException
  {
    if (entity != null)
    {
      if (!getEntityCollection().containsKey(getId(entity)))
        throw new EntityNotExistException(getId(entity));
      {
        HibernateUtil.update(entity);
        getEntityCollection().remove(getId(entity));
        toBeCalc = true;
        return true;
      }
    }
    else
      return false;
  }
  
  final synchronized Map<String, T> getEntityCollection()
  {
    if (toBeCalc)
    {
      toBeCalc = false;
      calculateEntities();
    }
    return getCollection();
  }
  
  @Override
  public final List<T> EntityList()
  {
    if (toBeCalc)
      calculateEntities();
    return (List<T>) getEntityCollection().values();
  }
  
  @Override
  public final T getEntityById(String id)
  {
    return getEntityCollection().get(id);
  }
  
  abstract String getId(T entity);
  abstract String getEntityName();
  abstract Map<String, T> getCollection();
}
