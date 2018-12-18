package ikea.com;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ex {//S89186844

	public static void main(String[] args) throws IOException {
//		Document doc=Jsoup.connect("https://www.ikea.com/ae/en/catalog/products/90271596/").get();
		Document doc=Jsoup.connect("https://www.ikea.com/ae/en/catalog/products/S89186844/").get();
		String hh=doc.select("script").select("[type=text/javascript]").toString() ;
		hh=(hh.substring(hh.indexOf("\"pkgInfoArr\":")+"\"pkgInfoArr\":".length()));
		hh=hh.substring(0, hh.indexOf("}]}]"));
		 
		 String []hhh=hh.split("\"articleNumber\"");
		 for(String h:hhh) {String th=(h.replaceAll("\":\"",":").replaceAll(":\"", "").replaceAll("\"", ""));
		 th=th.replaceAll("[{]","");
		 if(th.contains("}"))
		 th=th.substring(0, th.indexOf("}"));
		 if(th.length()>10)
		 System.out.println(th+"]");
		 }
		 
 
//	System.out.println("avvvc.".replaceAll("vvvc.",""));
	}
}
