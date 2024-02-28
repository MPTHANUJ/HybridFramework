package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UrbanLadderHomePage extends BasePage{

	public UrbanLadderHomePage(WebDriver driver) {
		
		super(driver);
	} 

	// Elements
	
	@FindBy(id="search")
	WebElement searchBox;
	
	//Action Methods
	
	public void search_BookShelves(String br) {
		
		searchBox.sendKeys(br);
		searchBox.sendKeys(Keys.ENTER);
	}
}
