public class Son extends base
{
  String son;
  public Son(String base,String son)
  {
    super(base);
    this.son = son;
  }
  public void getSon()
  {
    System.out.println(this.son);
  }
}
