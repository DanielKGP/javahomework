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

public class PIMNote extends PIMEntity
{
  String Note;
  public PIMNote(String Priority,String Note)
  {
    super(Priority);
    this.Note = Note;
  }
  public PIMNote(String Note)
  {
    super();
    this.Note = Note;
  }
  public void setNote(String temp)
  {
    this.Note = temp;
  }
  public String getNote()
  {
    return this.Note;
  }
  public String toString()
  {
    return "NOTE"+"   "+getPriority()+"   "+getNote();
  }
  public static PIMNote FromString(String s)
  {
    String[] ttemp = s.split("(   )");
    String[] tttemp  = new String[3];
    int index = 0;
    for(String var : ttemp)
    {
      if(index >= 3)
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
    return new PIMNote(tttemp[1],tttemp[2]);
  }
  public void fromString(String s)
  {
    String[] ttemp = s.split("(   )");
    String[] tttemp  = new String[3];
    int index = 0;
    for(String var : ttemp)
    {
      if(index >= 3)
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
    setNote(tttemp[2]);
    return;
  }
}
