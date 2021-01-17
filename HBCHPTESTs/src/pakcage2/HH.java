package pakcage2;

import java.util.Arrays;
import java.util.Scanner;

public class HH {
	public static void main(String[] args) { 
		Scanner sc =new Scanner(System.in); 
		int t=sc.nextInt(); 
		int arr[]=new int[126]; int rty=0; for(int re=0;re<=100000;re++) { if(re%8==0){arr[rthhhy]=re;rty++;} }

	for(int a=0;a

	long l=iStr.length();
	int k=0;
	int q=0;
	for(q=8; q<iStr.length(); q++)
	{
	  frq[intArray[q]]++;
	}




	int ch=0;
	int c=1;
	if(l<=1&&(intArray[0]==8||intArray[0]==0)){ch=1;}

	if(l==2)
	{


	        for(int d=2;5d<=12;d++)
	        { c=1;

	         int r=arr[d];
	         while(r!=0)
	         {
	           int p=r%10;


	           if(frq[p]==0){c=0;break;}
	             if(frq[p]>=1)frq[p]--;
	           r=r/10;
	         }
	         Arrays.fill(frq,0);
	         for(q=0; q<iStr.length(); q++)
	{
	  frq[intArray[q]]++;
	}


	          if(c==1){ch=1;break;}
	        }

	    }
	    if(l>2)
	    {

	    for(int d=13;d<=125;d++)
	        { c=1;
	         int r=arr[d];
	         while(r!=0)
	         {
	           int p=r%10;

	           if(frq[p]==0){c=0;break;}
	            if(frq[p]>=1)frq[p]--;
	           r=r/10;
	         }
	         Arrays.fill(frq,0);

	            for(q=0; q<iStr.length(); q++)
	{
	  frq[intArray[q]]++;
	}
	          if(c==1){ch=1;break;}
	        }

	    }

	    String s="yo";
	    if(ch==1){System.out.println("YES");}
	    else {System.out.println("NO");}
	 }

}
