package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelReadUtilities;

public class HomePageTest extends BaseClass {
	HomePage hp;
	LoginPage lp ;
	ExcelReadUtilities eru = new ExcelReadUtilities();
	
  @Test(groups ={"smokeTest","regression"})// this is how we write more than one group test
  public void homePage() throws IOException {
	  lp = new LoginPage(driver);// calls constructors in java class(Login page)
	  hp = new HomePage(driver);
	  String username = eru.readStringData(1,0);
	  String password = eru.readStringData(1, 1);
	  lp.sendUserName(username);
	  lp.sendPassword(password);
	  lp.clickSignInButton();
	  hp.clickManageProductMoreInfo();
	  String expected = "List Products";
	  String actual = hp.getmanageProductPageHeading();	 
	  System.out.println(actual);
	  Assert.assertEquals(actual, expected, "::The corresponding page heading is not same");
	  
	  
  }
}
