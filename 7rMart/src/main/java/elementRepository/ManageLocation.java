package elementRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;
import utilities.WaitUtilities;

public class ManageLocation {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();
	WaitUtilities wu = new WaitUtilities();
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
	@FindBy(xpath = "//div[@class='col-sm-12']//a[2]") 
	WebElement manageLocationSearchButton;
	@FindBy(xpath = "//select[@id='country_id']") 
	WebElement searchLocationCountryField;
	@FindBy(xpath = "//input[@id='location']") 
	WebElement searchLocationLocationField;
	@FindBy(xpath = "//button[@value='sr']") 
	WebElement searchLocationSearchButton;
	@FindBy(xpath = "//input[@id='delivery']") 
	WebElement editDeliveryChargeField;
	@FindBy(xpath = "//button[@class='btn btn-danger']") 
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	WebElement updateSuccessMessage;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	WebElement deleteSuccessMessage;
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
	public void clickManageLocationSearchButton()
	{
		manageLocationSearchButton.click();
	}
	public void selectSearchLocationCountryDropdown()
	{
		gu.selectByValueFromDropdown(searchLocationCountryField, "230");
	}
	public void sendValueToSearchLocationLocationField(String text)
	{
		this.location = text;
		gu.sendKeyFunction(searchLocationLocationField, text);
		
	}
	public void clickSearchLocationSearchButton()
	{
		searchLocationSearchButton.click();
	}
	public void clickEditButtoninManageLocationTable(int row)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td[6]//a//i[@class='fas fa-edit']";
	        WebElement element=driver.findElement(By.xpath(tableElementPath));
	        element.click();
	        }
	public void sendValuetoEditDeliveryChargeField()
	{
		editDeliveryChargeField.clear();
		gu.sendKeyFunction(editDeliveryChargeField, "500");
	}
	public void clickUpdateButton()
	{
		updateButton.click();
	}
	public String getValueOfDeliveryCharge(int row)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td[4]";
	        WebElement element=driver.findElement(By.xpath(tableElementPath));
	        return element.getText();
	        }
	public String getUpdateSuccessMessage()
	{
		System.out.println(updateSuccessMessage.getText());
		return updateSuccessMessage.getText();
	}
	public void clickDeleteButtoninManageLocationTable(int row)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td[6]//a//i[@class='fas fa-trash-alt']";
	        WebElement element=driver.findElement(By.xpath(tableElementPath));
	        element.click();
	        }
	public void alertWait()
	{
		wu.explicitWaitForAlert(driver);
	}
	public void deleteAlertAccept()
	{
		gu.acceptAlert(driver);
	}
	public String getDeleteLocationSuccessMessage()
	{
		System.out.println(deleteSuccessMessage.getText());
		return deleteSuccessMessage.getText();
	}
	public String getDeletedSearchresult()
	{
		String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//span";
        WebElement element=driver.findElement(By.xpath(tableElementPath));
        return element.getText();
	}
	
	
	


}
