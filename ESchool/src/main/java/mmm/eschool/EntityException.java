package mmm.eschool;

/**
 *
 * @author Mariyan
 */
public class EntityException extends Throwable
{
  private String msg = "";

  public EntityException(String errorMsg)
  {
    setMsg(errorMsg);
  }

  public final void setMsg(String msg)
  {
    this.msg = msg;
  }

  public final String getMsg()
  {
    return msg;
  }
}
