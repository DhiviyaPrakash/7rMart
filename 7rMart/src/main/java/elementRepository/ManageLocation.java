package elementRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

public class ManageLocation {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();
	String location;

	public ManageLocation(WebDriver driver) // constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory

	}
	@FindBy(xpath = "//i[@class ='nav-icon fas fa-map-marker']") // WIth PageFactory
	WebElement manageLocation;
	@FindBy(xpath = "//a[@class = 'btn btn-rounded btn-danger']") 
	WebElement newbutton;
	@FindBy(xpath = "//select[@id ='country_id']") 
	WebElement countryField;
	@FindBy(id = "st_id") 
	WebElement stateField;
	@FindBy(xpath = "//input[@id='location']") 
	WebElement locationField;
	@FindBy(xpath = "//input[@id='delivery']") 
	WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@class='btn btn-danger']") 
	WebElement saveButton;
	@FindBy(xpath = "//div[@class ='alert alert-success alert-dismissible']") 
	WebElement alertSucessMessage;
	
	public void clickManageLocation() {
		manageLocation.click();
	}
	public void clickNewButton() {
		newbutton.click();
	}
	public void countryFieldDropdown()
	{
		gu.selectByValueFromDropdown(countryField, "230");
	}
	public void stateFieldDropdown()
	{
		gu.selectByVissibleText(stateField, "London");
	}
	public void sendLocationField()
	{
		String location ="Abcd"+gu.generateCurrentDateAndTime();
		this.location = location;
		gu.sendKeyFunction(locationField,location );
		
	}
	public String getRandomlyCreatedLocation()
	{
		return location ;
	}
	public void sendDeliveryChargeField()
	{
		gu.sendKeyFunction(deliveryChargeField, "100");
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	public void getAlertsucessMsg()
	{
		System.out.println(alertSucessMessage.getText());
	}
	public String getTextOfManageLocationTable(int row, int column)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
	        WebElement element=driver.findElement(By.xpath(tableElementPath));
	        return element.getText();
	        }


}
