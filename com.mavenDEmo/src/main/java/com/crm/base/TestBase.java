package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	/*Declare TestBase constructor To get config properties values */
	public TestBase() {
		try {
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\com.mavenDEmo\\src\\main\\java\\com\\crm\\config\\config.properties");
		prop.load(ip);
		}catch(FileNotFoundException f)
		{
			f.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/* Method to launch the Browser*/
	public static void initialization() {
		String browser_name=prop.getProperty("browser");
		
		if(browser_name.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser_name.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		/*navigate to specified application url*/
		driver.get(prop.getProperty("url"));
	}

}
