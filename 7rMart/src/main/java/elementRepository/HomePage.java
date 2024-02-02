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
	@FindBy(xpath = "//li[text() = 'Dashboard']")
	WebElement heading;
	
	public String getHomePageHeading() {
		//return heading.getText();
		return gu.getElementText(heading);
		
	}

}
