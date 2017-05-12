
/**
 *
 * @author 康赣鹏
 * @studentID 14130140377
 * @email 1159838847@qq.com
 *
 *
 */


import java.text.*;
import java.util.*;
import java.io.*;

public class PIMManager
{
  private final int listnum = 100;
  private PIMEntity[] list = new PIMEntity[100];
  private int listcount = 0;
  File file = new File("PIMEntity.txt");

  public void addPIMEntity(PIMEntity temp)
  {
    if(listcount < listnum)
    {
      list[listcount] = temp;
      listcount += 1;
    }
    else
    {
      System.out.println("The imformation is overloaded");
    }
  }

  public void create()
  {

    Scanner IN = new Scanner(System.in);
    System.out.println("Enter an item type( todo, note, contact or appointment)");
    String ItemType = IN.next();
    switch(ItemType.toLowerCase())
    {
      case "todo":
        createTodo();
        break;
      case "note":
        createNote();
        break;
      case "contact":
        createContact();
        break;
      case "appointment":
        createAppointment();
        break;
      default:
        System.out.println("illegel input");
    }

  }
  public void createTodo()
  {
    String item ="todo";
    Date date = new Date();
    date = formatdate(item);
    System.out.println("Enter todo text:");

    Scanner IN = new Scanner(System.in);
    String Todotext = IN.nextLine();

    System.out.println("Enter todo priority:");
    String Todopriority = IN.next();

    PIMTodo Todo = new PIMTodo(Todopriority,Todotext,date);

    PIMEntity temp = (PIMEntity)Todo;

    addPIMEntity(temp);
  }
  public void createAppointment()
  {
    String item = "appointment";
    Date date = new Date();
    date = formatdate(item);
    System.out.println("Enter appointment description:");
    Scanner IN = new Scanner(System.in);
    String AppoDescription = IN.nextLine();

    System.out.println("Enter appointment priority:");
    String priority = IN.next();

    PIMAppointment Appo = new PIMAppointment(priority,date,AppoDescription);
    addPIMEntity(Appo);
  }
  public void createNote()
  {
    System.out.println("Enter note text:");

    Scanner IN = new Scanner(System.in);
    String Todotext = IN.nextLine();

    System.out.println("Enter note priority:");
    String Todopriority = IN.next();

    PIMNote note = new PIMNote(Todopriority,Todotext);

    PIMEntity temp = (PIMEntity)note;

    addPIMEntity(temp);

  }
  public void createContact()
  {
    Scanner IN = new Scanner(System.in);

    System.out.println("Enter contact priority:");
    String contactpriority = IN.next();

    System.out.println("Enter first name:");
    String firstname = IN.next();

    System.out.println("Enter last name:");
    String lastname = IN.next();

    System.out.println("Enter email address:");
    String emailaddress = IN.next();

    PIMContact contact = new PIMContact(contactpriority,firstname,lastname,emailaddress);

    PIMEntity temp = (PIMEntity)contact;

    addPIMEntity(temp);

  }

  public Date formatdate(String item)
  {
    Scanner IN = new Scanner(System.in);
    System.out.println("Enter date for "+item+" item:");
    String Itemdate = IN.next();
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    try
    {
      date = sdf.parse(Itemdate);
      //System.out.println(sdf.format(date));
    }
    catch (ParseException e)
    {
      System.out.println(e.getMessage());
    }
    return date;
  }

  public void list()
  {
    System.out.println("There are " + listcount+" items.");
    for (int index = 0;index < listcount;index++)
    {
      System.out.print("Items "+index+":");
      System.out.println(list[index].toString());
    }
  }

  public void Save()
  {
    PIMFile f = new PIMFile();
    if(f.Open())
    {
      if(f.write(list,listcount))
      {
        System.out.println("Save successfully!");
      }
      else
        System.out.println("Save unsuccessfully!");
    }
    /*try
    {
      System.out.println(file.isFile());

      BufferedWriter bw = new BufferedWriter(new FileWriter(file));

      for(int index = 0;index < listcount;index++)
      {
        bw.write(list[index].toString()+"\n");
      }
      bw.flush();
      bw.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }*/
  }
  public void Load()
  {
    PIMFile f = new PIMFile();

    String[] listInfo = f.getInformation();

    int count = 0;
    for (int i = 0;i <listInfo.length;i++ )
    {
      switch(listInfo[i].substring(0,4))
      {
        case"TODO":
            addPIMEntity(PIMTodo.FromString(listInfo[i]));
            count++;
            break;
        case"NOTE":
            addPIMEntity(PIMNote.FromString(listInfo[i]));
            count++;
            break;
        case"CONT":
            addPIMEntity(PIMContact.FromString(listInfo[i]));
            count++;
            break;
        case"APPO":
            addPIMEntity(PIMAppointment.FromString(listInfo[i]));
            count++;
            break;
        default:
            System.out.println(listInfo[i]+" is broken");
      }
    }
  }


  public void manageSystem()
  {
    Scanner IN = new Scanner(System.in);
    System.out.println("Welcome to PIM.");
    while(true)
    {
      System.out.println("---Enter a command (suported commands are List Create Save Load Quit)---");
      String command = IN.next();
      switch (command.toLowerCase())
      {
        case "list":
          list();
          break;
        case "create":
          create();
          break;
        case "save":
          Save();
          break;
        case "load":
          Load();
          break;
        case "quit":
          return;
        default:
          System.out.println("unexpected command,please input again");
          continue;
      }
    }
  }

  public static void main(String[] args)
  {
    PIMManager manager = new PIMManager();
    manager.manageSystem();

  }
}
