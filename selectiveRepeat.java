import java.util.*;
class repeat
{

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the total number of frames:");
		int total=sc.nextInt();
		System.out.println("enter the window size:");
		int wsize=sc.nextInt();
		int start=0;
		int nak=0;
		int notsent[]=new int[total];
		int sent[]=new int[total];
		for(int j=0;j<total;j++)
		{
			sent[j]=notsent[j]=999;
			
		}
		int i,ans=0;
		do{
			for(i=start;i<start+wsize;i++)
			{
				if(i<total){
				System.out.println("frames that will be sent are:");
				for(int m=start;m<(start+wsize);m++)
				{
					if(m<total)
					if(notsent[m]!=999||sent[m]==999)
					System.out.print(m);
				
				}

				if(notsent[i]!=999){
				System.out.println("\nSending frame "+i);
				System.out.println("Is the frame "+i+" received correctly\n1.yes\n2.no");
				ans=sc.nextInt();
				if(ans==1)
				notsent[i]=999;
				nak=0;
				}
				else if(sent[i]==999){
				
				
				System.out.println("\nsending frame "+i);
				System.out.println("Is the frame "+i+" received correctly\n1.yes\n2.no");
				ans=sc.nextInt();
				}
				
				if(ans==2)
				{
					System.out.println("sending NAK for frame "+i);			
					notsent[i]=i;
					nak=1;
				}
				else{sent[i]=i;}
				}
			}
			
			if(nak==1){
			for(int k=0;k<total;k++)
			{
				if(notsent[k]!=999){
					start=notsent[k];
					break;
				}
			}}
			else{
			start+=wsize;}
		}while(start<total);
		System.out.println("Ho gaya send sab ab nikal");		
	}
}