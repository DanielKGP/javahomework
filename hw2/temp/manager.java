
public class manager
{
  public static void main(String[] args)
  {
    String b = " base ";
    String s = " son ";
    Son theson = new Son(b,s);
    base temp = (base)theson;
    System.out.println(temp.base);
    temp.getSon();

  }
}
