package mmm.eschool.model;

import java.util.List;
import mmm.eschool.EntityNotExistException;

/**
 *
 * @author Mariyan
 */
public interface EntityManager<T> 
{
  boolean add(T entityObject) throws EntityNotExistException;
  T del(String id) throws EntityNotExistException;
  boolean update(T entityObject) throws EntityNotExistException;
  List<T> EntityList();
  T getEntityById(String id) throws EntityNotExistException;
}
