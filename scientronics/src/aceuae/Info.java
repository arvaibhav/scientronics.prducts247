package aceuae;

import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import Main.site3panel;

public class Info {
	String cat= "";
	String scat= "";
	String sscat= "";
	String tag1= "";
	String tag2= "";

	String url= "";
	int key= 0;
	String brandname= "";
	String productname= "";
	String price= "";
	String orginalprice= "";
	boolean stock= false;
	String sku = "";
	
	String imageurl= "";
	String des= "";
	String deswithtags= "";
	String keypoints= "";
	String specs= "";
	String weight= "";
 
	public Info(String cat, String scat, String sscat, String tag1, String tag2, String url, int key, String brandname,
			String productname, String price, String orginalprice, boolean stock, String sku, String imageurl,
			String des, String deswithtags, String keypoints, String specs, String weight) {
		super();
		this.cat = cat;
		this.scat = scat;
		this.sscat = sscat;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.url = url;
		this.key = key;
		this.brandname = brandname;
		this.productname = productname;
		this.price = price;
		this.orginalprice = orginalprice;
		this.stock = stock;
		this.sku = sku;
		this.imageurl = imageurl;
		this.des = des;
		this.deswithtags = deswithtags;
		this.keypoints = keypoints;
		this.specs = specs;
		this.weight = weight;
		site3panel.model.addRow(new Object[] {site3panel.count++//,url
		,cat,scat,sscat,tag1,tag2,brandname,productname,price,orginalprice,sku,stock,
		des,keypoints,specs,weight,	imageurl,url,deswithtags
		});
//		1	"	Sub-category	.trim()"	"	Sub-sub-category	.trim()"	"	tag1	.trim()"	"	tag2	.trim()"	"	Brand name	.trim()"	"	Product name	.trim()"	"	Price	.trim()"	"	Old price	.trim()"	"	SKU	.trim()"	"	stock	.trim()"	"	Description	.trim()"	"	Keypoints	.trim()"	"	Specification	.trim()"	"	Weight	.trim()"	"	imageurl	.trim()"	"	URL	.trim()"	"	Description (Tag)	.trim()"	
//		0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18
	
	}

	public static void main(String[] args) {
		String url = "https://www.aceuae.com/en/ace-uae/festive-collection-dog-decoration-948524";
		
get("", "", "", "", "", url, 1, 0, "", "", "", true, "", "");
	}

public	static void get(String cat, String scat, String sscat, String tag1, String tag2, String url, int page, int key,
			String brandname, String productname, String price, boolean stock, String sku,String orginalprice) {
		boolean not = true;
		for (int qq = 0; qq < 10; qq++)
			try {Document doc=Jsoup.connect(url).get();
//------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------				
			String imageurl="";
			try {Element im=doc.selectFirst("#carousel").selectFirst(".slides") ;	
            boolean one=true;
					for (Element s : im.select("li")) {
						String imu = (s.select("a[href]").attr("href").replaceAll("s.jpg", "z.jpg"));
						if (one) {
							one = false;
							imageurl += imu;
						} else
							imageurl += " , " + imu;
					}
				 
				} catch (Exception e) {
				}
//-------------------------------------------------
			String des= "";	 
			try {
				
				Element ddd=doc.selectFirst("#pdtlz-tbz").select(".content-block").select(".boxy").first();
				
					try {
						String[] descs = (ddd.toString().split("\n"));
						String dd = "";
						for (int i = 0; i < descs.length; i++) {
							if (!descs[i].contains(
									"Buy online the very best in DIY, outdoor and gardening to homeware from Al-Futtaim ACE today. Discover a large range of products for sale on our website, and have them delivered straight to your doorstep.")) {
								String DD = remtag(descs[i]);
								if (!DD.contains("><"))
									dd += DD + "\n";
							}

						}
						des = (dd);
					} catch (Exception e) {
					}

				} catch (Exception e) {
				}
//---------------------------------------------------			
			String keypoints="";
			try {
				keypoints=remtag(doc.select(".key-feature").first().toString());
				 
			} catch (Exception e) {}
//---------------------------------------------------			
			String specs="";	String weight="";
			try {
			Element ddd=doc.selectFirst("#pdtlz-tbz").select("table").first();
			specs=remtag(ddd.toString());
			for(Element s:ddd.select("tr"))
			{
				try {
					String ch=(s.select("td").get(0).text().toLowerCase());
					if(ch.contains("weight"))
					{
						weight=(s.select("td").get(1).text().toLowerCase());break;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
			} catch (Exception e) {}
//--------------------------------------------------			
		datastorage.datas.add(new Info(cat, scat, sscat, tag1, tag2, url, key, brandname, productname, price, orginalprice, stock, sku, imageurl, des, gettext(des), keypoints, specs, weight));
//--------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------
				not = false;
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		if (not) {

		}

	}
static  String remtag(String dd)
{String c= dd.replaceAll("class=\"[a-zA-Z0-9:;\\.\\s\\(\\)\\-\\,_]*\"", "").replaceAll(" >", ">");
c=c.replaceAll("id=\"[a-zA-Z0-9:;\\.\\s\\(\\)\\-\\,_]*\"", "").replaceAll(" >", ">");
c=c.replaceAll("href=\"[a-zA-Z0-9:;\\.\\s\\(\\)\\-\\,_]*\"", "").replaceAll(" >", ">");
 
return c;
}
static String gettext(String dd)
{String[] t=dd.split("\n");
boolean one=true;
String a="";
for (int i = 0; i < t.length; i++) {
	if(one)
	{String x=t[i].replaceAll("\\<.*?>", "").trim();
		if(!x.isEmpty())a+=x;
		one=false;
	}else {String x=t[i].replaceAll("\\<.*?>", "").trim();
	if(!x.isEmpty())
		a+="\n"+x;	
	}
}
	return a.trim();
}

}
