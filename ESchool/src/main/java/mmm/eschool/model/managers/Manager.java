package mmm.eschool.model.managers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mmm.eschool.AnException;
import mmm.eschool.model.Subject;
import org.hibernate.classic.Session;

/**
 *
 * @author Mariyan
 */
public class Manager<T>
{
  private final Class<? extends Serializable> model;

  public Manager(final Class<? extends Serializable> model)
  {
    this.model = model;
  }
  
  public final boolean add(final T entity) throws AnException
  {
    if (entity != null)
    {
      HibernateUtil.add(entity);
      return true;
    }
    return false;
  }
  
  public final boolean del(final Integer id) throws AnException
  {
    if (id != null)
    {
      T entity = getEntityById(id);
      del(entity);
      return true;
    }
    return false;
  }
  
  public final boolean del(final T entity) throws AnException
  {
    if (entity != null)
    {
      HibernateUtil.del(entity);
      return true;
    }
    return false;
  }

  public final boolean update(final T entity) throws AnException
  {
    if (entity != null)
    {
      HibernateUtil.update(entity);
      return true;
    }
    return false;
  }
  
  public final ArrayList getEntityList()
  {
    if (model == null) return (ArrayList<T>) Collections.EMPTY_LIST;
    final Session dataSession = mmm.eschool.model.managers.HibernateUtil.getDataSession();
    final List<T> newEntityData = dataSession.createQuery("from " + model.getSimpleName()).list();
    dataSession.close();
    return new ArrayList(newEntityData);
  }

  public final T getEntityById(int id)
  {
    if (model == null) return null;
    final Session dataSession = mmm.eschool.model.managers.HibernateUtil.getDataSession();
    T entity = (T) dataSession.get(model, id);
    dataSession.close();
    return entity;
  }
 
  public Subject getSubjectByName(String subjectName)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
