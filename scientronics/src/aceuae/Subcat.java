package aceuae;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class Subcat {
String cat;
String subcat;
String subsubcat;
String subcaturls;

	public Subcat(String cat, String subcat, String subsubcat, String subcaturls) {
	super();
	this.cat = cat;
	this.subcat = subcat;
	this.subsubcat = subsubcat;
	this.subcaturls = subcaturls;
}

//public static void main(String[] args) {
//	Main.get();
////	for(Main s:Main.cats)
////	{
////		System.out.println(s.cat+"    "+s.caturl);
////	}
//	makeThreads.start();
//}
//	public static void get(String cat,String caturls ) {
////		String cat="DIY & Tools";
////		String caturls="https://www.aceuae.com/en/ace-uae/diy-tools-equipment";
////		System.out.println( caturls+"       :::"+cat);
//	for(int qq=0;qq<10;qq++)
//	try {
//		Document doc=Jsoup.connect(caturls).get();
//		 String type=null;
//		try {
//			type = doc.select("#dropdown-mob").first().toString();
//		} catch (Exception e) {}
//		 
//		 if(type!=null)
//		 {
//		for(Element s:doc.select("#dropdown-mob").select("li"))
//		{
//			String subcat=(s.select(".title").text());
//			
//			if(!subcat.isEmpty())
//			{// System.out.println(subcat);
//			for(Element ss:s.select(".menu-group").select("li"))
//			{	String subsubcat=(ss.text());
//				if(!subsubcat.toLowerCase().contains("all")){
//				String subsubcaturl=(ss.select("a[href]").first().absUrl("href"));
//				subsubcats.add(new subcat(cat, subcat, subsubcat, subsubcaturl));
//				}
//				 
//			} 
//			 //1000
//			}
//		}
//		 }else {String type2=null;
//			 try {type2=doc.select(".list-details-10").first().toString();} catch (Exception e) {}
//			 if(type2!=null)
//			 {
//			   
//				 
//			 }else {System.out.println("FAIL"+  caturls);}
//		 }
//		
//		
//	break;} catch (Exception e) {
//		// TODO: handle exception
//	}
//
//	}//100035358

}
