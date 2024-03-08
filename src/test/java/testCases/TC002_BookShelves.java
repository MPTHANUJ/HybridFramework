package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.BookShelves;
import testBase.BaseClass;

public class TC002_BookShelves extends BaseClass{

	@Test(priority=2,groups={"regression","master"})
	public void Closing_Popup() throws InterruptedException, IOException {
		
		BS = new BookShelves(driver);
		logger.info("***** Starting TC002 *****");
		BS.clickPopUp();
		logger.info("The PopUp is closed");
	}
	
	@Test(priority=3,groups={"smoke","master"})
	public void Select_Category() {
		
		BS.selectCategory();
		BS.selectBookShelves();
		logger.info("User selects the BookShelves from Category");
	}
	
	@Test(priority=4,groups={"smoke","master"})
	public void Select_PriceRange() {
		
		BS.selectPrice();
		BS.selectPriceRange();
		logger.info("User selects the Price range from the Slider");
		
	}
	
	@Test(priority=5,groups={"smoke","master"})
	public void SelectoutOfStock() {
		
		BS.selectoutOfStock();
		logger.info("User selects the Out Of Stock options");
		
	}
	
	@Test(priority=6,groups={"smoke","master"})
	public void SelectOrderRange() {
		
		BS.selectRecommended();
		BS.selectOrder();
		logger.info("User selects the Order from Recommended");
		
	}
	
	@Test(priority=7,groups={"smoke","master"})
	public void PrintProductDetails() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		BS.printProductInfo();
		logger.info("User prints the details of First three Products");
	}
}
