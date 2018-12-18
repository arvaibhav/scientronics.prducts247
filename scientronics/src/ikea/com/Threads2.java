package ikea.com;

import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import Main.site2panel;

public class Threads2 implements Runnable{
int first;
int end;

	public Threads2(int start, int end) {

	this.first = start;
	this.end = end;
}

	@Override
	public void run() {
		System.out.println(first+"     "+end);
		for(int i=first;i<end;i++)
		{	for(int h=0;h<8;h++)
			try { 
				String url=getAllProducts.allproducts.get(i).url;
				String cat=getAllProducts.allproducts.get(i).cat;
				String subcat=getAllProducts.allproducts.get(i).subcat;
				boolean isoption=getAllProducts.allproducts.get(i).isoption;
				Productinfo.start(url, cat, subcat, isoption, i);
				site2panel.pbar3.setValue(site2panel.pbar3.getValue()+1);
				
				break;}
		catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "please check the connection [stage 2]");
		}
		catch (Exception e) {
					if(h>2)System.out.println(h);
			} 
		}
		makeThreads2.iscomp();
	}

}
