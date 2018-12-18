package aceuae;

import java.io.IOException;
import java.util.ArrayList;

import Main.site3panel;

public class makeThreads6 {
static	int ch=0;
static ArrayList<Thread>threads=new ArrayList<>(30);	
 static void com()
{ 
	if(ch--==1) { 
		
		try {
			Excel.toexcel(datastorage.datas, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		site3panel.complete();
	}
 
}
	public static void start(  ) {
	
		ch=0;int power=16;int length=datastorage.purls.size();
		site3panel.pbar3.setMaximum(site3panel.pbar3.getValue()+length);
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
				threads.add(new Thread(new Threads6(temp, (temp+chk))));temp=temp+chk;len=len-chk;
 					
				
			}
			else {threads.add(new Thread(new Threads6(temp, length)));
				break;
			}
		}
	 for (int i = 0; i < threads.size(); i++) {threads.get(i).start();;
	
	}
		
	}

}
