
package marksandspencer.com;
import Main.UI;
import Main.site1panel;
 

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.swing.JOptionPane;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class caturl {	
 static int process=0;
	static long startTime = System.nanoTime();
	private static final String caturls = System.getProperty("user.dir") + "\\data\\caturls.csv";
	private static final String caturls2 = System.getProperty("user.dir") + "\\data\\caturls2.csv"; 

	public static void pass() {
		
		ArrayList<urldata> urls = new ArrayList<>(2500);
		String url = "https://www.marksandspencer.com/ae/";
		try {
			Document doc = Jsoup.connect(url).get();
			
			for (Element S : doc.select(".menu-category")) {
 				
			 ArrayList<String>cats=new ArrayList<>(50);
			 for(Element ch:S.select(".level-1-title") )
			 {
				cats.add(ch.text()); 
			 
			 }
			 
				 int loop=0;
					for (Element s:S.select(".menu-wrapper")) {
						if (!s.select(".level-2-list").select("li").text().toLowerCase().contains("offers"))
							for (Element ss : s.select(".level-2-list").select("li")) {
								String caturl = ss.select("a[href]").toString();
								
								if (!caturl.isEmpty()) {
									String type = ss.text();
									String subcategory = "NA";// *or blank if required
									String url2 = ss.select("a[href]").first().absUrl("href").toString();
									urls.add(new urldata(cats.get(loop), type, subcategory, url2));
									 System.out.println("::cat:: "+cats.get(loop)+" :::type::: "+ type+" ::sub:: "+  subcategory+" ::url:: "+  url2);
								}

							} loop++;
					}
				 

			}
			
			pass2(urls);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please check the connecction and start he program: error:" + e);
			System.exit(0);
		}

	}

	public static void pass2(ArrayList<urldata> urls) {
		
		 
		site1panel.pbar1.setMaximum(urls.size());
			for (int i = 0; i <urls.size(); i++) {
				
				int retry=0;
				while(retry++<=4)
				{
					try {
						System.out.println(i);
						Document doc = Jsoup.connect(urls.get(i).url).get();
						String chk = (doc.select(".subcats")).toString();
						 
						if (!chk.isEmpty())
							for (Element s : doc.select(".subcats").select("a[href]")) {
								String subcategory = urls.get(i).type;
								String type = s.text();
								String url = s.absUrl("href");
								urldata.urldatas.add(new urldata(urls.get(i).category,type, subcategory, url));
								
							}
						else
							urldata.urldatas.add(new urldata(urls.get(i).category,urls.get(i).type, urls.get(i).subcategory, urls.get(i).url));
				break;	} catch (Exception e) {
						System.err.println(urls.get(i).url);
						if(e.toString().toLowerCase().contains("read timed out"))
						{
							
						}
						else if (e.toString().toLowerCase().contains("too many redirects"))
						{break;}
						
					}
				}
				site1panel.pbar1.setValue(i+1);
			}


finish1(); 
			long endTime1 = System.nanoTime();
			long totalTime = endTime1 - startTime;
			site1panel.pbar1.setValue(site1panel.pbar1.getMaximum());;
			}
 
	
	 

	public static void finish1()
	{ 
	 
		try {
		createCSV(); 
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"please close the csv");
			while(true)
			{
			try {
				createCSV(); break;
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"please close the csv");
			}	
			}
		}
	 
		
	}
public static void createCSV()throws IOException 
{File chkdir=new File(System.getProperty("user.dir") + "\\data");
chkdir.mkdir();
	try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(caturls));

		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("category", "type",
				"subcategory", "url"));) {

	for (int i = 0; i < urldata.urldatas.size(); i++) {
		String	category=urldata.urldatas.get(i).category;
		String type=urldata.urldatas.get(i).type;
		String subcategory=urldata.urldatas.get(i).subcategory;
		String url=urldata.urldatas.get(i).url;
		
		csvPrinter.printRecord(category, type, subcategory, url);
	}

	csvPrinter.flush();
}
	
}

