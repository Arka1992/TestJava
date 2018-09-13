package CommonUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	public String getStringData(int sheet, int row, int col) throws Exception {

		FileInputStream fis = new FileInputStream(Constants.File);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(sheet);
		String data = sh.getRow(row).getCell(col).getStringCellValue();

		return data;
	}

	public double getNumericData(int sheet, int Row, int Column) throws Exception {
		FileInputStream fis = new FileInputStream(Constants.File);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(sheet);
		int data = (int) sh.getRow(Row).getCell(Column).getNumericCellValue();
		return data;

	}
	/* To Set the Cell Value */

	public void setData(String sheet, int Row, int Column, String data) throws Exception {
		FileInputStream fis = new FileInputStream(Constants.File);
		Workbook w = WorkbookFactory.create(fis);
		Sheet s = w.getSheet(sheet);
		if (s.getRow(Row).equals(null)) {
			s.createRow(Row);
		}
		if (s.getRow(Row).getCell(Column).equals(null)) {
			s.getRow(Row).createCell(Column).setCellValue(data);
		} else {
			s.getRow(Row).getCell(Column).setCellValue(data);
		}
		FileOutputStream fos = new FileOutputStream(Constants.File);
		w.write(fos);
		w.close();

	}

}
