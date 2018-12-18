package marksandspencer.com;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Downloaddata  {

	public static void main(String[] args)   {
		String url="https://www.marksandspencer.com/ae/pure-cotton-crew-neck-jumper/p/P60103569.html?dwvar_P60103569_color=XB";
try {
	Document doc=Jsoup.connect(url).timeout(10000).get();
	
	System.out.println(doc.select(".custom-select"));
} catch (IOException e) {
	System.out.println(e);
}
		 
//			//1.Url
//			//2.Collection
//			System.out.println(doc.select(".collection").text());
//			//3.Model number
//			System.out.println(doc.select(".item-code").text());
//			//4.Type
//			//5.Category
//			//6.Sub Category (if Any)
//			//7.Price
//			System.out.println(doc.select(".price-sales").text());
//			//8.Colour
//			System.out.println(doc.select(".variation-text"));
//			long endTime1 = System.nanoTime();
//			long totalTime = endTime1 - startTime;
//			System.err.println((double) totalTime / 1000000000.0);
			
			
		 

	}

}
