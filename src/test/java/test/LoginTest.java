
  package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest { 
	  WebDriver driver;
		ExcelReader exlRead = new ExcelReader("testData\\tfxl.xlsx");
		String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
		String password = exlRead.getCellData("LoginInfo", "Password", 2);
		
		@Test
		public void validUserShouldBeAbleToLogin() {
			driver = BrowserFactory.init();
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.insertUserName(userName);
			loginPage.insertPassword(password);
			loginPage.clickSigninButton();
			
			DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
			dashboardPage.varifyDashbardHeader();
			
			BrowserFactory.tearDown();
			
		}

	}
 