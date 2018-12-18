package ikea.com;

import java.util.ArrayList;
import java.util.HashSet;

import Main.site2panel;

public class makeThreads {
static ArrayList<Thread>threads=new ArrayList<>(30);	
static int chkstatus=0;
public static void main(String[] args) {
	start(30,421);
} 
public static void iscomp()
{
	if(--chkstatus==0)
	{ArrayList<getAllProducts>all2=new ArrayList<>(20000);
	HashSet<String>hash=new HashSet<>(20000);
	int count=1;
	for (int j = 0; j < getAllProducts.allproducts.size(); j++) {
		int size=hash.size();
		hash.add(getAllProducts.allproducts.get(j).url);
		if(hash.size()!=size)
		{
			all2.add(getAllProducts.allproducts.get(j));
		}
	}
	site2panel.pbar2.setValue(site2panel.pbar2.getMaximum());
	getAllProducts.allproducts=all2;
	site2panel.pbar3.setMaximum(all2.size());
	makeThreads2.start(16, all2.size());
	}
}
	public static void start(int power,int length) {
		threads.clear();
		int len=length;
		// TODO Auto-generated constructor stub
		int chk=(int)Math.ceil(len/(power*1.0));
		int threadsno=power;
		if(power>len)threadsno=len;
		int temp=0;
		for(int i=0;i<threadsno;i++)
		{
			if(len>chk) {
				threads.add(new Thread(new Threads(temp, (temp+chk))));temp=temp+chk;len=len-chk;
					
				
			}
			else {threads.add(new Thread(new Threads(temp, length)));
				break;
			}
		}chkstatus=threads.size();
	 for (int i = 0; i < threads.size(); i++) {threads.get(i).start();;
		
	}
		
	}

}
