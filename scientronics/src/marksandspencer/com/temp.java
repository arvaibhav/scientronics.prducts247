package marksandspencer.com;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class temp {

	public static void main(String[] args) throws IOException {
	String url="https://www.marksandspencer.com/ae/l/men/workwear/#page:5";
	Document doc = Jsoup.connect(url).followRedirects(true).get();
	for(Element s:doc.select(".grid-tile"))
	{ System.out.println(s.text());
		
		
	}
	}

}
