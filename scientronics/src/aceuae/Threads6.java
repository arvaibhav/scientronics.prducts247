package aceuae;

import org.jsoup.nodes.Document;

import Main.site3panel;

public class Threads6 implements Runnable{
int first;
int end;

	public Threads6(int start, int end) {
 
	this.first = start;
	this.end = end;
}

	@Override
	public void run() {
		System.out.println(first+"     "+end);
		for(int i=first;i<end;i++)
		{
			 productsurls p=datastorage.purls.get(i);
			Info.get(p.cat, p.scat,p. sscat,p. tag1,p. tag2, 
					p.url, p.page, 
					i, p.brandname,p. productname, p.price, p.stock, p.sku, p.orginalprice);
		site3panel.pbar3.setValue(site3panel.pbar3.getValue()+1);
		}
	makeThreads6.com();	
	}

}
