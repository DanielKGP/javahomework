/**
 *
 * @author 康赣鹏
 * @studentID 14130140377
 * @email 1159838847@qq.com
 *
 *
 */
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class cal
{
  static String[] Month={"January","February","March","April","May","June","July","August","September","October","November","December"};
  public static int getDaysOfMonth(Date date)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
  }
  public static int getDaysOfWeek(Date date)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.DAY_OF_WEEK);
  }
  public static int StrToInt(String s)
  {
    try
    {
      int a = Integer.parseInt(s);
      return a;
    }
    catch(NumberFormatException e)
    {
      e.printStackTrace();
    }
    return -1;
  }

  public static void main(String[] args)
  {
    if(args.length == 2)
    {
      String month = args[0];
      String year = args[1];
      int m = StrToInt(month);
      System.out.println(Month[m-1]+" "+year);

      try
      {
        int Days;
        int WeekDay;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Days = getDaysOfMonth(sdf.parse(year+"-"+month));
        WeekDay = getDaysOfWeek(sdf.parse(year+"-"+month));

        System.out.println("Su Mo Tu We Th Fr Sa");
        int day = 1;
        System.out.print(" ");
        for(int i = 1;i <= Days+WeekDay-1;i++)
        {
          if(i < WeekDay)
          {
            System.out.print("   ");
          }
          else
          {
            if(day < 9)
            {
              System.out.print(day+"  ");
            }
            else
            {
              System.out.print(day+" ");
            }
            day++;
          }
          if(i%7 == 0)
          {
            if(day < 9)
            {
              System.out.println();
              System.out.print(" ");
            }
            else
            {
              System.out.println();
            }
          }
        }

      }
      catch(Exception e)
      {
        System.out.println(e);
      }
    }
    else
    {
      System.out.println("illegal input");
    }
  }
}
