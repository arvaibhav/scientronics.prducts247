package ikea.com;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import Main.site2panel;

public class Productinfo {

	public static void main(String[] args) throws Exception {
		String url = "https://www.ikea.com/ae/en/catalog/products/S49186841/";// 2
		start(url, "cat", "subcat", true, 1);
		for (int i = 0; i < 45; i++)
			System.out.println(data.datas.get(i).imgurls);

	}

	static void start(String url, String catzs, String subcatzs, boolean isoption, int key) throws Exception {
		Document doc = Jsoup.connect(url).get();
		String cat = "-";
		String subcat = "-";
		String subsubcat = "-";
		int count = 0;
		for (Element s : doc.select("#breadCrumbs").select("li").select("a")) {
			count++;

			if (count == 2)
				cat = s.text();
			else if (count == 3)
				subcat = s.text();
			else if (count == 4)
				subsubcat = s.text();
		}

		data d2 = dynamic(doc, url);
		String variant_type = "-";

		if (isoption) {
			ArrayList<data> d3 = otherOption(doc);
			for (data s : d3) {
				String vurl = (s.vurl);
				variant_type = s.variant_type;
				if ((!vurl.equals(url))) {
					chkdata.datas.add(new chkdata(vurl, d2, variant_type, cat, subcat, subsubcat, key));
					site2panel.pbar3.setMaximum(site2panel.pbar3.getMaximum() + 1);
				} else {
					data.datas.add(new data(d2.productName, d2.productType, d2.price, d2.itemNumber, variant_type,
							d2.productinformation, d2.materialinformation, d2.imgurls, vurl, cat, subcat, subsubcat,
							d2.stockd, d2.stockad, d2.dimensions, d2.note, d2.description, d2.per, key));
				}

			}
		} else
			data.datas.add(new data(d2.productName, d2.productType, d2.price, d2.itemNumber, "-", d2.productinformation,
					d2.materialinformation, d2.imgurls, url, cat, subcat, subsubcat, d2.stockd, d2.stockad,
					d2.dimensions, d2.note, d2.description, d2.per, key));
//		System.out.println(data.datas.size());
	}

	public static void check(chkdata chk) {
		String vurl = chk.vurl;
		data d1 = chk.d1;
		String variant_type = chk.variant_type;
		String subcat = chk.subcat;
		String cat = chk.cat;
		String subsubcat = chk.subsubcat;
		int key = chk.key;
		for (int i = 0; i < 6; i++)
			try {
				Document ldoc = Jsoup.connect(vurl).get();
				data d21 = dynamic(ldoc, vurl);

				data.datas.add(new data(d21.productName, d21.productType, d21.price, d21.itemNumber, variant_type,
						d21.productinformation, d21.materialinformation, d21.imgurls, vurl, cat, subcat, subsubcat,
						d21.stockd, d21.stockad, d21.dimensions, d21.note, d21.description, d21.per, key));

				site2panel.pbar3.setValue(site2panel.pbar3.getValue() + 1);
				break;
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(null, "please check the connection [stage 3.2]");
			} catch (Exception e) {
				if (i > 2)
					System.err.println("inner" + i);
			}

	}

