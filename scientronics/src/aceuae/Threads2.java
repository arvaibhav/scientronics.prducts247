package aceuae;

import Main.site3panel;

public class Threads2 implements Runnable{
int first;
int end;
static int sa=1;
	public Threads2(int start, int end) {
 
	this.first = start;
	this.end = end;
}

	@Override
	public void run() {
		System.out.println(first+"     "+end);
		
		for(int i=first;i<end;i++)
		{
			String cat=datastorage.cats.get(i).cat;
		String subcats=datastorage.cats.get(i).subcat;
		String subsubcat=datastorage.cats.get(i).subsubcat;
		String url=datastorage.cats.get(i).subcaturls;
		//System.out.println(i);
		More.get(cat, subcats, subsubcat, url,i);
 		site3panel.pbar1.setValue(sa++);
 		System.err.println(sa);
//		System.out.println();
		}
	makeThreads2.com();	
	}

}
