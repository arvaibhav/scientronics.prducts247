package aceuae;

import org.jsoup.nodes.Document;

import Main.site3panel;

public class Threads3 implements Runnable{
int first;
int end;

	public Threads3(int start, int end) {
 
	this.first = start;
	this.end = end;
}

	@Override
	public void run() {
		System.out.println(first+"     "+end);
		for(int i=first;i<end;i++)
		{String cat=datastorage.fpurl2.get(i).cat;
		String subcat=datastorage.fpurl2.get(i).subcat;
		String subsubcat=datastorage.fpurl2.get(i).subsubcat;
		String url=datastorage.fpurl2.get(i).producturl;
		Document doc=datastorage.fpurl2.get(i).doc;
		int key=datastorage.fpurl2.get(i).key;
		//System.out.println(i);
		More.geturls2(cat, subcat, subsubcat, url, doc, key);
//		
		site3panel.pbar1.setValue(site3panel.pbar1.getValue()+1);
		}
	makeThreads3.com();	
	}

}
