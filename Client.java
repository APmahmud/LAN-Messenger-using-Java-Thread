import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
 static Scanner sc=new Scanner(System.in);

 public static void main(String[] args) throws UnknownHostException, IOException{
  //String name=args[0];
  Socket socket=new Socket("localhost",4444);
  
            System.out.println(" Array Created 0 " ) ; 
     ReadThread RS = new ReadThread(socket) ;
       RS.run();
       
       
     
   

 }

}
