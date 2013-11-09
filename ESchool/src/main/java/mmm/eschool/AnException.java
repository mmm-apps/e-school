package mmm.eschool;

/**
 *
 * @author Mariyan
 */
public class AnException extends Throwable
{
  private String message = "";
  private Types errorType;
  
  public enum Types 
  { 
    ENTITY_EXIST, ENTITY_NOT_EXIST; 
  }

  public AnException(String message)
  {
    this(message, null);
  }
  
  public AnException(Types errorType)
  {
    this(null, errorType);
  }
  
  public AnException(String errorMsg, Types errorType)
  {
    this.message = errorMsg;
    this.errorType = errorType;
  }

  public final void setMessage(String msg)
  {
    this.message = msg;
  }

  public final String getMsg()
  {
    return message;
  }

  public Types getErrorType()
  {
    return errorType;
  }

  public void setErrorType(Types errorType)
  {
    this.errorType = errorType;
  }
}
