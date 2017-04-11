/**
 * 
 * @author 康赣鹏
 * @studentID 14130140377
 * @email 1159838847@qq.com
 * 
 * Student
 * 
 */

public class Student
{
  private String Studentname;
  private String StudentId;
  public java.util.ArrayList<Book> SelectedBook;
  public java.util.ArrayList<Course> SelectedCourse;
  public void addBook(String bookName)
  {
    this.SelectedBook.add(new Book(bookName));
  }
  public void addCourse(String courseName)
  {
    this.SelectedCourse.add(new Course(courseName));
  }
  public String get_student_name()
  {
    return this.Studentname;
  }
  public String get_student_ID()
  {
    return this.StudentId;
  }
  public void removeCourse(String temp_CourseName)
  {
    
    this.SelectedCourse.remove(temp_CourseName);
    System.out.println("remove "+temp_CourseName +"successfully" );
  }
  public Student(String temp_ID)
  {
    this.StudentId = temp_ID;
  }
  public Student(String temp_ID,String temp_CourseName)
  {
    StudentId = temp_ID;
    SelectedCourse = new java.util.ArrayList<Course>();
    SelectedCourse.add(new Course(temp_CourseName));
    //System.out.println(getCourseName());
  }
  public Student(String temp_ID,String temp_CourseName,String temp_bookName)
  {
    StudentId = temp_ID;
    SelectedBook = new java.util.ArrayList<Book>();
    SelectedBook.add(new Book(temp_bookName));
    SelectedCourse = new java.util.ArrayList<Course>();
    SelectedCourse.add(new Course(temp_CourseName));
    //System.out.println(getCourseName());
  }

  public String getCourseName()
  {
    String temp="";

    for(Course course : SelectedCourse)
    {
      temp = temp + course.Coursename + " and " ;
    }
    temp = temp.substring(0,temp.length()-5);
    return StudentId+" choose "+temp;
  }
}
