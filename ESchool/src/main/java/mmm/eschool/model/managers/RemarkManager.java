package mmm.eschool.model.managers;

import java.util.Hashtable;
import java.util.Map;
import mmm.eschool.model.Remark;

/**
 *
 * @author Mariyan
 */
public class RemarkManager extends Manager<Remark> 
{
  private static final Map<Integer, Remark> remarks = new Hashtable<Integer, Remark>();
  public static boolean isCalc = false;

  @Override
  public boolean isCalc() { return isCalc; }
  @Override
  public void setIsCalc(boolean toCalc) { isCalc = toCalc; }
  
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
