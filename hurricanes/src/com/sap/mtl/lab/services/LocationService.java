package com.sap.mtl.lab.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sap.mtl.lab.hurricanes.ExcelParser;
import com.sap.mtl.lab.hurricanes.IParser;

@Service
public class LocationService {

	private IParser parser = new ExcelParser();
	
	@Value("${file.input}") 
	private String fileName; 
	
	public List<Object> getLocations() throws IOException {
		List<Object> locations = new ArrayList<Object>();
		
		locations = parser.parse(fileName);
		
		return locations;
	}

}
