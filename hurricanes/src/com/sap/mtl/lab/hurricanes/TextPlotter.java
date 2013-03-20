package com.sap.mtl.lab.hurricanes;

import java.util.List;

public class TextPlotter implements IPlotter {

	@Override
	public void plot(List<Object> data) {
		System.out.print("Plotting: " + data.size() + " locations.");
	}

}
