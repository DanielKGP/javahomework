package kangkang.Model;
/**
 *
 * @author 康赣鹏
 * @studentID 14130140377
 * @email 1159838847@qq.com
 *
 *
 */
import kangkang.Controller.*;

public class PIMContact extends PIMEntity
{
  String firstname;
  String lastname;
  String emailaddress;
  public PIMContact(String Priority,String firstname,String lastname,String emailaddress)
  {
    super(Priority);
    this.firstname = firstname;
    this.lastname = lastname;
    this.emailaddress = emailaddress;
  }
  public PIMContact(String firstname,String lastname)
  {
    super();
    this.firstname = firstname;
    this.lastname = lastname;
  }
  public void setfirstname(String temp)
  {
    this.firstname = temp;
  }
  public String getfirstname()
  {
    return this.firstname;
  }
  public void setlastname(String temp)
  {
    this.lastname = temp;
  }
  public String getlastname()
  {
    return this.lastname;
  }
  public void setemailaddress(String temp)
  {
    this.emailaddress = temp;
  }
  public String getemailaddress()
  {
    return this.emailaddress;
  }
  public String toString()
  {
    return "CONT"+"   "+getPriority()+"   "+getfirstname()+"   "+getlastname()+"   "+getemailaddress();
  }
  public static PIMContact FromString(String s)
  {
    String[] ttemp = s.split("(   )");
    String[] tttemp  = new String[5];
    int index = 0;
    for(String var : ttemp)
    {
      if(index >= 5)
      {
          System.out.println("Input String cannot be transformed to PIMTodo");
          return null;
      }
      if(!var.equals(" "))
      {
        tttemp[index] = var;
        index += 1;
      }
    }
    return new PIMContact(tttemp[1],tttemp[2],tttemp[3],tttemp[4]);
  }
  public void fromString(String s)
  {
    String[] ttemp = s.split("(   )");
    String[] tttemp  = new String[5];
    int index = 0;
    for(String var : ttemp)
    {
      if(index >= 5)
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
    setfirstname(tttemp[2]);
    setlastname(tttemp[3]);
    setemailaddress(tttemp[4]);
  }


}
