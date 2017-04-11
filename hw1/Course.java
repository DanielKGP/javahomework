/**
 * 
 * @author 康赣鹏
 * @studentID 14130140377
 * @email 1159838847@qq.com
 * 
 * Course
 * 
 */

public class Course
{
  public String Coursename;
  public Course(String temp)
  {
    Coursename = temp;
  }
  public String get_course_name()
  {
    return this.Coursename;
  }
  public static void main(String[] args)
  {
    if(args.length == 0)
    {
      Student a;
    }
    if(args.length == 1)
    {
      Student a = new Student(args[0]);
    }
    if(args.length == 2)
    {
      Student a = new Student(args[0],args[1]);
      System.out.println(a.getCourseName());
    }
    if(args.length > 2)
    {
      Student a = new Student(args[0],args[1]);
      for(int i = 2;i < args.length;i++)
      {
        a.addCourse(args[i]);
      }
      System.out.println(a.getCourseName());
    }
  }
}
