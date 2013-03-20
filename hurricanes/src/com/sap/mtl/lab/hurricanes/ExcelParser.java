package com.sap.mtl.lab.hurricanes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExcelParser implements IParser {

	@Override
	public List<Object> parse(String fileName) throws IOException {
		ArrayList<Object> locations = new ArrayList<Object>();
		FileInputStream fis = new FileInputStream(fileName);
		
		//open excel file
		HSSFWorkbook workbook = new HSSFWorkbook(fis);

		// Get the first sheet on the workbook.
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		System.out.println("Rows: " + sheet.getPhysicalNumberOfRows());
		
		// get header
		Row header = sheet.getRow(0);
		sheet.removeRow(header);
		System.out.println("header: " + header.getCell(0).toString());
		
		//read line by line
		
		for (Row row : sheet) {
			//System.out.println("row: " + row.getCell(0).toString());
			LocationData location = getRowData(row);
			locations.add(location);
			//System.out.println("location: " + location.getLocation() + ", " + location.getTotal());
		}
		
		return locations;

	}
	
	private LocationData getRowData(Row row){
		LocationData location = new LocationData();
		int i = 0;
		location.setId((int)row.getCell(i++).getNumericCellValue());
		location.setStation(row.getCell(i++).getStringCellValue());
		location.setLocation(row.getCell(i++).getStringCellValue());
		location.setLatitude(row.getCell(i++).getNumericCellValue());
		location.setLongitude(row.getCell(i++).getNumericCellValue());
		i++;
		i++;
		location.setTotal(Integer.parseInt(row.getCell(i++).getStringCellValue().substring(0, 2)));
		
		return location;
	}

}
