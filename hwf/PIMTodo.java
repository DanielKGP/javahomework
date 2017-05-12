/**
 *
 * @author 康赣鹏
 * @studentID 14130140377
 * @email 1159838847@qq.com
 *
 *
 */
import java.text.*;
import java.util.*;

public class PIMTodo extends PIMEntity implements PIMDate
{
  String Todo;
  Date Tododate;
  public PIMTodo(String Priority,String Todo,Date date)
  {
    super(Priority);
    this.Todo = Todo;
    this.Tododate = date;
  }
  public PIMTodo(String Todo,String t)
  {
    super();
    this.Todo = Todo;
    setTododate(t);
  }
  public PIMTodo()
  {
    super();
  }
  public void setTodo(String temp)
  {
    this.Todo = temp;
  }
  public String getTodo()
  {
    return this.Todo;
  }
  public void setDate(Date temp)
  {
    this.Tododate = temp;
  }
  public String getDate()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    return sdf.format(this.Tododate);
  }
  public Date GetDate()
  {
    return this.Tododate;
  }
  public Date getTododate(String temp)
  {
    try
    {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
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
    return "TODO"+"   "+getPriority()+"   "+getDate()+"   "+getTodo();
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
