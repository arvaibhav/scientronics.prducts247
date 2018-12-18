package aceuae;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Main.site3panel;
import Main.site3panel;
public class makeThreads3 {
static	int ch=0;
static ArrayList<Thread>threads=new ArrayList<>(30);	
public static void main(String[] args) {
 
}static void com()
{System.err.println("work3 :"+ch);
	if(ch--==1)
{
  try {
	  site3panel.status.setText("Saving data");
		
	Csv.save();System.out.println("SAVAED");
	makeThreads4.start();
	site3panel.status.setText("Saving data");
	site3panel.pbar1.setValue(site3panel.pbar1.getMaximum());
  } catch (IOException e) {
JOptionPane.showMessageDialog(null,"please close if open!!");
}
}
}
	public static void start(  ) {
		site3panel.status.setText("getting tag's 2");
		ch=0;int power=16;int length=datastorage.fpurl2.size();
		site3panel.pbar1.setMaximum(site3panel.pbar1.getValue()+datastorage.fpurl2.size()+2);
		if(length==0) {ch=1;com();}
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
				threads.add(new Thread(new Threads3(temp, (temp+chk))));temp=temp+chk;len=len-chk;
 					
				
			}
			else {threads.add(new Thread(new Threads3(temp, length)));
				break;
			}
		}
	 for (int i = 0; i < threads.size(); i++) {threads.get(i).start();;
	
	}
		
	}

}
