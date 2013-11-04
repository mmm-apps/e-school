package mmm.eschool;

/**
 *
 * @author Mariyan
 */
public class EntityNotExistException extends Throwable
{
  private String msg = "";

  public EntityNotExistException(String errorMsg)
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
