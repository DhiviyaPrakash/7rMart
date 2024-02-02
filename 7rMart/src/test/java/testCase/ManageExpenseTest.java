package testCase;

import java.io.IOException;
import java.util.Set;

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

	@Test
	public void tc01_VerifyExpenseCategoryNewTitleCreation01() throws Exception {
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

	 @Test(groups = "smokeTest")
	public void tc02_AddNewExpenseVerification02() throws Exception {
		lp = new LoginPage(driver);// calls constructors in java class(Login page)
		hp = new HomePage(driver);// calls constructor in home page java class
		me = new ManageExpense(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		me.clickManageExpense();
		me.clickManageExpensePage();
		me.clickManageExpenseNewButton();
		String userText = me.selectUserDropdown();
		me.sendDate();
		String categoryText = me.selectCategoryDropdown();
		String expected =categoryText+" "+(userText) ;
		me.selectorderDropdown();
		me.selectPurchaseIdDropdown();
		me.selectExpenseType();
		me.sendAmountField();
		me.choosefileUpload();
		me.pageScroll();
		me.saveButtonWait();
		me.clickNewSaveButton();
		me.getSucessAlertMessage();
		 System.out.println(expected);
		me.listExpensetablepage();
		String actual = me.getTextOfExpenseCategoryTable(1, 1);
		System.out.println(actual);
		
	}
	 @Test(groups = "smokeTest")
	 public void tc03_SearchDataInExpenseTable() throws Exception
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
			me.sendDatetoDateFromField();
			me.sendDateToDateToField();
			me.pageScroll();
			me.clickSearchButtonInSearchListPage();
			Thread.sleep(10000);
			me.pageScroll();
			Thread.sleep(10000);
			me.getTextOfListExpenseTable(1, 1);
			me.clickViewMoreInExpenseTable(1);
			me.pageScroll();
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
			me.fluentWaitClickforreportBackButton();
			me.clickReportBackButton();
			me.multipleTabHandelling();
		}


	@Test(groups = "smokeTest")
	public void tc04_EditExpenseSavedData03() throws Exception {
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
		String expected = me.getTextOfExpenseCategoryTable(1, 1);
		me.clickEditButtonInExpenseTable(1);
		me.updateUserDropdown();
		me.pageScroll();
		me.clickUpdateButton();
		me.getUpdateAlertMessage();
		me.listExpensetablepage();
		String actual = me.getTextOfExpenseCategoryTable(1, 1);
		System.out.println(expected);
		System.out.println(actual);
		Assert.assertNotEquals(actual, expected);

	}
	@Test(groups = "smokeTest")
	public void tc05_DeleteExpenseSavedDatainTable() throws Exception
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
		String expected = "Alert!\n"
				+ "Expense Record Deleted Successfully";
		me.clickDeleteButtonInExpenseTable(1);;
		me.alertWait();
		me.deleteAlertAccept();	
		String actual = me.getDeleteScucessMessage();
		Assert.assertEquals(actual, expected, "::The delete Success message doesn't match");
		
		
	}
	
	
}
