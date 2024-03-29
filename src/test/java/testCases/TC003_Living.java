package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

import pageObjects.Living;
import testBase.BaseClass;

public class TC003_Living extends BaseClass{

	@Test(priority=8,groups={"smoke","master"})
	public void SelectLivingSubMenu() throws InterruptedException, IOException {
		
		LV = new Living(driver);
		
		//Generating log file for the testCase - TC003
		
		logger = LogManager.getLogger(this.getClass());
		logger.info("***** Starting TC003 *****");
		
		LV.scrollUp();
		LV.moveToLiving();
		logger.info("The User checks the options available in the Living Sub Menu");
	}
	
	@Test(priority=9,groups={"smoke","master"})
	public void PrintDetailsInSubMenu() throws IOException {
		
		LV.printSeatingChairs();
		LV.printTables();
		LV.printLivingStorage();
		logger.info("The User prints the details available in the Living sub menu");
		
	}
	
	@Test(priority=10,groups={"regression","master"})
	public void SelectGiftCards() {
		
		LV.clickGiftCards();
		logger.info("The User clicks the Gift Card options");
	}
}
