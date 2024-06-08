package com.inetBanking.testCases;




import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig re= new ReadConfig();
	public String baseURL = re.getApplicationURL();
	public String username=re.getUsername();
	public String password = re.getPassword();
	public static WebDriver driver;
	public static Logger logger;
//	public String custid;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomstring() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String randomnum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return generatedString2;
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		
		File ts  =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target  = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname+".png");
		FileUtils.copyFile( ts, target);
		System.out.print("Screenshot taken");
	}	

}
