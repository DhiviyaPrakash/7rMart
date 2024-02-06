package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageLocation;
import utilities.ExcelReadUtilities;
import utilities.GeneralUtilites;
import utilities.WaitUtilities;

public class ManageLocationTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	ManageLocation ml;
	ExcelReadUtilities eru = new ExcelReadUtilities();
	

	@Test
	public void tc01_VerifyAddNewLocation() throws Exception {
		lp = new LoginPage(driver);// calls constructors in java class(Login page)
		hp = new HomePage(driver);
		ml = new ManageLocation(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		ml.clickManageLocation();
		ml.clickNewButton();
		ml.countryFieldDropdown();
		ml.stateFieldDropdown();
		ml.sendLocationField();
		String expected = ml.getRandomlyCreatedLocation();
		ml.sendDeliveryChargeField();
		ml.clickSaveButton();
		ml.getAlertsucessMsg();
		ml.clickManageLocation();
		//System.out.println(expected);
		String actual = ml.getTextOfManageLocationTable(1, 1);
		// System.out.println(actual);
		Assert.assertEquals(actual, expected, Constants.ml_VerifyAddNewLocationErrorMessage);

	}

	@Test
	public void tc02_SearchLocationInListVerify() throws Exception {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		ml = new ManageLocation(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		ml.clickManageLocation();
		String text = ml.getTextOfManageLocationTable(1, 1);
		ml.clickManageLocationSearchButton();
		ml.selectSearchLocationCountryDropdown();
		ml.sendValueToSearchLocationLocationField(text);
		ml.clickSearchLocationSearchButton();
		String expected = text;
		String actual = ml.getTextOfManageLocationTable(1, 1);
		System.out.println(expected);
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "::Searched Location not found");

	}
	@Test
	public void tc03_EditLoctionVerify() throws Exception
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		ml = new ManageLocation(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		ml.clickManageLocation();
		ml.clickEditButtoninManageLocationTable(1);
		ml.sendValuetoEditDeliveryChargeField();
		ml.clickUpdateButton();
		String expected ="×\n"
				+ "Alert!\n"
				+ "Location Updated Successfully";
		//String actual =ml.getValueOfDeliveryCharge(1);
		String actual = ml.getUpdateSuccessMessage();
		Assert.assertEquals(actual, expected, "::Updated Success message dosen't match");
		
		
	}
	@Test
	public void tc04_DleteLocationAndVerifyBySearch() throws IOException
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		ml = new ManageLocation(driver);
		String username = eru.readStringData(1, 0);
		String password = eru.readStringData(1, 1);
		lp.sendUserName(username);
		lp.sendPassword(password);
		lp.clickSignInButton();
		ml.clickManageLocation();
		String text = ml.getTextOfManageLocationTable(1, 1);
		ml.clickDeleteButtoninManageLocationTable(1);
		ml.alertWait();
		ml.deleteAlertAccept();
		ml.getAlertsucessMsg();
		ml.clickManageLocationSearchButton();
		ml.selectSearchLocationCountryDropdown();
		ml.sendValueToSearchLocationLocationField(text);
		ml.clickSearchLocationSearchButton();
		String expected = ".........RESULT NOT FOUND.......";
		String actual = ml.getDeletedSearchresult();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "::The loction is not deleted from table");
		}
	
}
