package aceuae;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import Main.site3panel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class Main2 {
String cat;
String subcat;
String subsubcat;

	public Main2(String cat, String subcat, String subsubcat) {
	super();
	this.cat = cat;
	this.subcat = subcat;
	this.subsubcat = subsubcat;
}
	
 
 
public static void Start() {
	get1();
//	System.out.println(fd.cats.size());
//	System.out.println(fd.scats.size());
//	System.out.println(fd.sscats.size());
 int count=0;
 
 for(fd c:fd.cats)
{	 count++;
	for(fd sc:fd.scats)
	{
		if(sc.code.contains(c.code))
		{ for(fd ssc:fd.sscats)
		{	
			if(ssc.code.contains(sc.code))
			{
				 
				datastorage.cats.add(new Subcat(c.text, sc.text,ssc.text, ssc.url));
					
			}
			
		}} 
	}	
}site3panel.pbar1.setMaximum( datastorage.cats.size()+50);
System.err.println(datastorage.cats.size());
site3panel.status.setText("getting tag's 1");

makeThreads2.start();
}
	public static void get1() {
		String url="https://www.aceuae.com/en/ace-uae";
	for(int qq=0;qq<10;qq++)
	try {
		Document doc=Jsoup.connect(url).get();
		for(Element s:doc.getAllElements())
		{	boolean passi=false;
			if(s.id().contains("departmentButton"))
				if(!s.text().toLowerCase().equals("christmas")&&!s.text().toLowerCase().equals("bulk enquiries")&&!s.text().toUpperCase().contains("CLEARANCE"))
		{passi=true;
		 
			String code=(s.id().substring(s.id().indexOf("_")+1));// try {Thread.sleep(250);} catch (Exception e) {}
			String g=s.absUrl("href");
			if(!g.contains("#"))
			fd.cats.add(new fd(s.text(), code,g));
		}
			
			if(s.id().contains("categoryLink")&&!s.id().contains("subcategoryLink"))
		{passi=true;
	 
		String code=(s.id().substring(s.id().indexOf("_")+1)); //try {Thread.sleep(250);} catch (Exception e) {}
		fd.scats.add(new fd(s.text(), code, ""));
		}
			if(s.id().contains("subcategoryLink"))
			{passi=true;
			 
			String code=(s.id().substring(s.id().indexOf("_")+1)); //try {Thread.sleep(250);} catch (Exception e) {}
			String g=s.absUrl("href");
			if(!g.contains("#"))
			
			fd.sscats.add(new fd(s.text(), code, g));
			}
			 
		}
		
		
	break;} catch (Exception e) {
		System.out.println(e);
	}

	}

}
