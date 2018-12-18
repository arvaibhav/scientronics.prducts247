package aceuae;

import java.io.IOException;
import java.util.ArrayList;

import Main.site3panel;

public class makeThreads2 {
static	int ch=0;
static ArrayList<Thread>threads=new ArrayList<>(30);	
public static void main(String[] args) {
 
}static void com()
{ 
	if(ch--==1)
{site3panel.status.setText("getting tag's 2");
   makeThreads3.start();
}
}
	public static void start(  ) {
		
		ch=0;int power=16;int length=datastorage.cats.size();
		threads.clear();
		int len=length;
		// TODO Auto-generated constructor stub
		int chk=(int)Math.ceil(len/(power*1.0));
		int threadsno=power;
		if(power>len)threadsno=len;
		int temp=0;
		for(int i=0;i<threadsno;i++)
		{	ch=i+1;
			if(len>chk) {
				threads.add(new Thread(new Threads2(temp, (temp+chk))));temp=temp+chk;len=len-chk;
 					
				
			}
			else {threads.add(new Thread(new Threads2(temp, length)));
				break;
			}
		}
	 for (int i = 0; i < threads.size(); i++) {threads.get(i).start();;
	
	}
		
	}

}
