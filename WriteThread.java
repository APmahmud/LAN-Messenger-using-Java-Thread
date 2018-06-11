import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class WriteThread extends Thread {
  public Socket Soc ;
  public WriteThread(Socket SS) {
    Soc = SS ;
  }
  
  

  public void run() {
    while ( true) {
      
    Scanner MLR = new Scanner( System.in) ;
    
    
    String Ft= MLR.nextLine() ;
    
    try {
   PrintWriter GT = new PrintWriter(Soc.getOutputStream(),true);
  GT.println(Ft);
    }
    catch(IOException e) {
      
    }
    }
}
  }

