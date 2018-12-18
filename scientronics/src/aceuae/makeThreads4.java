package aceuae;

import java.io.IOException;
import java.util.ArrayList;

import Main.site3panel;

public class makeThreads4 {
static	int ch=0;
static ArrayList<Thread>threads=new ArrayList<>(30);	
 static void com()
{ 
	if(ch--==1) {makeThreads5.start();
	 }
 
}
	public static void start(  ) {
	site3panel.status.setText("getting products url ");
		ch=0;int power=16;int length=datastorage.fpurl.size();
		site3panel.pbar2.setMaximum(length+100);
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
				threads.add(new Thread(new Threads4(temp, (temp+chk))));temp=temp+chk;len=len-chk;
 					
				
			}
			else {threads.add(new Thread(new Threads4(temp, length)));
				break;
			}
		}
	 for (int i = 0; i < threads.size(); i++) {threads.get(i).start();;
	
	}
		
	}

}
