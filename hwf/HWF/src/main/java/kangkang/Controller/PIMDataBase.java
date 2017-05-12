package kangkang.Controller;

import java.sql.*;
import java.util.LinkedList;
import kangkang.Model.*;

public class PIMDataBase
{
  public PIMDataBase()
  {
    connection = null;
    statement = null;
  }
  Connection connection;
  Statement statement;
  private void InitDatabase()
  {
    try
    {
      statement.execute("CREATE TABLE IF NOT EXISTS PIMTodo(Priority TEXT NOT NULL,PIMDate TEXT NOT NULL,Content TEXT,CONSTRAINT PIMTodo_PK PRIMARY KEY (Priority,PIMDate,Content));");
      statement.execute("CREATE TABLE IF NOT EXISTS PIMNote(Priority TEXT NOT NULL,Content TEXT,CONSTRAINT PIMNote_PK PRIMARY KEY (Priority,Contains));");
      statement.execute("CREATE TABLE IF NOT EXISTS PIMContact(Priority TEXT NOT NULL,FirstName TEXT,LastName TEXT,EmailAddress TEXT,CONSTRAINT PIMCont_PK PRIMARY KEY (Priority,FirstName,LastName,EmailAddress));");
      statement.execute("CREATE TABLE IF NOT EXISTS PIMAppointment(Priority TEXT NOT NULL,PIMDate TEXT NOT NULL,Content TEXT,CONSTRAINT PIMAppo_PK PRIMARY KEY (Priority,PIMDate,Content));");
      statement.execute("CREATE VIEW IF NOT EXISTS PIMTodoView (PIMEntity) AS SELECT 'TODO   '||Priority||'   '||PIMDate||'   '||Content FROM PIMTodo;");
      statement.execute("CREATE VIEW IF NOT EXISTS PIMNoteView (PIMEntity) AS SELECT 'NOTE   '||Priority||'   '||Content FROM PIMNote;");
      statement.execute("CREATE VIEW IF NOT EXISTS PIMContactView (PIMEntity) AS SELECT 'CONT   '||Priority||'   '||FirstName||'   '||LastName||'   '||EmailAddress FROM PIMContact;");
      statement.execute("CREATE VIEW IF NOT EXISTS PIMEntities AS SELECT PIMEntity FROM PIMTodoView UNION ALL SELECT PIMEntity FROM PIMNoteView UNION ALL SELECT PIMEntity FROM PIMContactView UNION ALL SELECT PIMEntity FROM PIMAppointmentView;");
      connection.commit();
    }
    catch (Exception e)
    {
      System.out.println("failed to init database");
    }
  }

  public boolean Open(String[] str )
  {
    try
    {
      Class.forName(str[0]);
      connection = DriverManager.getConnection(str[1]);
      connection.setAutoCommit(false);
      statement = connection.createStatement();
      InitDatabase();
      return true;
    }
    catch (Exception e)
    {
      System.out.println("Init database failure!");
      return false;
    }
  }
  public boolean write(PIMCollection collection)
  {
    try
    {
      for(PIMTodo item:collection.getTodos())
      {
        statement.executeUpdate("REPLACE INTO PIMTodo VALUES"+"('"+item.getPriority()+"','"+item.getDate()+"','"+item.getTodo()+"');");
      }
      for(PIMNote item:collection.getNotes())
      {
        statement.executeUpdate("REPLACE INTO PIMNote VALUES"+"('"+item.getPriority()+"','"+item.getNote()+"');");
      }
      for(PIMContact item:collection.getContacts())
      {
        statement.executeUpdate("REPLACE INTO PIMContact VALUES"+"('"+item.getPriority()+"','"+item.getfirstname()+"','"+item.getlastname()+"','"+item.getemailaddress()+"');");
      }
      for(PIMAppointment item:collection.getAppointments())
      {
        statement.executeUpdate("REPLACE INTO PIMAppointment VALUES"+"('"+item.getPriority()+"','"+item.getDate()+"','"+item.getdescription()+");");
      }
      connection.commit();
      return true;
    }
    catch(Exception e)
    {
      System.out.println("Fail to update database");
      return false;

    }
  }
  public String[] Read()
  {
    LinkedList<String> resultList = new LinkedList<String>();
    try
    {
      ResultSet resultset = statement.executeQuery("SELECT * FROM PIMEntities;");
      while(resultset.next())
      {
        resultList.add(resultset.getString("PIMEntity"));
      }
      String[] result = new String[resultList.size()];
      resultset.close();
      return resultList.toArray(result);

    }
    catch (Exception e)
    {
      System.out.println("fail to read database");
      return null;
    }

  }
  public static void main(String[] args)
  {
    PIMDataBase DB = new PIMDataBase();
    System.out.println("database");
  }

}
