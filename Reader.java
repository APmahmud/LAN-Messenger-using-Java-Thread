import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Reader extends Thread {
  public Socket NS ;
  
  public Reader(Socket P) {
    
    NS=P ;
  }
  
  public void run() {
   try {
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(NS.getInputStream()));
  
  
  while(true){
   
    String msg=bufferedReader.readLine();
    System.out.println("<--"+msg);
  }
   }catch(Exception e){
   e.printStackTrace();
  }
 }
  }
