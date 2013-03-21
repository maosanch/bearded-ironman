package com.sap.mtl.lab.hurricanes;

import java.io.IOException;
import java.util.List;

/**
 * Interface for parsing documents in different formats.
 *
 */
public interface IParser {
	/**
	 * Parse a document specified in the fileName parameter.
	 * @param fileName (Expecting the full path and filename)
	 * @return List<Object> Contains a list of objects.  Each object represents a row in the document parsed.
	 * @throws IOException
	 */
	public List<Object> parse(String fileName) throws IOException;

}
