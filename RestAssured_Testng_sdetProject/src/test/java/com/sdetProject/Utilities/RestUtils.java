package com.sdetProject.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String ename()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("morpheus"+generatedString);
	}
	
	public static String ejob()
	{
		String generatedString =RandomStringUtils.randomAlphabetic(1);
		return("leader"+generatedString);
	}

}
