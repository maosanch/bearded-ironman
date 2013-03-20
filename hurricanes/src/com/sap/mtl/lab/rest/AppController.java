package com.sap.mtl.lab.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.sap.mtl.lab.services.LocationService;

@Controller
public class AppController {
	@Autowired
	private LocationService locationService;
	@Autowired
	private View jsonView;
	
	private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";

	@RequestMapping(value = "/locations", method = RequestMethod.GET)
	public ModelAndView getLocations() {
		List<Object> locations = new ArrayList<Object>();

		try {
			locations = locationService.getLocations();
		} catch (Exception e) {
			String sMessage = "Error getting locations. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		//logger_c.debug("Returing Funds: " + funds.toString());
		return new ModelAndView(jsonView, DATA_FIELD, locations);
		//return new ModelAndView();
	}
	
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView, ERROR_FIELD, sMessage);
	}
	
	/**
	 * Injector methods.
	 */
	public void setFundService(LocationService locationService) {
		this.locationService = locationService;
	}

	public void setJsonView(View view) {
		this.jsonView = view;
	}

}
