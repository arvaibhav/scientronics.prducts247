package ikea.com;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class getCategoryandsubcategory {
	String caturl;
	String cat;
	String subcat;
public getCategoryandsubcategory(String caturl, String cat, String subcat) {
	 
		this.caturl = caturl;
		this.cat = cat;
		this.subcat = subcat;
	}

 
public static ArrayList<getCategoryandsubcategory>cats=new ArrayList<>(2500);
public	static void get(boolean isdepartment) throws Exception {
		 
		Document Doc;
		if (isdepartment)
			Doc = Jsoup.connect("https://www.ikea.com/ae/en/catalog/allproducts/department/").get();
		else
			Doc = Jsoup.connect("https://www.ikea.com/ae/en/catalog/allproducts/").get();
		Element dd = Doc.getElementById("allProductsContainer");
		for (Element s : dd.select(".productCategoryContainer")) {
			String cat=(s.select(".header").text());
			for (Element ss : s.select(".textContainer").select("li").select("a")) {
				String subcat=(ss.text());
				String caturl=(ss.attr("abs:href"));
				cats.add(new getCategoryandsubcategory(caturl, cat, subcat));
			}
			
		}
	 }

}
