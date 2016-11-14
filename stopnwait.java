import java.util.*;
import java.util.concurrent.TimeUnit;

public class stopnwait {
    static int i=0;
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no. of frames : ");
        int n=sc.nextInt();
        String frame[]= new String[n];
        for(i=0;i<n;i++)
            {
                System.out.print("Enter the value of frame "+ i+":");
                frame[i]=sc.next();
            }
        System.out.println();
       i=0;     
       do
       {
        System.out.println("Select an option :");
        System.out.println("1. Data Transfer Successful");
        System.out.println("2. Data Lost");
        System.out.println("3. Acknowledge Lost");
        System.out.println("4. Data with Error");
        int c=sc.nextInt();
          sender(i,frame);
          try{
                TimeUnit.SECONDS.sleep(2);}
                catch(Exception e){}
          receiver(i,frame,c);
          if(c==1 && c<=4)
              i++;
       }while(n!=i);
        
       
    }   
    
    public static void sender(int s,String[] frame)
    {
        System.out.println("The frame being sent is " + (s%2));
        System.out.println("Data sent :"+frame[s]);
        System.out.println();
    }
    
    public static void receiver(int s,String[] frame,int c)
    {
        Scanner sc= new Scanner(System.in);
        switch(c)
        {
            case 1 : 
                     System.out.println("The received frame is : "+(s%2));
                     System.out.println("Data Received :"+frame[s]);
                     System.out.println("Acknowledge "+((s+1)%2)+" sent");
                     try{
                TimeUnit.SECONDS.sleep(1);}
                catch(Exception e){}
                     System.out.println("\nAcknowledge "+((s+1)%2)+" received");
                     System.out.println();
                     break;
           
            case 2 : 
                try{
                TimeUnit.SECONDS.sleep(4);}
                catch(Exception e){}
                System.out.println("Timer expired, Data not recieved.");
                break;
            case 3 :
                System.out.println("The received frame is : "+(s%2));
                     System.out.println("Data Received :"+frame[s]);
                     System.out.println("Acknowledge "+((s+1)%2)+" sent");
                     try{
                TimeUnit.SECONDS.sleep(6);}
                catch(Exception e){}
                     System.out.println("\nAcknowledge delayed");
                     System.out.println();
                     break;
            case 4 :
                 System.out.println("The received frame is : "+(s%2));
                     System.out.println("Data Received :"+frame[(s+1)%3]);
                     try{
                TimeUnit.SECONDS.sleep(6);}
                catch(Exception e){}
                     System.out.println("Data with Error");
                     System.out.println();
                     break;

            default :System.out.println("Wrong Input");
        }
    }
}