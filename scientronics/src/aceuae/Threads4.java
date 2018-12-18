package aceuae;

import org.jsoup.nodes.Document;

import Main.site3panel;

public class Threads4 implements Runnable{
int first;
int end;

	public Threads4(int start, int end) {
 
	this.first = start;
	this.end = end;
}

	@Override
	public void run() {
		System.out.println(first+"     "+end);
		for(int i=first;i<end;i++)
		{
			productsurls.get(datastorage.fpurl.get(i).cat, 
					datastorage.fpurl.get(i).subcat, 
					datastorage.fpurl.get(i).subsubcat,
					datastorage.fpurl.get(i).tag1, 
					datastorage.fpurl.get(i).tag2, 
					datastorage.fpurl.get(i).producturl, 
				i);
			System.out.println(datastorage.fpurl.get(i).producturl);
		site3panel.pbar2.setValue(site3panel.pbar2.getValue()+1);
		}
	makeThreads4.com();	
	}

}
