package testCase;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelReadUtilities;

public class LoginPageTest extends BaseClass {
	LoginPage lp ;
	HomePage hp;
	ExcelReadUtilities eru = new ExcelReadUtilities();
	@DataProvider (name = "LoginPageTestCrentials")
	public Object[][] dpMethod(){
	return new Object[][] { {"admin12", "admin"},{"Admin","abcd"},{"1234", "1234"} };
	}
	
  @Test(groups ="Run")
  public void verifyLoginWithValidCredentials() throws IOException {
	  lp = new LoginPage(driver);// calls constructors in java class(Login page)
	  hp = new HomePage(driver);
	  String username = eru.readStringData(1,0);
	  String password = eru.readStringData(1, 1);
	  lp.sendUserName(username);
	  lp.sendPassword(password);
	  lp.clickSignInButton();
	  lp.getPageheading();
	  String expected = "Dashboard";
	  String actual = hp.getHomePageHeading();
	  System.out.println(actual);
	  Assert.assertEquals(actual, expected, Constants.lp_verifyLoginWithValidCredentialsErrorMessage);
	  
  }
  @Test(dataProvider = "LoginPageTestCrentials")
  public void verifyLoginWithInValidCredentials(String userName, String password)
  {
	  lp = new LoginPage(driver);// calls constructors in java class(Login page)
	  lp.sendUserName(userName);
	  lp.sendPassword(password);
	  lp.clickSignInButton(); 
	  String expected = "Alert!";
	  String actual = lp.getAlertText();
	  System.out.println(expected);
	  System.out.println(actual);
	  Assert.assertEquals(actual, expected, Constants.lp_verifyLoginWithInValidCredentialsErrorMessage);

	  
  }
}
