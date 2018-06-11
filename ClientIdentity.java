import java.net.Socket;


public class ClientIdentity {
	String name;
	Socket socket;
	
	public ClientIdentity(String name,Socket socket){
		this.name=name;
		this.socket=socket;
	}

}
