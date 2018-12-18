package marksandspencer.com;

import java.util.ArrayList;

 
 

public class urldata {
String	category;
String type;
String subcategory;
String url;
int key=0;
public static ArrayList<urldata>urldatas=new ArrayList<>(2500);
public static ArrayList<urldata>urldatas2=new ArrayList<>(1500000);
public urldata(String category,String type, String subcategory, String url) {
	 
	this.category = category;
	this.subcategory = subcategory;
	this.url = url;
	this.type = type;
}
public urldata(String category,String type, String subcategory, String url,int key) {
	 
	this.category = category;
	this.subcategory = subcategory;
	this.url = url;
	this.type = type;
	this.key=key;
}


}
