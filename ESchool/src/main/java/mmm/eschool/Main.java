/*
 */

package mmm.eschool;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Mariyan
 */
public class Main 
{
  public static void main(String[] args)
  {
    SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    org.hibernate.classic.Session openSession = sessionFactory.openSession();
    openSession.beginTransaction();
    Object uniqueResult = openSession.createSQLQuery("Select * from eschool.test;").uniqueResult();
    System.out.println(uniqueResult);
    openSession.getTransaction().commit();
  }
}
