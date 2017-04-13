
import java.text.*;
import java.util.*;


public class PIMAppointment extends PIMEntity implements PIMDate
{
  Date Appointmentdate = new Date();
  String description;
  public PIMAppointment(String Priority,Date date,String description)
  {
    super(Priority);
    this.Appointmentdate = date;
    this.description = description;
  }
  public PIMAppointment()
  {
    super();
  }
  public void setdescription(String temp)
  {
    this.description = temp;
  }
  public String getdescription()
  {
    return this.description;
  }
  public void setDate(Date temp)
  {
    this.Appointmentdate = temp;
  }
  public String getDate()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    return sdf.format(this.Appointmentdate);
  }
  public Date getAppointmentdate(String temp)
  {
    try
    {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      //System.out.println(temp);
      Date date = sdf.parse(temp);
      return date;
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return null;
  }

  public void setAppointmentdate(String temp)
  {
    try
    {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      Date date = sdf.parse(temp);
      this.Appointmentdate = date;
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }

  public String toString()
  {
    return "APPO"+"   "+getPriority()+"   "+getDate()+"   "+getdescription();
  }
  public static PIMAppointment FromString(String s)
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
    PIMAppointment ttt = new PIMAppointment();
    Date date = ttt.getAppointmentdate(tttemp[2]);
    return new PIMAppointment(tttemp[1],date,tttemp[3]);

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
    //if(!tttemp[0].equals("Todo"))
    //{
      //System.out.println("Input String cannot be transformed to PIMTodo");
      //return
    //}
    setPriority(tttemp[1]);
    setAppointmentdate(tttemp[2]);
    setdescription(tttemp[3]);
    return;

  }
}
