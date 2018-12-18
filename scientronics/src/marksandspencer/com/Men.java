package marksandspencer.com;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class Men {

	public static void main(String[] args) throws IOException {
	String url="https://www.marksandspencer.com/ae/l/lingerie/";
	Document doc = Jsoup.connect(url).get();
	for(Element s:doc.select(".subcats"))
	{for(Element d:s.select("a[href]"))
	{
		System.out.println(d.absUrl("href"));
	}
		
	}
	}

}
