
/**
 *
 * @author 康赣鹏
 * @studentID 14130140377
 * @email 1159838847@qq.com
 *
 *
 */

import java.util.*;
import java.io.*;

public class PIMFile
{

  File file = new File("PIMEntity.txt");

  public boolean Open()
  {
    try
    {
      if(file.exists() && file.isFile())
      {}
      else
      {
        file.createNewFile();
      }
      return true;
    }
    catch (Exception e)
    {
      System.out.println("File cannot be opened!");
      return false;
    }
  }

  public boolean write(PIMEntity[] list,int listcount)
  {
    try
    {
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));
      for(int index = 0;index < listcount;index++)
      {
        bw.write(list[index].toString()+"\n");
      }
      bw.flush();
      bw.close();
      return true;
    }
    catch(Exception e)
    {
      System.out.println(e);
      return false;
    }
  }

  public String[] getInformation()
  {
    try
    {
      ArrayList<String> templist = new ArrayList<String>();
      BufferedReader br = new BufferedReader(new FileReader(file));
      String temp = "";
      while((temp = br.readLine())!= null)
      {
        templist.add(temp);
      }
      br.close();
      return templist.toArray(new String[templist.size()]);
    }
    catch(Exception e)
    {
      System.out.println("Read File failed!.");
      return null;
    }

  }
}
