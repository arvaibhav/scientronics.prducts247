package aceuae;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browser {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\data\\geckodriver.exe");

		FirefoxOptions op = new FirefoxOptions();
		op.addPreference("permissions.default.image", 2);
		op.addPreference("browser.cache.disk.enable", false);
		op.addPreference("browser.cache.memory.enable", false);
		op.addPreference("browser.cache.offline.enable", false);
		op.addPreference("network.http.use-cache", false);
		FirefoxDriver driver = new FirefoxDriver(op);
		get(driver, "https://www.aceuae.com/en/ace-uae/painting", 3,0,",",",","","","");

	}

	public static void get(FirefoxDriver driver, String url, int page,int key,String c,String sc
			,String ssc,String t1,String t2) {
		//"cat", "sc", "ssc", "ta1", "ta2", url, page, key);
		HashSet<String> docs = new HashSet<>();
		while (true) {
//________________________________________________________________________________________________________________________
			try {
//				driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				driver.get(url);
				break;
			} catch (WebDriverException | NullPointerException e2) {
				if (!e2.getLocalizedMessage().contains("Timeout loading page after")) {
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
					}
					try {
						driver.get(url);
					} catch (Exception e) {
					}
				} else
					break;
			} catch (Exception e) {
			}
		}
//________________________________________________________________________________________________________________________		
		HashSet<String>h=new HashSet<>();int sz=0;
		for (int i = page; i >= 1; i--) {sz=h.size();
			try {
				driver.findElementByXPath("/html/body/div[4]/div[1]/div/div/a/div[1]/img").click();
			} catch (Exception e) {}
			
			try {
				driver.findElementByXPath("//*[@id=\"WC_SearchBasedNavigationResults_pagination_link_right_categoryResults\"]").click();
			} catch (Exception e) {}
			 while (true) {Document doc=null;
				try {
					  doc = Jsoup.parse(driver.getPageSource());

					for (Element s : doc.select(".sku")) {

						String urlz = s.text().toString();
						System.out.println(urlz);
						h.add(urlz);
					}
				} catch (Exception e) {
				} 
			if(sz!=h.size()) {
				productsurls.geturls(doc, c, sc, ssc, t1, t2, url, page, key);
				break;
			}
			}
			try {
				 try {
					driver.findElementByXPath("/html/body/div[4]/div[1]/div/div/a/div[1]/img").click();
				} catch (Exception e) {}
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		for(productsurls s :datastorage.purls)
			{
			System.out.println(s.sku);
			}
	}

}
