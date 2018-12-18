package aceuae;

import org.jsoup.nodes.Document;
import org.openqa.selenium.firefox.FirefoxDriver;

import Main.site3panel;

public class Threads5 implements Runnable{
int first;static boolean as=true;
int end;
FirefoxDriver driver;
	public Threads5(int start, int end,FirefoxDriver driver) {
		this.driver=driver;
	this.first = start;
	this.end = end;
}

	@Override
	public void run() {
		System.out.println(first+"     "+end);
		for(int i=first;i<end;i++)
		{productsurls p=datastorage.purls2.get(i);
		
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				browser.get(driver, p.url, p.page, p.key, p.cat, p.scat, p.sscat, p.tag1, p.tag2);
			}
		});t.start();
		try {
			t.join(50*1000);
		} catch (Exception e) {
			 
		}
		driver.get("about:blank");
		if(as)
		{site3panel.status.setText("[firefox] getting till n page ("+makeThreads5.cn+++" / "+datastorage.purls2.size()+" )...");		 
		as=false;}
		else {site3panel.status.setText("[firefox] getting till n page ("+makeThreads5.cn+++" / "+datastorage.purls2.size()+" ).");		 
		as=true;}
		site3panel.pbar2.setValue(site3panel.pbar2.getValue()+1);
		}
	makeThreads5.com();	
	}

}
