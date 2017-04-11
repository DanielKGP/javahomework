/**
 * 
 * @author 康赣鹏
 * @studentID 14130140377
 * @email 1159838847@qq.com
 * 
 * Sum Of Args
 * 
 */

public class SumOfArgs
{
  public static void main(String[] args)
  {
    int sum = 0;
    for(String str : args)
    {
      int temp = 0;
      //调用Integer类中的Integer.parseInt(String s)方法
      //将字符串转换为int 若不能转换为int 该方法会返回错误提醒
      try{
        temp = Integer.parseInt(str);
      }
      //若错误 则不做累加 继续循环
      catch(NumberFormatException e)
      {
        temp = 0;
        continue;
      }
      sum = sum + temp;
    }
    System.out.println(sum);
  }
}
