/*
 */

package mmm.eschool.model;

import java.util.List;
import mmm.eschool.EntityException;

/**
 *
 * @author Mariyan
 */
public interface EntityManager<T> 
{
  boolean add(T entityObject) throws EntityException;
  T del(String id) throws EntityException;
  boolean update(T entityObject) throws EntityException;
  List<T> objectList();
  T getById(String id);
}
