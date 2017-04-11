
import java.lang.*;

public class Substring
{
  String substring;
  public Substring(String temp,int first,int second)
  {
    substring = temp.substring(first,first+second);
  }
  public String getsubstring()
  {
    return this.substring;
  }
  public static void main(String args[])
  {
    Integer firstnum = Integer.parseInt(args[1]);
    Integer secondnum = Integer.parseInt(args[2]);
    Substring temp = new Substring(args[0],firstnum,secondnum);
    String subtemp = temp.getsubstring();
    System.out.println(subtemp);
  }
}
