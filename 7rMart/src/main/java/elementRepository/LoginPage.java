package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class LoginPage {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();

	public LoginPage(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory

	}

	@FindBy(xpath = "//input[@name ='username']") // WIth PageFactory
	WebElement userNameField;

	@FindBy(xpath = "//input[@name ='password']")
	WebElement passwordField;

	@FindBy(xpath = "//button[@type ='submit']")
	WebElement signInButton;
	@FindBy(xpath = "//div[@class ='alert alert-danger alert-dismissible']//h5")
	WebElement alertText;

	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	WebElement pageHeading;

	// By userName = By.xpath("//input[@name ='username']");//without pageFactory

	public void sendUserName(String userName) {
		//userNameField.sendKeys(userName);
		gu.sendKeyFunction(userNameField, userName);
	}

	public void sendPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickSignInButton() {
		signInButton.click();
	}

	public String getAlertText() {
	 //return alertText.getText();
	 return gu.getElementText(alertText);
	 
	}

	public String getPageheading() {
		//System.out.println("Page Heading is:" + pageHeading.getText());
		return gu.getElementText(pageHeading);

	}

}
