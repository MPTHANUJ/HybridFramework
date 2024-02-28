package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;

public class GiftCards extends BasePage{

	public GiftCards(WebDriver driver) {
		super(driver);
	}
	
	JavascriptExecutor js;
	
	//Elements
	
	@FindBy(xpath="//h2[text()='1. First, choose an occasion']")
	WebElement Birthday;
	
	@FindBy(xpath="//h3[text()='Birthday/Anniversary']")
	WebElement Scroll;
	
	@FindBy(xpath="(//button[text()='Choose this'])[3]")
	WebElement Choose;
	
	@FindBy(xpath="(//div[@class='_3jn98 _23tqD _3k9Vm']/button)[3]")
	WebElement Price;
	
	@FindBy(xpath="(//select[@class='Upz18 _1hLiD UJU2v'])[1]")
	WebElement month;
	
	@FindBy(xpath="(//select[@class='Upz18 _1hLiD UJU2v'])[2]")
	WebElement date;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement Next;
	
	//Recipient
	
	@FindBy(name="recipient_name")
	WebElement RecipientName;
	
	@FindBy(name="recipient_email")
	WebElement RecipientEmail;
	
	@FindBy(name="recipient_mobile_number")
	WebElement RecipientMobilenum;
	
	//From
	
	@FindBy(name="customer_name")
	WebElement Name;

	@FindBy(name="customer_email")
	WebElement Email;
	
	@FindBy(name="customer_mobile_number")
	WebElement Mobile;
	
	@FindBy(name="customer_address")
	WebElement Address;
	
	@FindBy(name="zip")
	WebElement Pincode;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Confirm;
	
	@FindBy(xpath="//h2[text()='Confirm the details']")
	WebElement ConfirmStatus;
	
	//Action Methods
	
	public void scrollToBirthday() {
		
		js=(JavascriptExecutor) driver;
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(20),Birthday);
		js.executeScript("arguments[0].scrollIntoView();",Birthday);
	}
	
	public void clickBirthday() {
		
		
		Actions act = new Actions(driver);
		
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(10),Scroll);
		
		act.moveToElement(Scroll).click(Choose).build().perform();
		
		
	}
	
	public void clickPrice() {
		
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(10),Scroll);
		Price.click();
	}
	
	public void Customize() {
		
		Select drpmonth = new Select(month);
		drpmonth.selectByValue("4/2024");
		
		Select drpdate = new Select(date);
		drpdate.selectByVisibleText("10");
	}
	
	public void clickNext() {
		
		Next.click();
	}
	
	public void EnterRecipientName(String RName) {
		
		RecipientName.sendKeys(RName);
	}
	
	public void EnterRecipientEmail(String REmail) {
		
		
		RecipientEmail.sendKeys(REmail);
	}
	
	public void EnterRecipientMobilenum(String RMobile) {
		
		RecipientMobilenum.sendKeys(RMobile);
	}
	
	public void EnterSenderName(String SName) {
		
		Name.sendKeys(SName);
	}
	
	public void EnterSenderEmail(String SEmail) {
		
		Email.sendKeys(SEmail);
	}
	
	public void EnterSenderMobile(String SMobile) {
		
		Mobile.sendKeys(SMobile);
	}
	
	public void EnterSenderAddress(String SAddress) {
		
		Address.sendKeys(SAddress);
	}
	
	public void EnterSenderPincode(String SPincode) {
		
		Pincode.sendKeys(SPincode);
	}
	
	public void clickConfirm() {
		
		Confirm.click();
	}
	
	public void getConfirmation() {
		
		js=(JavascriptExecutor) driver;
		BaseClass.ExplicitilyWait(driver,Duration.ofSeconds(20),ConfirmStatus);
		js.executeScript("arguments[0].scrollIntoView();",ConfirmStatus);
	}
	
	public void cleartextBox() {
		
		RecipientName.clear();
		RecipientEmail.clear();
		RecipientMobilenum.clear();
		Name.clear();
		Email.clear();
		Mobile.clear();
		Address.clear();
		Pincode.clear();
	}
	
	public String getErrorMsg() {
		
		return Email.getAttribute("validationMessage");
	}
}

