package ikea.com;

import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import Main.site2panel;

public class Threads implements Runnable{
int first;
int end;

	public Threads(int start, int end) {

	this.first = start;
	this.end = end;
}

	@Override
	public void run() {
		
		for(int i=first;i<end;i++)
		{	for(int j=0;j<5;j++)
			try {
				
				String url=getCategoryandsubcategory.cats.get(i).caturl;
				String cat=getCategoryandsubcategory.cats.get(i).cat;
				String subcat=getCategoryandsubcategory.cats.get(i).subcat;
				getAllProducts.get(url, cat, subcat);
				site2panel.pbar2.setValue(site2panel.pbar2.getValue()+1);
			break;}
		catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "please check the connection [stage 1]");
		}
		catch (Exception e) {
				// TODO: handle exception
			}
		}
		makeThreads.iscomp();
	}

}