public static void createCSV2()throws IOException 
{File chkdir=new File(System.getProperty("user.dir") + "\\data");
chkdir.mkdir();
	try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(caturls2));

		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("category", "type",
				"subcategory", "url"));) {

	for (int i = 0; i < urldata.urldatas2.size(); i++) {
		String	category=urldata.urldatas2.get(i).category;
		String type=urldata.urldatas2.get(i).type;
		String subcategory=urldata.urldatas2.get(i).subcategory;
		String url=urldata.urldatas2.get(i).url;
		
		csvPrinter.printRecord(category, type, subcategory, url);
	}

	csvPrinter.flush();
}
	
}

public static void chkstage1()
	{File file=new File(caturls);
	
		boolean chk=file.isFile();
		if(!chk)pass();
		else
			try {
				openCSV();
				site1panel.pbar1.setValue(site1panel.pbar1.getMaximum());
			} catch (Exception e) {
				pass();
			}
	}
public static void chkstage2()
{File file=new File(caturls2);

	boolean chk=file.isFile();
	System.out.println(chk);
	if(!chk)pass_stage2();
	else
		try {
			openCSV2();
			site1panel.pbar2.setValue(			site1panel.pbar2.getMaximum());
			Stage3.pass_stage3();
		} catch (Exception e) {
			pass_stage2();
		}
}

