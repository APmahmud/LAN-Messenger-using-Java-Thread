import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
//import java.io.IOException;
import java.io.InputStreamReader;
//import java.net.Socket;
import java.io.PrintWriter;
import java.io.ObjectOutputStream ;


public class Server {
 public static final int PORT=4444;
 
  public ClientIdentity clIdn;
  public static ClientIdentity [] clIdnAR = new ClientIdentity[5];
   public Socket socketArray[]=new Socket[5];
   
    public static ClientIdentity[] returner() {
 return clIdnAR ;
 }
   

 public static void main(String[] args)throws IOException {
  
  new Server().runServer();

 }

 
 public void runServer()throws IOException{
  ServerSocket serverSocket=new ServerSocket(PORT);
  System.out.println("Server is up & ready for connection.....");
 
 String userName=null;
  int i = 0 ;
  
  
  while(true){
    
    Socket temp = serverSocket.accept();
    
    if (i<5) {
    
       System.out.println(" loop"+i ) ; 
       
   socketArray[i]=temp ; 

   PrintWriter printWriter = new PrintWriter(socketArray[i].getOutputStream(),true);
   printWriter.println("give ur user name :");
   BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socketArray[i].getInputStream()));
   userName=bufferedReader.readLine();

   
   clIdn =new ClientIdentity(userName,socketArray[i]);
   clIdnAR[i]=clIdn;
    
   if (i==1) {
      CommunicationThread cmThread =new CommunicationThread(socketArray[0],socketArray,clIdnAR);
   cmThread.start();
     }
     
   if ( i!=0){
   CommunicationThread cmThread =new CommunicationThread(socketArray[i],socketArray,clIdnAR);
   cmThread.start();
   }
   
   i++ ;
  }
    else {
      PrintWriter printWriter = new PrintWriter(temp.getOutputStream(),true);
   printWriter.println("Server is at maximum capacity, Please Try again later");
    
    
    }
  }

   
  }

 
 


}

