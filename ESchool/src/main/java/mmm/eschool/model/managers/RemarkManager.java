package mmm.eschool.model.managers;

import java.util.HashMap;
import java.util.Map;
import mmm.eschool.model.Remark;

/**
 *
 * @author Mariyan
 */
public class RemarkManager extends Manager<Remark> 
{
  private static boolean toBeRecalc = true;
  
  public static final Map<Integer, Remark> remarks = new HashMap<Integer, Remark>();

  @Override
  void setToRecalc(boolean value)
  {
    toBeRecalc = value;
  }

  @Override
  boolean toBeRecalc()
  {
    return toBeRecalc;
  }

  @Override
  Map<Integer, Remark> getCollection()
  {
    return remarks;
  }
  
  @Override
  String getEntityName()
  {
    return "Remark";
  }

  @Override
  Integer getId(Remark remark)
  {
    if (remark != null)
      return remark.getId();
    else
      return null;
  }
}
