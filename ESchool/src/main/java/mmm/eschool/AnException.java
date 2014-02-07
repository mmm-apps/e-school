package mmm.eschool;

/**
 *
 * @author Mariyan
 */
public class AnException extends Throwable
{
  private String message = "";
  private Throwable err = null;
  private Types errorType;
  
  public enum Types 
  { 
    ENTITY_EXIST("Обекта съшествува в базата данни"),
    ENTITY_NOT_EXIST("Обекта НЕ съшествува в базата данни"),
    ENTITY_NULL("Обекта Невалиден или липсват данни"), 
    ROLLBACK("Възникна проблем при записването на данните"); 
    public String msg;
    Types(String msg)
    {
      this.msg = msg;
    }
  }

  public AnException(String message, Throwable err)
  {
    this.message = message;
    this.err = err;
  }
  
  public AnException(String message)
  {
    this(message, null);
  }
  
  public AnException(Types errorType, Throwable err)
  {
    this(errorType.msg, err);
  }
  
  public AnException(Types errorType)
  {
    this(errorType.msg, null);
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

  public Throwable getErr()
  {
    return err;
  }
}
