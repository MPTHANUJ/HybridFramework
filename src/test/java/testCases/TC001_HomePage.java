package testCases;

import org.testng.annotations.Test;

import pageObjects.UrbanLadderHomePage;
import testBase.BaseClass;

public class TC001_HomePage extends BaseClass{
	
	
	@Test(priority=1,groups={"smoke","master"})
	public void Searching_Bookshleves() throws InterruptedException{
		
		UP=new UrbanLadderHomePage(driver);
		logger.info("***** Starting TC001 *****");
		logger.info("User searches for BookShelves");
		UP.search_BookShelves(P.getProperty("text"));
		
	}
}
