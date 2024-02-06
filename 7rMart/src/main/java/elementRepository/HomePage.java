package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

public class HomePage {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();
	

	public HomePage(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory

	}
	@FindBy(xpath = "//div[@class='col-sm-6']//h1")
	WebElement manageProductPageHeading;
	@FindBy(xpath = "//section//div//div//div[5]//a[@class ='small-box-footer']")
	WebElement manageProductMoreInfo;
	
	
	public void clickManageProductMoreInfo()
	{
		manageProductMoreInfo.click();
	}
	public String getmanageProductPageHeading() {
		return gu.getElementText(manageProductPageHeading);
		
	}

}
