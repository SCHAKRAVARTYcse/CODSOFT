package codsoft;
import java.util.Scanner;
public class TASK2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				Scanner sc=new Scanner(System.in);
		        int sub,s=0,i,n;
		        double avg=0.0;
		        System.out.print("Enter The Number Of Subjects:");
		        sub=sc.nextInt();
		        n=sub;
		        int m[]=new int[n];
		        
		        for(i=0;i<n;i++)
		        {
		        	System.out.print("Enter The Marks Of Subject " + (i+1) + " : ");
		        	m[i]=sc.nextInt();
		        }
		        
		        for(i=0;i<n;i++)
		        {
		        	s=s+m[i];
		        }
		        System.out.println("Total Marks Obtained:"+s);
		        avg=(double)s/n;
		        System.out.println("Average %:"+avg+"%");
		        if (avg >= 90) 
		        {
		        	System.out.print("Grade:A");
		        } 
		        else if (avg >= 80) 
		        {
		        	System.out.print("Grade:B");
		        } 
		        else if (avg >= 70) 
		        {
		        	System.out.print("Grade:C");
		        } 
		        else if (avg >= 60) 
		        {
		        	System.out.print("Grade:D");
		        } 
		        else 
		        {
		        	System.out.print("Grade:F");
		        }
	}

}
