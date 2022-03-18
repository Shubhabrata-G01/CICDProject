package com.CICDAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	WebDriver driver = null;
	
	public WebDriver openChrome() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shubh\\OneDrive\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver(); 
	return driver;
	}
	
	public WebElement getElementByTitle(String title) {
		WebElement ele =driver.findElement(By.xpath("//a[@title='"+title+"']"));
		return ele;
	}
	
	public List<WebElement> getElementsListByTitle(String titleList) {
		List<WebElement> eleList = driver.findElements(By.xpath("//h3[contains(text(),'"+titleList+"')]/..//ul//li//a"));
		return eleList;
	}
	
	public String getProp(String key) throws IOException {
		File file = new File("C:\\Users\\shubh\\eclipse-workspace\\CICDAutomation\\Utility.properties");
		FileInputStream fis = new FileInputStream(file);
	
		Properties properties = new Properties();
		properties.load(fis);
		String value = properties .getProperty(key);
		return value;
	}
}