	private static String getminfo(Document doc) {
//	 String pinfo="<h1>Materials and environment</h1>\n";String temp="";
//	 try {
//		temp=("<h3>Product description</h3>\n"+doc.select("#custMaterials").first().toString().replaceAll(" id=\"custMaterials\" class=\"texts\"", "")+"\n");
//		if(!temp.contains("><"))pinfo+=temp;
//	 } catch (Exception e) { }
//	 try {
//		temp=("<h3>environment</h3>\n"+doc.select("#environment").toString().replaceAll(" id=\"environment\" class=\"texts\"", "")+"\n");
//		if(!temp.contains("><"))pinfo+=temp;
//	 } catch (Exception e) { }	
//	 
//		return pinfo;
//	
		String temp = "";
		try {
			temp = doc.select("#custMaterials").text();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return temp;
	}

	private static String getpinfo(Document doc) {
		String temp = "";
		String productinformation = "";
//		productinformation += ("<h1>Product information</h1>\n");
		try {
			temp = (doc.select("#custBenefit").first().toString()
					.replaceAll(" id=\"custBenefit\" class=\"texts keyFeaturesmargin\"", "").replaceAll("-", "")
					+ "\n");
			if (!temp.contains("><"))
				productinformation += temp;
		} catch (Exception e) {
		}
//		try {
//			temp = ("<h3>Good to Know</h3>\n"
//					+ doc.select("#goodToKnow").first().toString().replaceAll(" id=\"goodToKnow\" class=\"texts\"", "")
//					+ "\n");
//			if (!temp.contains("><"))
//				productinformation += temp;
//		} catch (Exception e) {
//		}
//		try {
//			temp = ("<h3>Sold Separately</h3>\n" + "<p>"
//					+ doc.select("#soldSeparately").first().text().replaceAll("<br/>", "") + "</p>" + "\n");
//			if (!temp.contains("><"))
//				productinformation += temp;
//		} catch (Exception e) {
//		}
//		try {
//			temp = ("<h3>care instructions</h3>\n"
//					+ doc.select("#careInst").first().toString().replaceAll(" id=\"careInst\" class=\"texts Wdth\"", "")
//					+ "\n");
//			if (!temp.contains("><"))
//				productinformation += temp;
//		} catch (Exception e) {
//		}
//
//		try {
//			temp = ("<h3>designer<h3>\n" + "<p>" + doc.select("#designer_right").first().text() + "</p>") + "\n";
//			if (!temp.contains("><"))
//				productinformation += temp;
//		} catch (Exception e) {
//		}
		return productinformation;
	}

	static data dynamic(Document doc, String url) {
		String product_type = doc.select("#type").text();// 1
		String stockd = "0", stockad = "0";
		String per = "1 unit";
		try {
			per = doc.select("#storeformatpieces").first().text().replaceAll("/", "").trim();
		} catch (Exception e) {
		}
		if (per.isEmpty())
			per = "1 unit";
		for (int i = 0; i < 6; i++)
			try {
				stockd = getstock(url, false);

				break;
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(null, "please check the connection [stage 3]_stock");
			} catch (Exception e) {
				if (i > 4)
					System.err.println("d" + i + "::" + url);
			}
		for (int i = 0; i < 6; i++)
			try {
				stockad = getstock(url, true);

				break;
			} catch (Exception e) {
				if (i > 4)
					System.err.println("ad" + i + "::" + url);
			}
		String price = doc.select("#price1").text().replace("Dhs", "").trim();
		String itemNumber = doc.select("#itemNumber").text().replaceAll("[.]", "") + "IK";
		String imgurls = "";
		try {
			String temp = (doc.select("script").select("[type=text/javascript]").toString());
			temp = temp.substring(temp.indexOf("\"large\":[\"") + "\"large\":[\"".length());
			temp = ("https://www.ikea.com"
					+ temp.substring(0, temp.indexOf("]},")).replaceAll("\",\"", " , https://www.ikea.com")
							.replaceAll("_S4.JPG", "_S5.jpg").replaceAll("\"", ""));
			imgurls = temp;
		} catch (Exception e) {
		}

//		String soldSeparately = doc.select("#soldSeparately").text();

		String productName = doc.select("#name").text();

		String productinformation = getpinfo(doc);
		String materialinformation = getminfo(doc);
		String dimensions = "-";
		String note;
		String description = "";

		note = doc.select("#requiresAssembly").text();
		if (note.isEmpty())
			note = "-";

		try {
			description = doc.select("#salesArg").toString().replaceAll(" id=\"salesArg\" class=\"salesArguments\"",
					"");
		} catch (Exception e1) {
		}
		if (description.isEmpty())
			description = "-";
		try {
//			String temp = (doc.select("#metric").first().toString()
//					.replaceAll(" id=\"metric\" class=\"texts\" style=\"display:block\"", "") + "\n");
//			if (!temp.contains("><"))
			String temp = doc.select("#metric").first().text();
			if (!temp.isEmpty())
				dimensions = temp;
		} catch (Exception e) {
		}

		return new data(price, itemNumber, imgurls, product_type, stockd, stockad, per, productName, productinformation,
				materialinformation, dimensions, note, description);
	}

	static ArrayList<data> otherOption(Document doc) {
		String topass = "";
		ArrayList<data> dd = new ArrayList<>(20);
		for (Element s : doc.select("noscript")) {
			String ss = s.html();
			if (ss.toLowerCase().contains("dropdown"))
				topass = ss;
		}
		Document ok = Jsoup.parse(topass);

		for (Element s : ok.select(".dropdown").select("option")) {
			String vurl = (s.attr("data-value"));
			String variant_type = (s.text());
//			
			dd.add(new data(variant_type, vurl));
		}
		String itt = "";
		boolean aon = true;
		for (Element s : doc.select("#rightNavInfoDiv").select(".categoryNameLbl")) {
			if (aon) {
				itt += s.text();
				aon = false;
			} else {
				itt += "<>" + s.text();
			}
		}
		String[] temp1 = itt.split("<>");

		for (data s : dd) {
			try {
				String vr = "";
				String[] temp = (s.variant_type).split(" / ");
				for (int i = 0; i < temp.length; i++) {
					vr += " " + (temp1[i]);
					vr += (temp[i]);
					vr += " // ";
				}
				s.variant_type = (vr.trim().substring(0, vr.lastIndexOf("//") - 1));
			} catch (Exception e) {
				s.variant_type = s.variant_type.replaceAll(" / ", " // ");
			}

		}
		return dd;
	}

	private static String getstock(String url, boolean isad) throws Exception {

		String go = "";
		if (isad)
			go = (url.replaceAll("products", "availability") + "055/");
		else
			go = (url.replaceAll("products", "availability") + "218/");
		Document doc = Jsoup.connect(go).get();
		String abc = "0";
		try {
			abc = (doc.select(".sc_com_count").first().text());
		}

		catch (Exception e) {
			abc = "0";
			// TODO: handle exception
		}
		return abc.replaceAll("pcs.", "").trim();
	}

}
