package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;
import utilities.ExcelUtility;

public class Living extends BasePage{

	public Living(WebDriver driver) {
		super(driver);
	}
	
	Actions act;
	
	JavascriptExecutor js;
	
	//Elements
	
	@FindBy(xpath="(//a[@class='inherit contact-channel'])[1]")
	WebElement Help;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']")
	WebElement LivingEle;
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']//a[@rel='nofollow']")
	List<WebElement> SeatingChairs;
	
	
	@FindBy(xpath="(//li[@class='topnav_item livingunit']//li[@class='sublist_item'])[2]//a")
	List<WebElement> Tables;
	
	
	@FindBy(xpath="(//li[@class='topnav_item livingunit']//li[@class='sublist_item'])[3]//a")
	List<WebElement> LivingStorage;
	
	@FindBy(xpath="")
	WebElement SortBy;
	
	@FindBy(xpath="//figure[@class='header__topBar_logo']")
	WebElement Logo;

	@FindBy(xpath="//a[text()=' Gift Cards ']")
	WebElement GiftCards;
	
	//Action Methods
	
	public void scrollUp() {
		
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Help);
	}
	
	public void moveToLiving() {
		
		act = new Actions(driver);
		
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(20),LivingEle);
		
		act.moveToElement(LivingEle).build().perform();
	}
	
	public void printSeatingChairs() throws IOException {
		
		int row=1;
		for(WebElement options : SeatingChairs) {
			
			BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(10),options);
			System.out.println(options.getText());
			ExcelUtility.write("Sheet2",row,1,options.getText());
			row++;
		}
		System.out.println();
		System.out.println("**********");
		
	}
	
	public void printTables() throws IOException {
		
		int row=1;
		for(WebElement options : Tables) {
			
			BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(10),options);
			System.out.println(options.getText());
			ExcelUtility.write("Sheet2",row,2,options.getText());
			row++;
		}
		System.out.println();
		System.out.println("**********");
	}
	
	public void printLivingStorage() throws IOException {
		
		int row=1;
		for(WebElement options : LivingStorage) {
			
			BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(10),options);
			System.out.println(options.getText());
			ExcelUtility.write("Sheet2",row,3,options.getText());
			row++;
		}
		System.out.println();
		System.out.println("**********");
		
	}
	
	public void clickGiftCards() {
		
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",GiftCards);
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(10),GiftCards);
		GiftCards.click();
	}
	
}
