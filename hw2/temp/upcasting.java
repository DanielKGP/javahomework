

public class base
{
  String base;
  public base(String temp)
  {
    this.base = temp;
  }
}

public class Son extends base
{
  String son;
  public Son(String base,String son)
  {
    super(base);
    this.son = son;
  }
}

public class manager
{
  public static void main(String[] args)
  {
    String b = " base ";
    String s = " son ";
    Son theson = new Son(b,s);
    System.out.println((base)theson.base);

  }
}
