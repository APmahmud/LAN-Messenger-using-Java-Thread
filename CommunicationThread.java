import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class CommunicationThread extends Thread {
public Socket [] socketArray;
 public Socket socket;
 public ClientIdentity [] clIdnAR;
  public Socket DestSocket ;
 
 public CommunicationThread(Socket socket,Object socketArray,Object clIdnAR){
  this.clIdnAR=(ClientIdentity[]) clIdnAR;
  this.socketArray=(Socket[]) socketArray;
  this.socket=socket;
 }
 
 
 public void run()  {
 
  String DesName=null;
  while (true) {
  
  try{
  PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
  printWriter.println("give ur destination :");
  BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
  DesName=bufferedReader.readLine();
  for(int i=0; i<clIdnAR.length; i++){
    System.out.println("Thread running " ) ;
   if(DesName.equals(clIdnAR[i].name)){
    DestSocket=clIdnAR[i].socket;
    break;
   }
  }
  
   PrintWriter printD = new PrintWriter(DestSocket.getOutputStream(),true);
      
  
        String messege=bufferedReader.readLine();
          System.out.println("incoming Source client msg: "+ messege);
          printD.println(messege);
  
  
  
   
  
  
//  Server Risk = new Server() ;
//   ClientIdentity [] Jk = Risk.returner() ;
//   clIdnAR = Jk ; 
//   
//   for (int i = 0 ; i<clIdnAR.length ; i++ ) {
//     System.out.println(clIdnAR[i]) ;
//   }

  }
  catch(Exception e){
    
   e.printStackTrace();

  }
  
  }
 }

}
