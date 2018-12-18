package aceuae;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class productsurls {
	public	String cat;
	public	String scat;
	public	String sscat;
	public		String tag1;
	public	String tag2;
	public		String url;
	public	int page;
	public	int key;
	public	String brandname;
	public		String productname;
public	String price;
public	String orginalprice;
	public		boolean stock;
	public		String sku = "";
	

	public productsurls(String cat, String scat, String sscat, String tag1, String tag2, String url, int page, int key,
			String brandname, String productname, String price, boolean stock, String sku,String orginalprice) {
		super();  this. orginalprice= orginalprice;
		this.cat = cat;
		this.scat = scat;
		this.sku = sku;
		this.sscat = sscat;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.url = url;
		this.page = page;
		this.key = key;
		this.brandname = brandname.replaceAll("%27", "").replaceAll("%26", "");
		this.productname = productname;
		this.price = price;
		this.stock = stock;
	}

	public productsurls(String cat, String scat, String sscat, String tag1, String tag2, String url, int page,
			int key) {// page passing one
		super();
		this.cat = cat;
		this.scat = scat;
		this.sscat = sscat;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.url = url;
		this.page = page;
		this.key = key;
	}

	public static void main(String[] args) {

		String url = "https://www.aceuae.com/en/ace-uae/drill-sets";
		get("cat", "subcat", "subsubcat", "tag1", "tag2", url, 0);
		System.err.println(datastorage.purls.size()); 
		for(productsurls s:datastorage.purls)
		 {System.out.println(s.url);}
	}

	static void get(String cat, String scat, String sscat, String tag1, String tag2, String url, int key) {
		boolean not = true;
		for (int qq = 0; qq < 10; qq++)
			try {
				Document doc = Jsoup.connect(url)
						.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
						.maxBodySize(0).get();
				
				try {
					String otherpage;
					otherpage = (doc.select(".of_total").first().text().replaceAll("of", "").trim());
					int page = Integer.parseInt(otherpage);
					if (page > 1) {
						
						datastorage.purls2.add(new productsurls(cat, scat, sscat, tag1, tag2, url, page, key));
						 
					}
					} catch (Exception e) { }
					geturls(doc, cat, scat, sscat, tag1, tag2, url, 0, key);

				

				not = false;
				break;
			} catch (Exception e) {
				 
			}
		if (not) {
			System.out.println("not getting p urls at" + url);
		}

	}

	static void geturls(Document doc, String cat, String scat, String sscat, String tag1, String tag2, String url,
			int page, int key) {
		System.err.println(url);
		Element Z = doc.selectFirst(".grid_mode");
		for (Element s : Z.select(".product")) {
			String brandname = "";
			String productname = s.select(".product_name").text();
			String price = s.select(".price").text();
			boolean stock = true;
			try {
				String tt = (s.select(".brand_name_logo").select("a[href]").attr("href"));
				tt = tt.substring(tt.indexOf("?manufacturer=") + "?manufacturer=".length());
				tt = tt.substring(0, tt.indexOf("&store"));
				brandname = (tt);
			} catch (Exception e) {
			}
			try {
				String ss = s.select(".reqStockAlert").first().text();
				if (!ss.isEmpty())
					stock = false;
			} catch (Exception e) {
				// TODO: handle exception
			}
			String sku = s.select(".sku").text().toUpperCase().replaceAll("SKU:", "").trim();

			String urlz = s.select(".product_name").select("a[href]").first().absUrl("href");
			if(urlz.isEmpty())
				urlz = s.select(".product_name").select("a[href]").first().attr("href");
				if(urlz.isEmpty())
				urlz="https://www.aceuae.com/SearchDisplay?categoryId=&storeId=10259&catalogId=10051&searchTerm="+sku;
			System.out.println("urlz :"+urlz);
			String  orginalprice="";
			try {
				orginalprice=s.select(".old_price").first().text();	
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(orginalprice.isEmpty())orginalprice="0";
			datastorage.purls.add(new productsurls(cat, scat, sscat, tag1, tag2, urlz, page, key, brandname,
					productname, price, stock, sku,orginalprice));

		}

	}

}
