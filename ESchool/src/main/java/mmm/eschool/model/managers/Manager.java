package mmm.eschool.model.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mmm.eschool.AnException;
import mmm.eschool.AnException.Types;
import org.hibernate.classic.Session;

/**
 *
 * @author Mariyan
 */
public abstract class Manager<T>
{ 
  Manager()
  {
    calculateEntities();
  }
  
  private void calculateEntities()
  {
    if (!isCalc())
    {
      getCollection().clear();
      final Session dataSession = mmm.eschool.model.managers.HibernateUtil.getDataSession();
      final List<T> newEntityData = dataSession.createQuery("from " + getEntityName()).list();
      dataSession.close();
      for (final T entity : newEntityData)
        getCollection().put(getId(entity), entity);
      setIsCalc(true);
    }
  }
  
  public final boolean add(final T entity) throws AnException
  {
    if (entity != null)
    {
      if (getCollection().containsKey(getId(entity)))
        throw new AnException(Types.ENTITY_EXIST);
      else
      {
        HibernateUtil.add(entity);
        setIsCalc(false);
        calculateEntities();
        return true;
      }
    }
    return false;
  }
  
  public final T del(final Integer id) throws AnException
  {
    if (id != null)
    {
      if (!getCollection().containsKey(id))
        throw new AnException(Types.ENTITY_NOT_EXIST);
      else
      {
        final T entity = getCollection().get(id);
        HibernateUtil.del(entity);
        // to be tested
        getCollection().remove(id);
//        setIsCalc(false);
//        calculateEntities();
        return entity;
      }
    }
    return null;
  }

  public final boolean update(final T entity) throws AnException
  {
    if (entity != null)
    {
//      if (!getCollection().containsKey(getId(entity)))
//        throw new AnException(Types.ENTITY_NOT_EXIST);
      {
        HibernateUtil.update(entity);
        // to be tested
        getCollection().put(getId(entity), entity);
//        setIsCalc(false);
//        calculateEntities();
      }
      return true;
    }
    return false;
  }
  
  public final List<T> getEntityList()
  {
    return new ArrayList(getCollection().values());
  }

  public final T getEntityById(int id)
  {
    return getCollection().get(id);
  }
  
  abstract boolean isCalc();
  abstract void setIsCalc(boolean toCalc);
  abstract Map<Integer, T> getCollection();
  abstract Integer getId(T entity);
  abstract String getEntityName();
 // public Manager getManager() { return this; }
}
