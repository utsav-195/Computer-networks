import java.util.*;
import java.net.*;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
public class client{
	public static void main(String args[]) throws IOException
	{
		Scanner sc=new Scanner(System.in);
		String input,output;
		Socket s=new Socket("localhost",5668);
		int i=0;
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		DataInputStream dis=new DataInputStream(s.getInputStream());
		
		do{
		System.out.print("enter anthing:");
			output=sc.nextLine();
			dos.writeUTF(output);
			if(output.equalsIgnoreCase("bye")){
				break;
			}
		
		input=dis.readUTF();
		System.out.println("server sent this:"+input);
		i++;
		}while(i!=4);
		s.close();
	}
}