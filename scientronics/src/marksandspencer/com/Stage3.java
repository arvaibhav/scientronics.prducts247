package marksandspencer.com;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.swing.JOptionPane;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Main.UI;
import Main.site1panel;
public class Stage3 {
public static 	Thread recheck;
public static boolean taskcomplete=false;
	static int count=1;
	static int progress=0;
	static int process=0;
	static int track=0;
	static int work1=0,work2=0;
	public static   Thread w1, w2 ;
	public static FirefoxOptions op;
	public static FirefoxDriver driver1,driver2;
public static void  pass_stage3()
{site1panel.pbar3.setMaximum(urldata.urldatas2.size());
 opendriver();
 makethread(driver1,0,(int)urldata.urldatas2.size()/2,w1,1);
 makethread(driver2, (int)urldata.urldatas2.size()/2, urldata.urldatas2.size(),w2,2);
 recheck = new Thread() {//it will help when firefox hangs

		public void run() {
			
		while (!taskcomplete) {
			 Stage3.track=data.datas.size();
				try 
				{
					Thread.sleep(1000*60*10);
					
				} catch (Exception e) {System.out.println("sleep error");}
				
				if(data.datas.size()==Stage3.track)
				{site1panel.pbar3.setValue(Stage3.progress);
					int start1=Stage3.work1;
				int start2=Stage3.work2;
				try {
					w1.stop();
					w2.stop();
				} catch (Exception e1) {
					int s=0;
					while(s++<=5)
					{try {
						w1.stop();
						w2.stop();
					break;} catch (Exception e) {}
						
					}
					e1.printStackTrace();
				}  
				try {try {
					if((work1+work2)==urldata.urldatas2.size())
					{
						break;
					}else {taskcomplete=false;}
				} catch (Exception e) {break;}
						Stage3.process=0;
			        	 Runtime.getRuntime().exec("taskkill /F /IM Firefox.exe") ;
			        	Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe") ;
			        	 opendriver();
			        	 makethread(driver1,start1,(int)urldata.urldatas2.size()/2,w1,1);
			        	 makethread(driver2, start2, urldata.urldatas2.size(),w2,2);
			        } catch (Exception e) {
			            e.printStackTrace();  
			        }	
				}
				
			  
		}
		}
	};
	recheck.start(); 
	
}
static void opendriver()
{ op=new FirefoxOptions();
 
//op.addPreference("browser.cache.disk.enable", false);
//op.addPreference("browser.cache.memory.enable", false);
//op.addPreference("browser.cache.offline.enable", false);
//op.addPreference("network.http.use-cache", false);
//op.addPreference("browser.cache.disk.enable", true);
if(site1panel.headless)
op.setHeadless(true);
	count=1;  
	while (true) {
		try {
			  driver1 = new FirefoxDriver( op);
			 
			while (true) {
				try {
					 driver2 = new FirefoxDriver( op);
					break;
				} catch (Exception e) {
				} 
			}
		break;} catch (Exception e) {
			 try {
				  driver1.quit(); 
					 driver2.quit();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			 
		}
		
	}
}
static void makethread(FirefoxDriver driver,int start,int end,Thread w,int work)
{
	  w = new Thread() {

		public void run() {
			
			for(int index=start;index<end;index++)
			{if(work==1)work1=index;
			if(work==2)work2=index;
				int retry=0;boolean flag1=false;
				while(retry++<=3)
				{if(flag1)break;
					try {
				String producturl=urldata.urldatas2.get(index).url;
				String type=urldata.urldatas2.get(index).type;
				String category=urldata.urldatas2.get(index).category;
				System.out.println(category);
				String subcategory=urldata.urldatas2.get(index).subcategory;
				String title;
				String collection="-";
				String model;
				String price = "-";
				String color;
				String size = "";
				String stypedecription;
				String img1;
				String img2;
				String img3;
				String img4;
				String handel;
				int key=index;;
				 
while (true) {
	//-----------------------------------------------------------------------------------------
	try {
		driver.get(producturl);
	break;} catch (WebDriverException | NullPointerException e2) {
			Thread.sleep(4000);
			driver.get(producturl);
	} catch (Exception e) {
		try {
			driver.quit();driver.get(producturl);
		} catch (Exception e2) {
		break;
		}
	}
}
				try {
					if(driver.getTitle().toLowerCase().contains("Please bear with us"))
						Thread.sleep(15000);
				} catch (Exception e) {}///check does page blocked or not if blocked it waits for 15mins
				
				
				Document doc=Jsoup.parse(driver.getPageSource());
				try {doc.select(".collection").get(1);flag1=true;continue;}catch (Exception e) {}
				  
				title=doc.select(".head").select(".title").text();//common
					 collection=doc.select(".head").select(".collection").text();//common
					 model=doc.select(".head").select(".item-code").text();//common
					 stypedecription=doc.select(".productDetailsBulletPoints").html();//common
					 try {
						price=doc.select(".price-sales").first().text();
					} catch (Exception e2) {}
			 		 if(collection.isEmpty())collection="-";
					//---------------
					 color=doc.select(".variation-text").text();
					 handel=title.toLowerCase().replaceAll(" ","-");
				//---------saving img url *only 4---------
				 String[] img= {"-","-","-","-"};
				 int imgarr=0;
				try {
					for(Element s:doc.select(".slide").select("img"))
					{	 
						img[imgarr++]=s.attr("src");
					}
				} catch (Exception e1) {}  
					 
				 
				img1=img[0];img2=img[1];img3=img[2];img4=img[3];//common for all  sizes
				//---------------------------------------------
				//-------getting sizes ----------------------
				boolean oncesz=true;
				ArrayList<data>temp=new ArrayList<>(1000); 
				for(Element s:doc.select(".highlight").select("option"))
				{	try {
					if(s.hasAttr("value"))
						{String temp1=(s.text());
						int cut=temp1.lastIndexOf("- ");
						 size=temp1.substring(0,cut).trim();
						 price=temp1.substring(cut+1).trim();
						 
						   temp.add(new data("-", "-", "-", "-", "-", "-", "-", price, "-", size, "-", "-", "-", "-", "-", handel,key));	 
						  
						 }
						
				
				} catch (Exception e) {}
				
				}
				try {
					temp.sort((o1, o2) -> o1.price.compareTo(o2.price));
				} catch (Exception e) {}
				
				if (!temp.isEmpty()) {
					data.datas.add(new data(title, producturl, collection, model, type, category, subcategory,
							temp.get(0).price, color, temp.get(0).size, stypedecription, img1, img2, img3, img4,handel, key));
					site1panel.model.addRow(new Object[] { count++, title, producturl, collection, model, type,
							category, subcategory, temp.get(0).price, color, temp.get(0).size, stypedecription, img1,
							img2, img3, img4 });
					for (int ii = 1; ii < temp.size(); ii++) {
						data.datas.add(new data(title, producturl, collection, model, type, category, subcategory, temp.get(ii).price, color,
								temp.get(ii).size, stypedecription, img1, img2, img3, img4,handel, key));
						site1panel.model.addRow(new Object[] { count++,title, producturl, collection, model, type, category, subcategory,
								temp.get(ii).price,color, temp.get(ii).size,stypedecription, img1, img2, img3, img4});
					} 
				}else {flag1=true;	if(color.isEmpty())color="NA";
				data.datas.add(new data(title, producturl, collection, model, type, category, subcategory,
						 price, color, "NA", stypedecription, img1, img2, img3, img4,handel, key));
				site1panel.model.addRow(new Object[] { count++, title, producturl, collection, model, type, category, subcategory,
						 price, color, "NA", stypedecription, img1, img2, img3, img4 });
				break;
				}
				//now start checking other colors 
				 int b=2;
				  while(true)
					 {temp.clear();
					  try {
							 driver.findElementByXPath("//*[@id=\"pdpMain\"]/div[3]/div[3]/div/ul/li["+(b++)+"]").click();;
							int chktime=0;
							boolean allow=true;
							 while (true) {
								if(allow)
								if(chktime++>=200) {
									try {allow=false;
										driver.get(producturl);
									} catch (Exception e) {}
									chktime=0;
									try {
										driver.findElementByXPath("//*[@id=\"pdpMain\"]/div[3]/div[3]/div/ul/li["+(b-1)+"]").click();;
										Thread.sleep(600);
									} catch (Exception e) {System.out.println(e);}
								}
								 try {Thread.sleep(50);} catch (Exception e) {}
								
								Document doc1=Jsoup.parse(driver.getPageSource());
								 imgarr=0;
								 for(int i2=0;i2<4;i2++)img[i2]="-";//Reinitialize 
									try {
										for(Element s:doc1.select(".slide").select("img"))
										{	 
											img[imgarr++]=s.attr("src");
										}
									} catch (Exception e1) {}
									
									if(!(img[0].equals(img1)&&img[3].equals(img4))||(!img[0].equals(img1)&&img[3].equals("-"))||!allow)
									{//checking url changed or not if not retry by waiting 200 mini sec
										img1=img[0];img2=img[1];img3=img[2];img4=img[3];//common for all  sizes
										//---------------------------------------------
										//-------getting sizes ----------------------
										 color=doc1.select(".variation-text").text(); 
									
										for(Element s:doc1.select(".highlight").select("option"))
										{	try {
											if(s.hasAttr("value"))
												{String temp1=(s.text());
												int cut=temp1.lastIndexOf("- ");
												 size=temp1.substring(0,cut).trim();
												 price=temp1.substring(cut+1).trim();
												 
												   temp.add(new data("-", "-", "-", "-", "-", "-", "-", price, "-", size, "-", "-", "-", "-", "-",handel, key));	 
												  
												 }
												
										
										} catch (Exception e) {}
										
										}
										try {
											temp.sort((o1, o2) -> o1.price.compareTo(o2.price));
										} catch (Exception e) {}
										data.datas.add(
												new data(title, producturl, collection, model, type, category, subcategory, temp.get(0).price, color, temp.get(0).size, stypedecription, img1, img2, img3, img4, handel,key));
										site1panel.model.addRow(new Object[] {count++,title, producturl, collection, model, type, category, subcategory, temp.get(0).price, color, temp.get(0).size, stypedecription, img1, img2, img3, img4   });
										for(int ii=1;ii<temp.size();ii++)
										{data.datas.add(new data(title, producturl, collection, model, type, category, subcategory, temp.get(ii).price, color, temp.get(ii).size, stypedecription, img1, img2, img3, img4, handel,key));
										site1panel.model.addRow(new Object[] {count++,title, producturl, collection, model, type, category, subcategory, temp.get(ii).price,color, temp.get(ii).size, stypedecription, img1, img2, img3, img4});	
										}	
									break;}
								 
							}
							 
					  }catch (Exception e) {;break;}
					 }
				//
				
				
//-----------------------------------------**----------------------------------------------
				break;} catch (Exception e) {}
					
				}
				site1panel.pbar3.setValue(++Stage3.progress);	
			}
			finish2();
		}
	};
	w.start();
	
}
static void finish2() {
	// TODO Auto-generated method stub
	process++;
	if(process>=2)
		{taskcomplete=true;
			Thread w = new Thread() {

				public void run() {

					try {
						while (true) {
							try {
								driver1.quit();
							break;} catch (Exception e) {
							} 
						}
						while (true) {
							try {
								driver2.quit();
							break;} catch (Exception e) {
							} 
						}

					} catch (Exception e2) {
						// TODO: handle exception

					}

				}
			};
	w.start();
	
		  
		site1panel.chkstage1.setEnabled(true);site1panel.chkHeadless.setEnabled(true);
		site1panel.chkstage2.setEnabled(true); 
		site1panel.btnStart.setEnabled(true);
		try {
			createCSV(UI.tdydate,data.datas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		JOptionPane.showMessageDialog(null, "scrapping done and saved to CSV database");
		
		process=0;
	}
	
}
public static void createCSV(String name,ArrayList<data>datas)throws IOException 
{File chkdir=new File(System.getProperty("user.dir") + "\\CSV");
chkdir.mkdir();
HashSet<data>hash=new LinkedHashSet<>(80000);
ArrayList<data>save=new ArrayList<data>(100000);
for(data d:datas)
{	hash.add(d);}
 
for(data d:hash)
	save.add(d);
	try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(System.getProperty("user.dir") + "\\CSV\\"+name+".csv"));

		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Handel","Title", "URL","Collection","Model/EAN/SKU"
				,"Type", "Category", "Sub Category","Price","Color","Size","Style Description","Img1","Img2","Img3","Img4"));) {

	for (int i = 0; i <  save.size(); i++) {
		String handel=save.get(i).handel;
		String title=save.get(i).title;

		String producturl=save.get(i).producturl;
		String collection=save.get(i).collection;
		String model=save.get(i).model;
		String type=save.get(i).type;
		String category=save.get(i).category;
		String subcategory=save.get(i).subcategory;
		String price=save.get(i).price;
		String color=save.get(i).color;
		String size=save.get(i).size;
		String stypedecription=save.get(i).stypedecription;
		String img1=save.get(i).img1;
		String img2=save.get(i).img2;
		String img3=save.get(i).img3;
		String img4=save.get(i).img4;
		if( !title.isEmpty()) 
		csvPrinter.printRecord(handel,title, producturl, collection, model,type,category,subcategory,price,color,size,stypedecription,img1,img2,img3,img4);
	}

	csvPrinter.flush();
	if(!UI.csvfiles.contains(name))
		UI.csvfiles.add(name);
}
	
}
 
}
