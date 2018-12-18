package ikea.com;

import java.util.ArrayList;

public class chkdata {
String vurl;
data d1;
String variant_type;String subcat;String cat ;String subsubcat;int key;
public chkdata(String vurl, data d1, String variant_type, String subcat, String cat, String subsubcat, int key) {
	super();
	this.vurl = vurl;
	this.d1 = d1;
	this.variant_type = variant_type;
	this.subcat = subcat;
	this.cat = cat;
	this.subsubcat = subsubcat;
	this.key = key;
}
public static ArrayList<chkdata>datas=new ArrayList<>(10000);
 
}
