package aceuae;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class More {
	String cat ,subcat,  subsubcat,producturl;
	ArrayList<String>tags=new ArrayList<>(20);
	int key=0;
	String tag1="",tag2="";
	
public More(String cat, String subcat, String subsubcat,  String tag1, String tag2,String producturl) {
		super();
		this.cat = cat;
		this.subcat = subcat;
		this.subsubcat = subsubcat;
		this.producturl = producturl;
		this.tag1 = tag1;
		this.tag2 = tag2;
	}
public More(String cat, String subcat, String subsubcat, ArrayList<String> tags, String producturl,int key) {
		super();this.key=key;
		this.cat = cat;
		this.subcat = subcat;
		this.subsubcat = subsubcat;
		this.producturl = producturl;
		this.tags = tags;//System.out.println(cat+"                "+ subcat+"  "+subsubcat+tags);
	}
public More(String cat, String subcat, String subsubcat, ArrayList<String> tags, String producturl ) {
	super(); 
	
	this.cat = cat;
	this.subcat = subcat;
	this.subsubcat = subsubcat;
	this.producturl = producturl;
	this.tags = tags;
}

 Document doc;
public More(String cat, String subcat, String subsubcat, String producturl,   Document doc,int key) {
	super();
	this.cat = cat;
	this.subcat = subcat;
	this.subsubcat = subsubcat;
	this.producturl = producturl;
	this.key = key;
	this.doc = doc;
}
public static void main(String[] args) {
//	Main.get();
//	for (int i = 0; i < Main.cats.size(); i++) {
//		System.out.println(i+" :"+Main.cats.size());
//		subcat.get(Main.cats.get(i).cat, Main.cats.get(i).caturl);
//	}
//	for (int i = 0; i < subcat.subsubcats.size(); i++) {
//		System.out.println(i+" :"+subcat.subsubcats.size());
//	 get(subcat.subsubcats.get(i).cat, subcat.subsubcats.get(i).subcat,subcat.subsubcats.get(i).subsubcat,subcat.subsubcats.get(i).subcaturls);
//	 
//	}System.out.println("end");
	get("","" ,"","https://www.aceuae.com/en/ace-uae/Living-Room",1);
 
}
	public static boolean get(String cat,String subcat,String subsubcat,String url,int key) {
	for(int qq=0;qq<10;qq++)//product_image
	try {
		Document doc=Jsoup.connect(url) .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
			    .maxBodySize(0).get();
		 
		try {
			Element ch= (doc.select(".product_image").first());
			 
			if(ch==null||ch.toString().isEmpty())
				{ 
				datastorage.fpurl2.add(new More(cat, subcat, subsubcat, url, doc, key));
				return false;
				} else { geturls1(cat, subcat, subsubcat, url, doc,key);
				
				return true;
				}
				 
		} catch (Exception e) {datastorage.fpurl2.add(new More(cat, subcat, subsubcat, url, doc, key)); return false;}
	 } catch (Exception e) {
		 
	}
	
return true;
	}
	  static void geturls2(String cat, String subcat, String subsubcat, String url, Document doc,int key) {
		  System.out.println("GET 2:"+url);
		  boolean other=false;
		try {
			String pass=(doc.select(".flex-block2").first().toString());
			if(!(pass==null||pass.isEmpty()))
		for(Element s:doc.select(".flex-block2").select(".rel"))
		{String ch=(s.select("a").first().absUrl("href"));
	 
			if(!ch.isEmpty() )
			{ArrayList<String>oo=new ArrayList<>();oo.add(s.text());
		 
				geturls1(cat, subcat, subsubcat, ch,oo,key);
			
			}
		}else{other=true;}}catch (Exception e) {other=true;}
		if(other)
		{
			if(url.contains("/broil-king"))                                             //1.broil-king-grills
			{url="https://www.aceuae.com/en/ace-uae/broil-king-grills";
			ArrayList<String>tag=new ArrayList<>();tag.add("broil-king-grills");
			geturls1(cat, subcat, subsubcat, url, tag, key);
			}
			else if(url.contains("https://www.aceuae.com/en/ace-uae/kitchen-accessories-1"))//****kitchenass
			{
				for(Element s:doc.select(".pull-left"))
				{ 
					String subc=(s.text().replaceAll(" / View All","").trim());
					String urlss=(s.select("a").first().absUrl("href"));
					ArrayList<String>tag=new ArrayList<>();tag.add(subc);
					geturls1(cat, subcat, subsubcat, urlss, tag, key);
				}
			}else if(url.contains("https://www.aceuae.com/en/ace-uae/hand-tools-ace-handtools")||url.contains("https://www.aceuae.com/en/ace-uae/utensils"))////*handtool
			{
				for(Element s:doc.select(".col-sm-3"))
				{ 
					String subc=s.text();
					String urlss=(s.select("a").first().absUrl("href"));
//					 System.out.println(subc);
					ArrayList<String>tag=new ArrayList<>();tag.add(subc);
					geturls1(cat, subcat, subsubcat, urlss, tag, key);
				}
			}else if(url.contains("https://www.aceuae.com/en/ace-uae/power-tools-1"))//****powertools
			{//System.out.println("po");
				for(Element s:doc.select(".cols-v10").select(".list-details-10"))
				{ String tag1=s.select(".collapse-heading").text();
					for(Element ss:s.select("ul").select("li"))
					{
						String subc=(ss.text() );
						String urlss=(ss.select("a").first().absUrl("href"));
//						System.out.println(subc);
//						System.out.println(urlss);
						ArrayList<String>tag=new ArrayList<>();tag.add(tag1);tag.add(subc);
//						System.out.println(tag);
						geturls1(cat, subcat, subsubcat, urlss, tag, key);
					}
				}
			} //
			else {                                                                     //try other 
				boolean other2=false;
				try {//System.out.println("other");
					String pass=(doc.select(".flex-block").first().toString());
					if(!(pass==null||pass.isEmpty()))
				for(Element s:doc.select(".flex-block") )
				{String ch=(s.select("a").first().absUrl("href"));
			 
					if(!ch.isEmpty() )
					{
						String check=s.text();
						try {
							check=check.substring(0,check.indexOf("Starting")).trim();
						} catch (Exception e) {}
						check=check.replaceAll("Little Things That Make a House a Home SHOP THE RANGE","");
						ArrayList<String>oo=new ArrayList<>();oo.add(check);
					 
						try { geturls1(cat, subcat, subsubcat, ch,oo,key); } catch (Exception e) { }
					
					}
				}else{other2=true;}}catch (Exception e) {other2=true;}
			 if(other)                                                                  //other case 3
			 {
				 System.out.println("superother*** "+url+"     "+cat+ "     "+subcat);
			 }
			}
		}
	}
	public static void geturls1(String cat,String subcat,String subsubcat,String url,Document doc,int key)//cat to prourls
	{ System.out.println("GET 1 DOC:"+url);
		try {
			String pass=(doc.select(".categoryNavWidget").first().toString());
			if(pass==null||pass.isEmpty())
				datastorage.fpurl.add(new More(cat, subcat, subsubcat, new ArrayList<>(), url,key));
			else
			{
				for(Element s:doc.select(".categoryNavWidget").select("ul").select("li"))
				{
					try {
						String tag=(s.text().replaceAll("[0-9()]","").trim());
						if(!tag.toLowerCase().contains("view all categories"))
						{String url2=(s.select("a[href]").first().absUrl("href"));
						ArrayList<String>te=new ArrayList<>(8);te.add(tag);
						datastorage.fpurl.add(new More(cat, subcat, subsubcat, te, url2,key));
						}
					} catch (Exception e)  {}
				}
			}
		} catch (Exception e) {
			datastorage.fpurl.add(new More(cat, subcat, subsubcat, new ArrayList<>(), url,key));
		}
	}
	
	public static void geturls1(String cat,String subcat,String subsubcat,String url,ArrayList<String>tag,int key)//cat to prourls
	{ //err.println(url);
	System.out.println("GET 1:"+url);
		for(int za=0;za<10;za++)
			try {
				Document doc=Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
					    .maxBodySize(0).get();
				try {
					String pass=(doc.select(".categoryNavWidget").first().toString());
					if(pass==null||pass.isEmpty())
						datastorage.fpurl.add(new More(cat, subcat, subsubcat, tag, url,key));
					else
					{
						for(Element s:doc.select(".categoryNavWidget").select("ul").select("li"))
						{
							try {
								String tags=(s.text().replaceAll("[0-9()]","").trim());
								if(!tags.toLowerCase().contains("view all categories"))
								{String url2=(s.select("a[href]").first().absUrl("href"));
								 ArrayList<String>tag2=new ArrayList<>(tag);
								 tag2.add(tags);
								 //err.println("U"+tags);
								datastorage.fpurl.add(new More(cat, subcat, subsubcat, tag2, url2,key));
								}
							} catch (Exception e)  {}
						}
					}
				} catch (Exception e) {
					datastorage.fpurl.add(new More(cat, subcat, subsubcat, tag, url,key));
				}
			break;} catch (Exception e) {
				// TODO: handle exception
			}
	}
	 
}
