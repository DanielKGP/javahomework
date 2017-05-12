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

 public class PIMCollection extends ArrayList<PIMEntity>
 {
   public ArrayList<PIMNote> getNotes()
   {
     ArrayList<PIMNote> temp  = new ArrayList<PIMNote>();
     for(PIMEntity item : this)
     {
       if(item instanceof PIMNote)
       {
         temp.add((PIMNote)item);
       }
     }
     return temp;
   }

   public ArrayList<PIMTodo> getTodos()
   {
     ArrayList<PIMTodo> temp  = new ArrayList<PIMTodo>();
     for(PIMEntity item : this)
     {
       if(item instanceof PIMTodo)
       {
         temp.add((PIMTodo)item);
       }
     }
     return temp;
   }

   public ArrayList<PIMAppointment> getAppointments()
   {
     ArrayList<PIMAppointment> temp  = new ArrayList<PIMAppointment>();
     for(PIMEntity item : this)
     {
       if(item instanceof PIMAppointment)
       {
         temp.add((PIMAppointment)item);
       }
     }
     return temp;
   }

   public ArrayList<PIMContact> getContacts()
   {
     ArrayList<PIMContact> temp  = new ArrayList<PIMContact>();
     for(PIMEntity item : this)
     {
       if(item instanceof PIMContact)
       {
         temp.add((PIMContact)item);
       }
     }
     return temp;
   }

   public ArrayList<PIMEntity> getItemsForDate(Date d)
   {
     ArrayList<PIMEntity> temp = new ArrayList<PIMEntity>();
     for (PIMEntity item : this)
     {
       if((item instanceof PIMDate) && ((PIMDate)item).GetDate().equals(d))
       {
         temp.add(item);
       }
     }
     return temp;
   }

   public Date transdate(String temp)
   {
     try
     {
       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
       Date date = sdf.parse(temp);
       return date;
     }
     catch(Exception e)
     {
       System.out.println(e);
     }
     return null;
   }

   public static void main(String[] args)
   {
     PIMCollection c = new PIMCollection();
     c.add(new PIMTodo("Todo1","04/20/2017"));
     c.add(new PIMTodo("Todo2","04/21/2017"));
     c.add(new PIMNote("Note1"));
     c.add(new PIMNote("Note2"));
     c.add(new PIMAppointment("Appo1","04/20/2017"));
     c.add(new PIMAppointment("Appo2","04/21/2017"));
     c.add(new PIMContact("old","john"));
     c.add(new PIMContact("elegant","lady"));

     ArrayList<PIMTodo> Todos = c.getTodos();
     for (PIMTodo item : Todos)
     {
       System.out.println(item.getClass().toString());
       System.out.println(item.toString());
     }
     ArrayList<PIMNote> Notes = c.getNotes();
     for (PIMNote item : Notes)
     {
       System.out.println(item.getClass().toString());
       System.out.println(item.toString());
     }
     ArrayList<PIMContact> Contacts = c.getContacts();
     for (PIMContact item : Contacts)
     {
       System.out.println(item.getClass().toString());
       System.out.println(item.toString());
     }
     ArrayList<PIMAppointment> Appointments = c.getAppointments();
     for (PIMAppointment item : Appointments)
     {
       System.out.println(item.getClass().toString());
       System.out.println(item.toString());
     }

     Date date = c.transdate("04/20/2017");

     ArrayList<PIMEntity> times = c.getItemsForDate(date);

     for (PIMEntity item : times)
     {
       System.out.println(item.getClass().toString());
       System.out.println(item.toString());
     }

   }

 }
