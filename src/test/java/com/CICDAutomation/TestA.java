package com.CICDAutomation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestA extends BaseClass{
	WebDriver driver = null;
	String value;
	@BeforeMethod
	public void launchBrowser() {
		driver = openChrome();
		driver.get("https://automationstepbystep.com/");
	}
	@Test
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	@Test
	public void getLinks() throws IOException {
		
		HashMap<String, String> mp = new HashMap<String, String>();
		value = getProp("AutomationStepByStepList");
		String[] valList = value.split(":");
		for(String str : valList) {
			for(int i=0;i<getElementsListByTitle(str).size();i++) {
			mp.put(getElementsListByTitle(str).get(i).getAttribute("title"), getElementsListByTitle(str).get(i).getAttribute("href"));
			}
		}
		
		for(Entry<String, String> entry : mp.entrySet()) {
			System.out.println(entry.getKey()+"--->"+entry.getValue());
		}
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
