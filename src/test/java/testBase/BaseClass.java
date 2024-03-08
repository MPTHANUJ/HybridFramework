package testBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageObjects.BookShelves;
import pageObjects.GiftCards;
import pageObjects.Living;
import pageObjects.UrbanLadderHomePage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	public Properties P;
	public UrbanLadderHomePage UP;
	public BookShelves BS;
	public Living LV;
	public GiftCards GC;
	
	@BeforeTest(groups= {"smoke","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		
		//Reading unchanged data from config.properties file
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		P = new Properties();
		P.load(file);
		
		//Generating log file for the testCases
		
		logger = LogManager.getLogger(this.getClass());
		
		if(P.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				
				System.out.println("No matching os.....");
				return;
			}
			
			//browser
			switch(br.toLowerCase()) {
				
				case "chrome" : capabilities.setBrowserName("chrome");break;
				case "edge" : capabilities.setBrowserName("edge");break;
				default : System.out.println("No matching browser......");break;
			}
			
			driver = new RemoteWebDriver(new URL("http://10.66.137.6:4444"),capabilities);	
			
		}
		
		else if(P.getProperty("execution_env").equalsIgnoreCase("local")) {
		
		//Handling multiple browser windows
		
		switch(br.toLowerCase()) {
		
		case "chrome": driver = new ChromeDriver();break;
		case "edge": driver = new EdgeDriver();break;
		default: System.out.println("No matching browser...");
					return;
		}
		
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//opening the application using URL
		
		driver.get(P.getProperty("appURL"));
		
		driver.manage().window().maximize();
		
	}

	@AfterTest(groups= {"smoke","regression","master"})
	public void tearDown() {
		
		driver.quit();
	}
	
	public static void ExplicitilyWait(WebDriver driver,Duration dur,WebElement element) {
		
		WebDriverWait mywait = new WebDriverWait(driver,dur);
		mywait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String captureScreen(String name) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
}
