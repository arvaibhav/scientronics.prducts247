package ikea.com;

import java.util.ArrayList;

import Main.site2panel;

public class data {
	static int count = 1;
	String productName = "";
	String productType = "";
public	String price = "";

public	String itemNumber = "";
	String variant_type = "";

	String productinformation = "";
	String materialinformation = "";

	String imgurls = "";
	String vurl = "";
	String cat = "";
	String subcat = "";
	int key = 1;
	String subsubcat = "";
public	String stockd = "0"; 
public 	String stockad = "0";

	String per;
	String dimensions = "";
	String note;
	String description;

	public data(String productName, String productType, String price, String itemNumber, String variant_type,
			String productinformation, String materialinformation, String imgurls, String vurl, String cat,
			String subcat, String subsubcat, String stockd, String stockad, String dimensions, String note,
			String description, String per, int key) {
		super();
		this.key = key;
		this.cat = cat;
		this.subcat = subcat;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.itemNumber = itemNumber;
		if (variant_type.trim().length() <= 4) {
			variant_type.replaceAll("/", "").trim();
			if (variant_type.isEmpty())
				variant_type = "-";
		}
		this.variant_type = variant_type;
		this.productinformation = productinformation;
		this.materialinformation = materialinformation;
		this.imgurls = imgurls;
		this.vurl = vurl;
		this.subsubcat = subsubcat;

		this.stockd = stockd;
		this.stockad = stockad;
		this.per = per;
		this.dimensions = dimensions;
		this.note = note;
		this.description = description;
		site2panel.model.addRow(new Object[] { data.count++, productName, productType, price, itemNumber, variant_type,
				cat, subcat, subsubcat, productinformation, materialinformation, imgurls, stockd, stockad, per,
				dimensions, note, description, vurl });
	}

	public static ArrayList<data> datas = new ArrayList<>(10000);

	public data(String price, String itemNumber, String imgurls, String productType, String stockd, String stockad,
			String per, String productName, String productinformation, String materialinformation,

			String dimensions, String note, String description) {
		super();
		this.stockd = stockd;
		this.stockad = stockad;
		this.productType = productType;
		this.per = per;
		this.price = price;
		this.itemNumber = itemNumber;
		this.imgurls = imgurls;
		this.dimensions = dimensions;
		this.note = note;
		this.description = description;

		this.productName = productName;
		this.productinformation = productinformation;
		this.materialinformation = materialinformation;

	}

	public data(String variant_type, String vurl) {
		super();

		this.variant_type = variant_type;
		this.vurl = vurl;
	}

}
