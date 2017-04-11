
import java.text.*;
import java.util.*;

public class PIMTodo extends PIMEntity
{
  String Todo;
  Date Tododate;
  public PIMTodo(String Priority,String Todo,Date date)
  {
    super(Priority);
    this.Todo = Todo;
    this.Tododate = date;
  }
  public PIMTodo()
  {
    super();
    this.Todo = "";
  }
  public void setTodo(String temp)
  {
    this.Todo = temp;
  }
  public String getTodo()
  {
    return this.Todo;
  }
  public void setTododate(Date temp)
  {
    this.Tododate = temp;
  }
  public String getTododate()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    return sdf.format(this.Tododate);
  }
  public Date getTododate(String temp)
  {
    try
    {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      System.out.println(temp);
      Date date = sdf.parse(temp);
      return date;
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return null;
  }
  public void setTododate(String temp)
  {
    try
    {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      Date date = sdf.parse(temp);
      this.Tododate = date;
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }

  public String toString()
  {
    return "TODO"+"   "+getPriority()+"   "+getTododate()+"   "+getTodo();
  }

  public static PIMTodo FromString(String s)
  {
    String[] ttemp = s.split("(   )");
    String[] tttemp  = new String[4];
    int index = 0;
    for(String var : ttemp)
    {
      if(index >= 4)
      {
          System.out.println("Input String cannot be transformed to PIMTodo");
          System.out.println(index);
          return null;
      }
      if(!var.equals(" "))
      {
        tttemp[index] = var;
        index += 1;
      }
    }

    PIMTodo ttt = new PIMTodo();
    Date date = ttt.getTododate(tttemp[2]);

    return new PIMTodo(tttemp[1],tttemp[3],date);
  }

  public void fromString(String s)
  {
    String[] ttemp = s.split("(   )");
    String[] tttemp  = new String[4];
    int index = 0;
    for(String var : ttemp)
    {
      if(index >= 4)
      {
          System.out.println("Input String cannot be transformed to PIMTodo");
          return;
      }
      if(!var.equals(" "))
      {
        tttemp[index] = var;
        index += 1;
      }
    }
    setPriority(tttemp[1]);
    setTododate(tttemp[2]);
    setTodo(tttemp[3]);
    return;
  }
}
