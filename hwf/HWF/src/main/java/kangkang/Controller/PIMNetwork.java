package kangkang.Controller;

import java.io.*;
import java.net.*;

import com.google.gson.*;
import kangkang.Model.*;

public class PIMNetwork
{
  private URL serviceUrl = null;
  private BufferedReader in = null;
  private PrintWriter out = null;
  private URLConnection connection = null;

  public PIMNetwork()
  {
    serviceUrl = null;
    in = null;
    out = null;
    connection = null;
  }
  private void InitNetwork(String[] str)
  {
    if (str.length != 2)
    {
      serviceUrl = null;
    }
    String Urlstr = "http://";
    str[1] = str[1].toLowerCase();
    if(str[1].contains("all"))
    {
      Urlstr += str[0] + "/api/get/all";
    }
    else if(str[1].contains("todo"))
    {
      Urlstr += str[0] + "/api/get/todos";
    }
    else if(str[1].contains("note"))
    {
      Urlstr += str[0] + "/api/get/notes";
    }
    else if(str[1].contains("cont"))
    {
      Urlstr += str[0] + "/api/get/contacts";
    }
    else if(str[1].contains("appo"))
    {
      Urlstr += str[0] + "/api/get/appointments";
    }
    else
    {
      serviceUrl = null;
    }
    try
    {
      URL temp = new URL(Urlstr);
      serviceUrl = temp;
    }
    catch(Exception e)
    {
      serviceUrl = null;
    }
  }

  public boolean Open(String[] str)
  {
    InitNetwork(str);
    if(serviceUrl == null)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  public boolean Write(String[] str)
  {
    String result ="";
    if(serviceUrl == null)
    {
      System.out.println("Url isn't exist");
      return false;
    }
    try
    {
      connection = serviceUrl.openConnection();
      connection.setRequestProperty("accept","*/*");
      connection.setRequestProperty("Content-Type","application/json");

      connection.setDoOutput(true);
      connection.setDoInput(true);
      out = new PrintWriter(connection.getOutputStream());

      Gson gson = new Gson();
      String json = gson.toJson(str);

      out.print(json);
      out.flush();

      in = new BufferedReader(new InputSteamReader(connection.getInputStream(),"UTF8"));
      String line = "";
      while((line = in.readLine())!=null)
      {
        result += line;
      }
      int num = 0;
      try
      {
        num = Integer.parseInt(result);
        if(num >= 0)
        {
          return true;
        }
        else
        {
          return false;
        }
      }
      catch (Exception e)
      {
        return false;
      }
    }
    catch (Exception e)
    {
      System.out.println("Post Request Error!");
      return false;
    }
  }
  public String[] Read()
  {
    String result = "";
    if (serviceUrl == null)
    {
      System.out.println("Url Error");
      return null;

    }
    try
    {
      connection = serviceUrl.openConnection();
      connection.setRequestProperty("accept","*/*");
      connection.setRequestProperty("connection","Keep-Alive");

      connection.connect();

      in = new BufferedReader(new InputSteamReader(connection.getInputStream(),"UTF8"));
      String line ="";
      while((line = in.readLine())!=null)
      {
        result += line;
      }

    }
    catch (Exception e)
    {
      System.out.println("failed to get Request");
      return null;
    }
    Gson gson = new Gson();

    String[] resultes = gson.fromJson(result,String[].class);
    return resultes;
  }
  public void Close()
  {
    serviceUrl = null;
    connection = null;
    try
    {
      if(in != null)
      {
        in.close();
      }
      if(out != null)
      {
        out.close();
      }
    }
    catch(Exception e)
    {
      System.out.println("failed to close");
    }
  }
  public static void main(String[] args)
  {
    System.out.println("PIMNetwork !");
  }
}
