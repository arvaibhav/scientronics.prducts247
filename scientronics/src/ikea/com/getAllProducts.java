package ikea.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class getAllProducts {
String name;
String price;
String url;
String cat;
String subcat;
boolean isoption;
 
public getAllProducts(String name, String price, String url, String cat, String subcat, boolean isoption) {
 
	this.name = name;
	this.price = price;
	this.url = url;
	this.cat = cat;
	this.subcat = subcat;
	this.isoption = isoption;
}
public static ArrayList<getAllProducts>allproducts=new ArrayList<>(30000);
	public static void main(String[] args) throws Exception {
		getCategoryandsubcategory.get(true);
		ArrayList<getCategoryandsubcategory>cats=getCategoryandsubcategory.cats;
		for(int i=0;i<cats.size();i++)
		{System.out.println(i);for (int j = 0; j <2; j++)
			try {
			get(cats.get(i).caturl,cats.get(i).cat,cats.get(i).subcat);
		break;} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("--------------------\n"+allproducts.size());
		ArrayList<getAllProducts>all2=new ArrayList<>(20000);
		HashSet<String>hash=new HashSet<>(20000);
		int count=1;
		for (int j = 0; j < allproducts.size(); j++) {
			int size=hash.size();
			hash.add(allproducts.get(j).url);
			if(hash.size()!=size)
			{
				all2.add(allproducts.get(j));
			}
		}System.out.println("-------------------\n"+all2.size());
		System.err.println(count);
		}
							  
	 public static void get(String url,String cat,String subcat) throws IOException {
		  String name="";
		  String price="";
		  String lurl="";
		  boolean more=false;
		  			Document doc=Jsoup.connect(url).get();
		  			for(Element s:doc.select(".productDetails"))
		  			{	try {
		  					price=s.select(".regularPrice").first().text().toLowerCase().replaceAll("dhs","").replaceAll("unit price","").trim();
							name=(s.select(".productTitle").text());
							lurl=s.select("a[href]").first().absUrl("href");
							if(s.toString().contains("Available in more options"))more=true; 
							if(!name.isEmpty())
							allproducts.add(new getAllProducts(name, price, lurl, cat, subcat, more)); 
		  					} catch (Exception e) {}
		   			
		  			}
	                              }

}
