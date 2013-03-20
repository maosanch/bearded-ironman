package com.sap.mtl.lab.hurricanes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestHurricanes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IParser parser = new ExcelParser();
		IPlotter plotter = new TextPlotter();
		List<Object> locations = new ArrayList<Object>();
		
		try {
			locations = parser.parse("C:/Users/i831499/Documents/SAP/Social Media Integration/Dev Infra/small project/hurricanes.xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		plotter.plot(locations);

	}

}
