package com.nmims.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nmims.utilities.ReadConfig;

public class BaseClass {
ReadConfig readconfig=new ReadConfig();

public String url=readconfig.getUrl();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();
//public String url=readconfig.getUrl();
public static WebDriver driver;
//public String url="https://uat-studentzone-ngasce.nmims.edu/";
Logger logger;


@Parameters("browsers")
@BeforeClass
public void setup(String br) {
	logger=Logger.getLogger("nmims-automation");
	PropertyConfigurator.configure("Log4j.properties");
	
	
	if(br.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
	driver=new ChromeDriver();
	}
	
	
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
}

@AfterClass
public void tearDown() throws InterruptedException {
	Thread.sleep(10000);
	driver.quit();
}

public void captureScreen(WebDriver driver,String tname) throws IOException {
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshots taken succesfully");
}
}