public static void pass_stage2() {
	while (true) {
		if(site1panel.headless)
			UI.op.setHeadless(true);
		try {
			UI.driver1 = new FirefoxDriver(UI.op);
			while (true) {
				try {
					UI.driver2 = new FirefoxDriver(UI.op);
					break;
				} catch (Exception e) {
				} 
			}
		break;} catch (Exception e) {
			 try {
				 UI.driver1.quit(); 
					UI.driver2.quit();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			 
		}
		
	}
	site1panel.pbar2.setMaximum(urldata.urldatas.size()); 
	Thread w1 = new Thread() {

		public void run() {
			
			for (int i = 0; i < (int)urldata.urldatas.size()/2; i++) {
				
				int retry = 1;
				while (retry++ <= 3)
					try {
						UI.driver1.get(urldata.urldatas.get(i).url);
						String category = urldata.urldatas.get(i).category;
						String type = urldata.urldatas.get(i).type;
						String subcategory = urldata.urldatas.get(i).subcategory;
						String url;
						int key = i;
						long startTime = System.nanoTime();
						
						String title=(UI.driver1.getTitle());
						//						WebDriverWait wait = new WebDriverWait(driver, 20);
						//						wait.until(ExpectedConditions.or(ExpectedConditions
						//								.visibilityOfElementLocated(By.xpath("//*[@id=\"search-result-items\"]/li[1]"))
						//
						//						)); 
						
						int count = 0;
						while(true)try {
							UI.driver1.findElementByXPath("//*[@id=\"infiniteTrigger\"]").click();
							 try {
								 ((JavascriptExecutor) UI.driver1)
							     .executeScript("window.scrollTo(document.body.scrollHeight, 4000)");
								((JavascriptExecutor) UI.driver1)
							     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
							 }catch (Exception e) {
								// TODO: handle exception
							}
						} catch (Exception e) {
							// TODO: handle exception
						break;}

						String a = (UI.driver1.getPageSource());
						Document doc = Jsoup.parse(a);
						System.out.println(doc.hasClass("product-swatches"));
						for (Element s : doc.select(".product-tile")) {
							 
							 
							 
							try {
								url=(s.select(".product-name").select("a[href]").first().absUrl("href"));
								urldata.urldatas2.add(new urldata(category, type, subcategory, url, key));
							 
							} catch (Exception e) {
								 
							}
							
							 
						 
						}
						 
						long endTime1 = System.nanoTime();
						long totalTime = endTime1 - startTime;
						System.out.println((double) totalTime / 1000000000.0);
						
						break;
					} catch (Exception e) {}
				site1panel.pbar2.setValue(site1panel.pbar2.getValue()+1);
			} 
			finish2();
		}

		
	};
	w1.start();
	 
	Thread w2 = new Thread() {

		public void run() {
			for (int i = (int)urldata.urldatas.size()/2; i < urldata.urldatas.size(); i++) {
			
				int retry = 1;
				while (retry++ <= 3)
					try {
						UI.driver2.get(urldata.urldatas.get(i).url);
						String category = urldata.urldatas.get(i).category;
						String type = urldata.urldatas.get(i).type;
						String subcategory = urldata.urldatas.get(i).subcategory;
						String url;
						int key = i;
						long startTime = System.nanoTime();
						
						String title=(UI.driver2.getTitle());
						//						WebDriverWait wait = new WebDriverWait(driver, 20);
						//						wait.until(ExpectedConditions.or(ExpectedConditions
						//								.visibilityOfElementLocated(By.xpath("//*[@id=\"search-result-items\"]/li[1]"))
						//
						//						)); 
						
						int count = 0;
						while(true)try {
							UI.driver2.findElementByXPath("//*[@id=\"infiniteTrigger\"]").click();
						 try {
							 ((JavascriptExecutor) UI.driver2)
						     .executeScript("window.scrollTo(document.body.scrollHeight, 4000)");
							((JavascriptExecutor) UI.driver2)
						     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
						 }catch (Exception e) {
							// TODO: handle exception
						}
						} catch (Exception e) {
							// TODO: handle exception
						break;}

						String a = (UI.driver2.getPageSource());
						Document doc = Jsoup.parse(a);
						System.out.println(doc.hasClass("product-swatches"));
						for (Element s : doc.select(".product-tile")) {
							 
							 
							 
							try {
								url=(s.select(".product-name").select("a[href]").first().absUrl("href"));
								urldata.urldatas2.add(new urldata(category, type, subcategory, url, key));
								  
							} catch (Exception e) {
								 
							}
							
							 
						 
						}
						 
						long endTime1 = System.nanoTime();
						long totalTime = endTime1 - startTime;
						System.out.println((double) totalTime / 1000000000.0);
					
						break;
					} catch (Exception e) {}
				site1panel.pbar2.setValue(site1panel.pbar2.getValue()+1);
			} finish2();

		}	

		 
	};
	w2.start();
	 
}

private static void openCSV() throws IOException {
	long start = System.currentTimeMillis();
	
	 		
	int count = 0;
	try (Reader reader = Files.newBufferedReader(Paths.get(caturls));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
		for (CSVRecord csvRecord : csvParser) {
			// Accessing Values by Column Index
			if (count++ > 0) {
				String	category=csvRecord.get(0);
				String type=csvRecord.get(1);
				String subcategory=csvRecord.get(2);
				String url=csvRecord.get(3);
				urldata.urldatas.add(new urldata(category, type, subcategory, url));
			}

		}
	}
	long end = System.currentTimeMillis();
	 NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

	
}
private static void openCSV2() throws IOException {
	int count = 0;
	try (Reader reader = Files.newBufferedReader(Paths.get(caturls2));
			CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
		for (CSVRecord csvRecord : csvParser) {
			// Accessing Values by Column Index
			if (count++ > 0) {
				String	category=csvRecord.get(0);
				String type=csvRecord.get(1);
				String subcategory=csvRecord.get(2);
				String url=csvRecord.get(3);
				urldata.urldatas2.add(new urldata(category, type, subcategory, url));
			}

		}
	}

	
}
static void finish2() {
	// TODO Auto-generated method stub
	process++;
	if(process>=2)
		{
			Thread w = new Thread() {

				public void run() {

					try {
						UI.driver1.quit();
						UI.driver2.quit();

					} catch (Exception e2) {
						// TODO: handle exception

					}

				}
			};
	w.start();
	
		urldata.urldatas2.sort((o1, o2) -> Integer.compare(o1.key, o2.key));
	ArrayList<urldata>temp=new ArrayList<>(80000);
	HashSet <String>hash=new LinkedHashSet<>(80000);
	//removing common url data's
	for(int i=0;i<urldata.urldatas2.size();i++)
	{
		int size=hash.size();//before
		hash.add(urldata.urldatas2.get(i).url);
		if(size!=hash.size()) 
		{temp.add(urldata.urldatas2.get(i));
		}
	}
	urldata.urldatas2=temp;
	Stage3.pass_stage3();
	while(true)
	{try {
		long start = System.currentTimeMillis();
	
		 createCSV2();	long end = System.currentTimeMillis();
		 NumberFormat formatter = new DecimalFormat("#0.00000");
			System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
		 break;
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "please close the csv to save");
	}
		
	}
		process=0;
	}
	
}
}
