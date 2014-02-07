/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mmm.eschool;

import java.sql.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author MMihov
 */
public class Constants
{
  public static final String USER = "user";
  public static final String ADMINISTRATOR = "Администратор";
  public static final String PARENT = "Родител";
  public static final String TEACHER = "Учител";
  public static final String STUDENT = "Ученик";
  
  public static Date resolveDate(String date)
  {
    if (date == null || date.isEmpty()) 
      return new Date(System.currentTimeMillis());
    int year, month, day;
    year = Integer.parseInt(date.substring(0, date.indexOf("-")));
    month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-", date.indexOf("-") + 1)));
    day = Integer.parseInt(date.substring(date.indexOf("-", date.indexOf("-") + 1) + 1, date.length()));
    return new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
  }
}
