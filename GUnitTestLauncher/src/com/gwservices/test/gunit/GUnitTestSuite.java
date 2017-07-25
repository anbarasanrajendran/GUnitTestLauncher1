package com.gwservices.test.gunit;

import com.guidewire.testharness.GosuAwareSuiteUtil;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

public class GUnitTestSuite extends TestCase {

	public static String PRODUCT_TYPE = "product.type";
	public static String PACKAGES_UNDER_TEST = "packages.under.test";
	
	public GUnitTestSuite(String name) {
		super(name);				
		System.out.println("----------------------------------------");
	}

	public static Test suite() {
		System.out.println("----+++++++++++++++------------------------------------");
		GosuAwareSuiteUtil suiteUtil = new GosuAwareSuiteUtil();
		suiteUtil.registerGosuRepositories();
		
		String[] packages = getPackagesUnderTest();
		for(int i = 0; i < packages.length; i++){
			suiteUtil.addPackageToSuite(packages[i], true, null);
		}
		
		TestSuite suite = suiteUtil.getJunitSuite();		
		return suite;
	}
	
	private static String[] getPackagesUnderTest(){
		String packageString = System.getProperty(PACKAGES_UNDER_TEST);
		return packageString.split(",");
	}
}
