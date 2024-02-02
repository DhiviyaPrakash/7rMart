package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTest extends BaseClass {
	HomePage hp;
	LoginPage lp ;
	
  @Test(groups ={"smokeTest","regression"})// this is how we write more than one group test
  public void homePage() {
	  lp = new LoginPage(driver);// calls constructors in java class(Login page)
	  hp = new HomePage(driver);
	  lp.sendUserName("Admin");
	  lp.sendPassword("admin");
	  lp.clickSignInButton();
	  System.out.println( hp.getHomePageHeading());
	  
	  
  }
}
