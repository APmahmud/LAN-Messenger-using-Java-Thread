import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;



public class ThreadStarter {
  Socket socket;
  static Scanner sc =new Scanner(System.in);
 
 public ThreadStarter (Socket socket){
  this.socket=socket;
 }
 
 public void run(){
  try{
   BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
   System.out.print(": "+bufferedReader.readLine());
   String name=sc.nextLine();
   PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
   printWriter.println(name);
   String fi = bufferedReader.readLine() ;
   System.out.println(" One last step " + fi ) ; 
    String si = sc.nextLine() ;
    printWriter.println(si) ;
   
   
   WriteThread SS = new WriteThread(socket) ;
   SS.start() ;
   Reader RS = new Reader(socket) ;
   RS.start() ;
   
 

}
  catch (Exception e ) {
  }
 }
}

