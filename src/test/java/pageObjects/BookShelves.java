package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;
import utilities.ExcelUtility;

public class BookShelves extends BasePage{

	public BookShelves(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
	Actions act;
	JavascriptExecutor js;
	
	//Elements
	
	@FindBy(xpath="//a[@class='close-reveal-modal hide-mobile']")
	WebElement closePop;
	
	@FindBy(xpath="//li[@data-group='category']/div[@class='gname']")
	WebElement Category;
	
	@FindBy(xpath="//input[@value='Kids Bookshelves']")
	WebElement KidsBookshelves;
	
	@FindBy(xpath="//li[@data-group='price']/div[@class='gname']")
	WebElement Price;
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	WebElement PriceRange;
	
	@FindBy(xpath="//div[@class='option']")
	WebElement OutOfStock;
	
	@FindBy(xpath="//span[text()='Recommended']")
	WebElement Recommended;
	
	@FindBy(xpath="//li[text()='Price: High to Low']")
	WebElement OrderRange;
	
	@FindBy(xpath="//span[@class='name']")
	List<WebElement> ProductInfo;
	
	@FindBy(xpath="//div[@class='price-number']//span")
	List<WebElement> ProductPrice;
	
	
	//Action Methods
	
	public void clickPopUp() {
		
		try {
			BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(20),closePop);
			closePop.click();
		}
		catch(Exception e) {
			
		}
	}
	
	public void selectCategory() {
		
		act = new Actions(driver);
		
		act.moveToElement(Category).build().perform();
	}
	
	public void selectBookShelves() {
		
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(20),KidsBookshelves);
		KidsBookshelves.click();
	}
	
	public void selectPrice() {
		
		act = new Actions(driver);
		
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(20),Price);
		
		act.moveToElement(Price).build().perform();
	}
	
	public void selectPriceRange() {
		
		act = new Actions(driver);
		
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(30),PriceRange);
		
		act.moveToElement(PriceRange).click().dragAndDropBy(PriceRange,-212,0).perform();
	}

	public void selectoutOfStock() {
		

		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(20),OutOfStock);
		
		OutOfStock.click();
	}
	
	public void selectRecommended() {
		
		act = new Actions(driver);
		
		act.moveToElement(Recommended).build().perform();
	}
	
	public void selectOrder() {
		
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(10),OrderRange);
		
		OrderRange.click();
	}
	
	public void printProductInfo() throws IOException {
		
		String data="";
		int row =1;
		int col=0;
		for(int i=0;i<=2;i++) {
			
			System.out.println("Product Name: "+ ProductInfo.get(i).getText());
			System.out.println( "Price: "+ProductPrice.get(i).getText());
			System.out.println();
			System.out.println("*********");
			data=ProductInfo.get(i).getText()+":"+ProductPrice.get(i).getText();
			ExcelUtility.write("Sheet2", row, col, data);
			row++;
		}
	}
}
