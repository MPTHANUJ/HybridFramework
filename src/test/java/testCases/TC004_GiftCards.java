package testCases;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import pageObjects.GiftCards;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_GiftCards extends BaseClass{
	
	@Test(priority=11,groups={"smoke","master"})
	public void SelectGiftCard() throws InterruptedException {
		
		GC = new GiftCards(driver);
		
		//Generating log file for the testCase - TC004
		
		logger = LogManager.getLogger(this.getClass());
		logger.info("***** Starting TC004 *****");
		
		GC.scrollToBirthday();
		GC.clickBirthday();
		logger.info("The user selects the Birthday GiftCard");
	}
	
	@Test(priority=12,groups={"smoke","master"})
	public void SelectPriceOfGiftCard() {
		
		GC.clickPrice();
		logger.info("The user selects the Price");
	}
	
	@Test(priority=13,groups={"smoke","master"})
	public void SelectDate() {
		
		GC.Customize();
		logger.info("The user selects the Date");
		
	}
	
	@Test(priority=14,groups={"smoke","master"})
	public void SelectNext() {
		
		GC.clickNext();
		logger.info("The user selects Next");

		
	}

}
