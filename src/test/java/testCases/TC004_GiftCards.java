package testCases;

import org.testng.annotations.Test;

import pageObjects.GiftCards;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_GiftCards extends BaseClass{
	
	@Test(priority=11,groups={"regression","master"})
	public void SelectGiftCard() throws InterruptedException {
		
		GC = new GiftCards(driver);
		logger.info("***** Starting TC004 *****");
		GC.scrollToBirthday();
		GC.clickBirthday();
		logger.info("The user selects the Birthday GiftCard");
	}
	
	@Test(priority=12,groups={"regression","master"})
	public void SelectPriceOfGiftCard() {
		
		GC.clickPrice();
		logger.info("The user selects the Price");
	}
	
	@Test(priority=13,groups={"regression","master"})
	public void SelectDate() {
		
		GC.Customize();
		logger.info("The user selects the Date");
		
	}
	
	@Test(priority=14,groups={"regression","master"})
	public void SelectNext() {
		
		GC.clickNext();
		logger.info("The user selects Next");

		
	}

}
