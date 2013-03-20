package com.sap.mtl.lab.hurricanes;

import java.io.IOException;
import java.util.List;

public interface IParser {
	public List<Object> parse(String fileName) throws IOException;

}
