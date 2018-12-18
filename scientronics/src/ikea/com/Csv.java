package ikea.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

 
public class Csv {
public static void main(String[] args) throws  Exception {
	 
	makecsv();
} 

	public static void makecsv( ) throws IOException 
	{	String name="sample"+System.currentTimeMillis();
		ArrayList<data>tp=data.datas;
		tp.sort((o1, o2) -> Integer.compare(o1.key, o2.key));
		
		 File chkdir=new File("D:" + "\\CSV");
		 chkdir.mkdirs();
		 
		 
	 
		 
		 
			 try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("D:" + "\\CSV\\"+name+".csv"),StandardCharsets.UTF_8);

				CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Product Name","Product Type",
			    		"Price","ItemNumber","Variant_type","Category","Sub Category",
			    		"productinformation","materialinformation","imgurls","vurl"));) {

			for (int i = 0; i <  tp.size(); i++) {
				String productName=tp.get(i).productName;
				String productType=tp.get(i).productType;
				String price=tp.get(i).price;
				String itemNumber=tp.get(i).itemNumber;
				String variant_type=tp.get(i).variant_type;
				String productinformation=tp.get(i).productinformation;
				String materialinformation=tp.get(i).materialinformation;
				String imgurls=tp.get(i).imgurls;
				String vurl=tp.get(i).vurl;
				String cat = tp.get(i).cat;
				String subcat=tp.get(i).subcat;
				String subsubcat=tp.get(i).subsubcat;
				String stockd=tp.get(i).stockd;
				String stockad=tp.get(i).stockad; 

				String per=tp.get(i).per;
				String dimensions=tp.get(i).dimensions;
				String note=tp.get(i).note;
				String description=tp.get(i).description;
				csvPrinter.printRecord(productName, productType,price ,itemNumber , variant_type,cat,subcat ,productinformation ,materialinformation , imgurls,
						subsubcat	,	stockd ,stockad, per, dimensions ,note, description,
						vurl);
			}

			csvPrinter.flush();
			 
		}
			
		
		
	}
}
