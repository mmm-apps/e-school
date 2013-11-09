package mmm.eschool.model.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.AnException.Types;
import mmm.eschool.HibernateUtil;
import org.hibernate.classic.Session;

/**
 *
 * @author Mariyan
 */
public abstract class Manager<T>
{ 
  private synchronized Map<Integer, T> getEntityCollection()
  {
    if (toBeRecalc())
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
    setToRecalc(false);
  }
  
  public final boolean add(final T entity) throws AnException
  {
    if (entity != null)
    {
      if (getEntityCollection().containsKey(getId(entity)))
        throw new AnException(Types.ENTITY_EXIST);
      else
      {
        HibernateUtil.add(entity);
        if (!getEntityCollection().containsKey(getId(entity)))
        {
          getCollection().put(getId(entity), entity);
          setToRecalc(true);
        }
        return true;
      }
    }
    else
      return false;
  }
  
  public final T del(final Integer id) throws AnException
  {
    if (id != null)
    {
      if (!getEntityCollection().containsKey(id))
        throw new AnException(Types.ENTITY_NOT_EXIST);
      else
      {
        final T entity = getEntityCollection().get(id);
        HibernateUtil.del(entity);
        if (getEntityCollection().containsKey(getId(entity)))
        {
          getCollection().remove(getId(entity));
          setToRecalc(true);
        }
        return entity;
      }
    }
    else
      return null;
  }

  public final boolean update(T entity) throws AnException
  {
    if (entity != null)
    {
      if (!getEntityCollection().containsKey(getId(entity)))
        throw new AnException(Types.ENTITY_NOT_EXIST);
      {
        HibernateUtil.update(entity);
        getCollection().put(getId(entity), entity);
        setToRecalc(true);
      }
      return true;
    }
    else
      return false;
  }
  
  public final List<T> EntityList()
  {
    if (toBeRecalc())
      calculateEntities();
    return new ArrayList(getCollection().values());
  }

  public final T getEntityById(int id)
  {
    return getEntityCollection().get(id);
  }
  
  abstract boolean toBeRecalc();
  abstract void setToRecalc(boolean value);
  abstract Integer getId(T entity);
  abstract String getEntityName();
  abstract Map<Integer, T> getCollection();
}
