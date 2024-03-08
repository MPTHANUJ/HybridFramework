package testCases;

import org.testng.annotations.Test;

import pageObjects.GiftCards;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC005_ValidatingGiftCardDetails extends BaseClass{

	@Test(priority=15,dataProvider="Details",dataProviderClass = DataProviders.class,groups={"smoke","master"})
	public void ValidatingDetails(String RName,String REmail,String RMobile,String SName,String SEmail,String SMobile,String SAddress,String SPincode,String Res) throws InterruptedException {
		
		GC = new GiftCards(driver);
		GC.EnterRecipientName(RName);
		GC.EnterRecipientEmail(REmail);
		GC.EnterRecipientMobilenum(RMobile);
		logger.info("The user enters To's Details ");
		
		
		GC.EnterSenderName(SName);
		GC.EnterSenderEmail(SEmail);
		GC.EnterSenderMobile(SMobile);
		GC.EnterSenderAddress(SAddress);
		GC.EnterSenderPincode(SPincode);
		logger.info("The user enters From's Details ");
		
		Thread.sleep(3000);
		if(Res.equalsIgnoreCase("invalid")) {
			GC.clickConfirm();
			logger.info("The user clicks confirm after entering invalid email address and checks for error message");
		}
		else if(Res.equalsIgnoreCase("valid")) {
			GC.clickConfirm();
			logger.info("The user clicks confirm after entering valid email address and checks for Confirmation");
		}
		Thread.sleep(3000);
		
		String msg=GC.getErrorMsg();
		
		if(msg.contains("Please include an '@' in the email address.")) {
			
			GC.cleartextBox();
		}
		
	}
}
