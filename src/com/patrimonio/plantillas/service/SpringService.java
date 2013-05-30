package com.patrimonio.plantillas.service;

import org.apache.log4j.Logger;

public class SpringService {

	protected static Logger logger = Logger.getLogger("service");
	
	public String echo(String msg) {
		logger.debug("Entering SpringService");
		
		return "Hello " + msg + " from Spring!";
	}
}
