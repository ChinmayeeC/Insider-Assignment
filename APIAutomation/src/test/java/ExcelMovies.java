import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class ExcelMovies {
	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) 
    { 
        // Blank workbook 
        XSSFWorkbook workbook = new XSSFWorkbook(); 
  
        // Create a blank sheet 
        XSSFSheet sheet = workbook.createSheet("Movie Name"); 
  
        // This data needs to be written (Object[]) 
        Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
        data.put("1", new Object[]{ "SNo", "Movie Name for content available zero"}); 
        data.put("2", new Object[]{ 1, "Bunty Aur Babli 2" }); 
        data.put("3", new Object[]{ 2, "Haseen Dilruba" }); 
        data.put("4", new Object[]{ 3, "The Big Bull" }); 
        data.put("5", new Object[]{ 4, "Maidaan" }); 
        data.put("6", new Object[]{ 5, "Mr. Lele" });
        data.put("7", new Object[]{ 6, "Shabaash Mithu" });
        data.put("8", new Object[]{ 7, "Heropanti 2" });
        data.put("9", new Object[]{ 8, "Chhalaang" });
  
        // Iterate over data and write to sheet 
        Set<String> keyset = data.keySet(); 
        int rownum = 0; 
        for (String key : keyset) { 
            // this creates a new row in the sheet 
            Row row = sheet.createRow(rownum++); 
            Object[] objArr = data.get(key); 
            int cellnum = 0; 
            for (Object obj : objArr) { 
                // this line creates a cell in the next column of that row 
                Cell cell = row.createCell(cellnum++); 
                if (obj instanceof String) 
                    cell.setCellValue((String)obj); 
                else if (obj instanceof Integer) 
                    cell.setCellValue((Integer)obj); 
            } 
        } 
        try { 
            // this Writes the workbook Excel Movies
            FileOutputStream out = new FileOutputStream(new File("Movie Name.xlsx")); 
            workbook.write(out); 
            out.close(); 
            System.out.println("Movie Name.xlsx written successfully on disk."); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 
	
	
