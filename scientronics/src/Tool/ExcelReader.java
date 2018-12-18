package Tool;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static final String SAMPLE_XLSX_FILE_PATH = "D://IK.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {ArrayList<String[]> ff=read(SAMPLE_XLSX_FILE_PATH);
   System.out.println(ff.size());
    }
	public static ArrayList<String[]> read(String filename) throws IOException
	{
		ArrayList<String[]> infoList = new ArrayList(5000);
		XSSFWorkbook wb = new XSSFWorkbook(filename);
         wb.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
       
            Sheet sheet = wb.getSheetAt(0);
           int max =( sheet.getRow(0).getLastCellNum());   
            boolean skipHeader = true;
            for (Row row : sheet) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                ArrayList<Cell> cells = new ArrayList<Cell>();
                int lastColumn = Math.max(row.getLastCellNum(), max);// because my
                                                                    // excel
                                                                    // sheet has
                                                                    // max 5
                                                                    // columns,
                                                                    // in case
                                                                    // last
                                                                    // column is
                                                                    // empty
                                                                    // then
                                                                    // row.getLastCellNum()
                        int co=0;                                            // will
                 String []list=new String[max];                                                   // return 4
                for (int cn = 0; cn < lastColumn; cn++) {
                    Cell c = row.getCell(cn);
                  if(c==null)list[cn]="";
                  else {c.setCellType(CellType.STRING);list[cn]=c.toString();}
                   
//                    cells.add(c);
                } infoList.add(list);
                 
	}return infoList;
}}