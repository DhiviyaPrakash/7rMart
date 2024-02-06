package testCase;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpense;
import utilities.ExcelReadUtilities;

public class ManageExpenseTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	ExcelReadUtilities eru = new ExcelReadUtilities();
	ManageExpense me;
	String text;

	@Test(groups ="selenium")
	public void tc01_VerifyExpenseCategoryNewTitleCreation() throws Exception {
		lp = new LoginPage(driver);// calls constructors in java class(Login page)
		hp = new HomePage(driver);// calls constructor in home page java class
		me = new ManageExpense(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		me.clickManageExpense();
		me.clickExpenseCategory();
		me.clickExpenseCategoryNewButton();
		me.sendTitleField();
		me.clickSaveButton();
		me.getAlertText();
		String expected = me.getTitleFieldText();
		String Actual = me.getTextOfExpenseCategoryTable(1, 1);
		Assert.assertEquals(Actual, expected, Constants.me_verifyExpenseCategoryNewTitleCreationErrormessage);
	}
	@Test(groups = "new")
	public void tc02_SearchAndDeleteExpenseCategoryTitle() throws Exception
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		me = new ManageExpense(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		me.clickManageExpense();
		me.clickExpenseCategory();
		text = me.getTextOfExpenseCategoryTable(1, 1);
		//System.out.println(actual);
		me.clickExpenseCategorySearchButton();
		me.sendTitleFieldSearch(text);
      	me.clicksearchTitlePageSearchButton();
		String expected = me.getTitleFieldText();
		String actual = me.getTextOfExpenseCategoryTable(1, 1);
		Assert.assertEquals(actual, expected, "::Search item not found");
		me.clickExpenseCategoryDeleteButton(1);;
		me.alertWait();
		me.deleteAlertAccept();	
		String Expected ="×\n"
				+ "Alert!\n"
				+ "Expense Category Deleted Successfully";
		String Actual = me.getTitleDeleteScucessMessage();
		System.out.println(expected);
		System.out.println(actual);
		Assert.assertEquals(Actual, Expected, "::The Title detele success message is not same");
		
		
	}

	 @Test(groups = "selenium")
	public void tc03_AddNewExpenseVerification02() throws Exception {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		me = new ManageExpense(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		me.clickManageExpense();
		me.clickManageExpensePage();
		me.clickManageExpenseNewButton();
		me.selectUserDropdown();
		me.sendDate();
		me.selectCategoryDropdown();
		String expected ="Fruits1717947384 (User-DB)" ;
		me.selectorderDropdown();
		me.selectPurchaseIdDropdown();
		me.selectExpenseType();
		me.sendAmountField();
		Thread.sleep(1000);
		me.choosefileUpload();
		Thread.sleep(1000);
		me.pageScroll();
		me.saveButtonWait();
		me.clickNewSaveButton();
		me.getSucessAlertMessage();
		System.out.println(expected);
		me.listExpensetablepage();
		String actual = me.getTextOfExpenseCategoryTable(1, 1);
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "::Created one is not As expected");
		
	}
	 @Test(groups = "smokeTest")
	 public void tc04_SearchDataInExpenseTable() throws Exception
		{
			lp = new LoginPage(driver);
			hp = new HomePage(driver);
			me = new ManageExpense(driver);
			String username = eru.readStringData(1, 0);
			String password = eru.readStringData(1, 1);
			lp.sendUserName(username);
			lp.sendPassword(password);
			lp.clickSignInButton();
			me.clickManageExpense();
			me.clickManageExpensePage();
			me.clickSearchButton();
			me.selectSearchUserDropdown();
			me.selectSearchCategoryDropdown();
			Thread.sleep(1000);
			me.sendDatetoDateFromField();
			Thread.sleep(1000);
			me.sendDateToDateToField();
			me.pageScroll();
			me.clickSearchButtonInSearchListPage();
			me.pageScroll();
			Thread.sleep(1000);
			String actual= me.getTextOfListExpenseTable(1, 1);
			me.clickViewMoreInExpenseTable(1);
			me.pageScroll();
			Thread.sleep(1000);
			me.clickFileInViewMore();
			String parentWindow =driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String childWindow :allWindows)
			{
				if(!parentWindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					driver.getTitle();
					
				}
			}
			driver.switchTo().window(parentWindow);
			me.pageScroll();
			me.clickReportButton();
			
			for(String childWindow :allWindows)
			{
				if(!parentWindow.equals(childWindow))
				{
					driver.switchTo().window(childWindow);
					driver.getTitle();
					
				}
			}
			String expected ="Fruits1717947384 (User-DB)" ;
			Assert.assertEquals(actual, expected, "::search result dosen't match");
		}


	@Test(groups = "smokeTest")
	public void tc05_EditExpenseSavedData03() throws Exception {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		me = new ManageExpense(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		me.clickManageExpense();
		me.clickManageExpensePage();
		String expected = "Fruits1717947384 (Test-DB)";
		me.clickEditButtonInExpenseTable(1);
		me.updateUserDropdown();
		me.pageScroll();
		me.updateButtonwait();
		me.clickUpdateButton();
		me.getUpdateAlertMessage();
		me.listExpensetablepage();
		String actual = me.getTextOfExpenseCategoryTable(1, 1);
		System.out.println(expected);
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "::The changes made not found");

	}
	@Test(groups = "smokeTest")
	public void tc06_DeleteExpenseSavedDatainTable() throws Exception
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		me = new ManageExpense(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		me.clickManageExpense();
		me.clickManageExpensePage();
		String expected = "×\n"
				+ "Alert!\n"
				+ "Expense Record Deleted Successfully";
		me.clickDeleteButtonInExpenseTable(1);;
		me.alertWait();
		me.deleteAlertAccept();	
		String actual = me.getDeleteScucessMessage();
		Assert.assertEquals(actual, expected, "::The delete Success message doesn't match");
		
		
	}
	
	
}
