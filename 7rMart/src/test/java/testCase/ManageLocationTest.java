package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageLocation;

public class ManageLocationTest extends BaseClass {
	HomePage hp;
	LoginPage lp ;
	ManageLocation ml;
  @Test
  public void VerifyAddNewLocation() {
	  lp = new LoginPage(driver);// calls constructors in java class(Login page)
	  hp = new HomePage(driver);
	  ml = new ManageLocation(driver);
	  lp.sendUserName("Admin");
	  lp.sendPassword("admin");
	  lp.clickSignInButton();
	  ml.clickManageLocation();
	  ml.clickNewButton();
	  ml.countryFieldDropdown();
	  ml.stateFieldDropdown();
	  ml.sendLocationField();
	  String expected =ml.getRandomlyCreatedLocation();
	  ml.sendDeliveryChargeField();
	  ml.clickSaveButton();
	  ml.getAlertsucessMsg();
	  ml.clickManageLocation();
	  System.out.println("Table read:"+ml.getTextOfManageLocationTable(1, 1)); 
	  //System.out.println();
	  System.out.println(expected);
	  String actual =ml.getTextOfManageLocationTable(1, 1);
	  //System.out.println(actual);
	  Assert.assertEquals(actual, expected,Constants.ml_VerifyAddNewLocationErrorMessage);
	  
  }
}
