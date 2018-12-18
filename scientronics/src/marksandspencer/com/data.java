package marksandspencer.com;

import java.util.ArrayList;

public class data {
	public String title;
	public String producturl;
	public String collection;
	public String model;
	public String type;
	public String category;
	public String subcategory;
	public String price;
	public String color;
	public String size;
	public String stypedecription;
	public String img1;
	public String img2;
	public String img3;
	public String img4;
	public String handel;
public int key;
public static ArrayList<data>datas=new ArrayList<>(80000);
public data(String title, String producturl, String collection, String model, String type, String category, String subcategory,
		String price, String color, String size, String stypedecription, String img1, String img2, String img3,
		String img4,String handel,int key) {
	 this.handel=handel;
	this.title = title;
	this.producturl = producturl;
	this.collection = collection;
	this.model = model;
	this.type = type;
	this.category = category;
	this.subcategory = subcategory;
	this.price = price;
	this.color = color;
	this.size = size;
	this.stypedecription = stypedecription;
	this.img1 = img1;
	this.img2 = img2;
	this.img3 = img3;
	this.img4 = img4;
}
}
