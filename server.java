import java.util.*;
import java.net.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class server{
	public static void main(String args[]) throws IOException{
		Scanner sc= new Scanner(System.in);
		int i=0;
		String output,input;
		ServerSocket ss=new ServerSocket(5668);
		Socket s=ss.accept();
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		do{
			
			input=dis.readUTF();
			System.out.println("Client sent:"+input);
			if(input.equalsIgnoreCase("bye"))
			{
				break;
			}
			System.out.print("enter anything:");
			output=sc.nextLine();
			dos.writeUTF(output);			
		i++;
		}while(i!=4);
		s.close();
	}
}