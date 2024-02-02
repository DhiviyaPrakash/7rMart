package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtilities;
import utilities.GeneralUtilites;
import utilities.WaitUtilities;

public class ManageExpense {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();
	WaitUtilities wu = new WaitUtilities();
	FileUploadUtilities fu = new FileUploadUtilities();
	String text;
	public ManageExpense(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//i[@class='fas fa-angle-left right']")
	WebElement manageExpense;
	@FindBy(xpath = "//a[@class='nav-link']//p [text() = 'Expense Category']")
	WebElement expenseCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement expenseCategoryNewButton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement titleField;
	@FindBy(xpath = "//div//button[@name='Create']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertText;
	@FindBy(xpath = "//ul//a[@class='nav-link']//p [text() = 'Manage Expense']")
	WebElement manageExpensePage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement manageExpenseNewButton;
	@FindBy(xpath = "//select[@id='user_id']")
	WebElement userDropdown;
	@FindBy(id = "ex_date")
	WebElement date;
	@FindBy(xpath = "//select[@id ='ex_cat']")
	WebElement categoryDropdown;
	@FindBy(xpath = "//select[@id ='order_id']")
	WebElement orderIdDropdown;
	@FindBy(xpath = "//select[@id ='purchase_id']")
	WebElement purchaseIdDropdown;
	@FindBy(xpath = "//select[@id ='ex_type']")
	WebElement expenseTypeDropdown;
	@FindBy(xpath = "//input[@id ='amount']")
	WebElement amountField;
	@FindBy(xpath = "//input[@name ='userfile']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@class ='btn btn-danger']")
	WebElement newSaveButton;
	@FindBy(xpath = "//div[@class ='alert alert-success alert-dismissible']//h5")
	WebElement sucessAlertMessage;
	@FindBy(xpath = "//a[@class='active nav-link']")
	WebElement listExpensePage;
	@FindBy(xpath = "//button[@class ='btn btn-danger']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateAlertMessage;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteSucessAlertMessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//select[@id='um']")
	WebElement searchUserDropdown;
	@FindBy(xpath = "//select[@id='uc']")
	WebElement searchcategoryDropdown;
	@FindBy(xpath = "//input[@id='f_dat']")
	WebElement searchDateFromField;
	@FindBy(xpath = "//input[@id='t_dat']")
	WebElement searchDateToField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButtonInSearchList;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-info']")
	WebElement reportButton;
	@FindBy(xpath = "//span[@id='back']//a")
	WebElement reportBackButton;
	
	
	
	public void clickManageExpense()
	{
		manageExpense.click();
	}
	public void clickExpenseCategory() 
	{
		expenseCategory.click();
	}
	public void clickExpenseCategoryNewButton()
	{
		expenseCategoryNewButton.click();
	}
	public void sendTitleField()
	{
		String text = "ABCD"+gu.generateCurrentDateAndTime();
		this.text = text;
		gu.sendKeyFunction(titleField,text );
	}
	public String getTitleFieldText()
	{
		return text;
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	public void getAlertText()
	{
	  System.out.println(alertText.getText());
	}
	public String getTextOfExpenseCategoryTable(int row, int column)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
	        WebElement element=driver.findElement(By.xpath(tableElementPath));
	        return element.getText();
	 }
	public void clickManageExpensePage()
	{
		manageExpensePage.click();
	}
	public void clickManageExpenseNewButton()
	{
		manageExpenseNewButton.click();
	}
	public String selectUserDropdown()
	{
		String selectedValue = gu.selectByValueFromDropdown(userDropdown, "25");
		return selectedValue;
	}
	
	public void datefieldwait() 
	{
		wu.explicitWait(driver,date, "id", "ex_date");
	}
	public void sendDate()
	{
		date.clear();
		gu.sendKeyFunction(date, "29-02-2024");
	}
	public String selectCategoryDropdown()
	{
		String selectedValue =gu.selectByIndexFromDropdown(categoryDropdown,5);
		return selectedValue;
	}
	
	public void selectorderDropdown()
	{
		gu.selectByValueFromDropdown(orderIdDropdown, "7");
		
	}
	public void selectPurchaseIdDropdown()
	{
		gu.selectByValueFromDropdown(purchaseIdDropdown, "15");
	}
	public void selectExpenseType()
	{
		gu.selectByValueFromDropdown(expenseTypeDropdown, "cb");
	}
	public void sendAmountField()
	{
		gu.sendKeyFunction(amountField, "500");
	}
	public void choosefileUpload() throws Exception
	{
		fu.fileUpload(chooseFile, driver, "C:\\Users\\DhiviyaPrakash\\OneDrive\\Pictures\\download.jpg");
		
	}
	public void pageScroll()
	{
		gu.pageScroll(driver,newSaveButton);
	}
	public void saveButtonWait()
	{
		wu.fluentWait(driver,newSaveButton, "class", "btn btn-danger");
	}
	public void clickNewSaveButton()
	{
		newSaveButton.click();
	}
	
	public void getSucessAlertMessage()
	{
		System.out.println(sucessAlertMessage.getText());
	}
	public void listExpensetablepage()
	{
		listExpensePage.click();
		
	}
	public String getTextOfListExpenseTable(int row, int column)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td["+column+"]";
	        WebElement element=driver.findElement(By.xpath(tableElementPath));
	        return element.getText();
	        }
	public void clickEditButtonInExpenseTable(int row)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td[9]//a//i[@class ='fas fa-edit']";
	        WebElement element=driver.findElement(By.xpath(tableElementPath));
	        element.click();
	        
	        }
	public void updateUserDropdown()
	{
		gu.selectByValueFromDropdown(userDropdown, "12");
	}
	public void clickUpdateButton()
	{
		updateButton.click();
	}
	public void getUpdateAlertMessage()
	{
		System.out.println(updateAlertMessage.getText());
	}
	public void clickDeleteButtonInExpenseTable(int row)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td[9]//a//i[@class ='fas fa-trash-alt']";
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
	public String getDeleteScucessMessage()
	{
		System.out.println(deleteSucessAlertMessage.getText());
		return deleteSucessAlertMessage.getText();
	}
	public void clickSearchButton()
	{
		searchButton.click();
	}
	public void selectSearchUserDropdown()
	{
		gu.selectByValueFromDropdown(searchUserDropdown, "25");
	}
	public void selectSearchCategoryDropdown()
	{
		gu.selectByValueFromDropdown(searchcategoryDropdown, "408");
	}
	public void sendDatetoDateFromField()
	{
		gu.sendKeyFunction(searchDateFromField, "28-01-2024");
	}
	public void sendDateToDateToField()
	{
		gu.sendKeyFunction(searchDateToField, "15-03-2024");
	}
	public void clickSearchButtonInSearchListPage()
	{
		searchButtonInSearchList.click();
	}
	public void clickViewMoreInExpenseTable(int row)
	{
			String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+row+"]//td[8]//div[@class='action-buttons']";
	        WebElement element=driver.findElement(By.xpath(tableElementPath));
	        element.click();
	        
	        }
	
	public void clickFileInViewMore()
	{
		String tableElementPath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[2]//td//div[5][@class='col-xs-12 col-sm-12']//span//a";
        WebElement element=driver.findElement(By.xpath(tableElementPath));
        //wu.fluentWait(driver, element, tableElementPath, tableElementPath);
        element.click();
        	
	}
	public void multipleTabHandelling()
	{
		gu.multipleTabHandle(driver);
	}
	public void clickReportButton()
	{
		reportButton.click();
	}
	public void fluentWaitClickforreportBackButton()
	{
		wu.fluentWaitforClick(driver, reportBackButton);
	}
	public void clickReportBackButton()
	{
		reportBackButton.click();
	}
	
	
	

}
