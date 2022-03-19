package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;

	ExcelReader exlRead = new ExcelReader("testData\\tfxl.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String fullName = exlRead.getCellData("AddContact", "FullName", 2);
	String companyName = exlRead.getCellData("AddContact", "CompanyName", 2);
	String email = exlRead.getCellData("AddContact", "Email", 2);
	String phone = exlRead.getCellData("AddContact", "Phone", 2);
	String address = exlRead.getCellData("AddContact", "Address", 2);
	String city = exlRead.getCellData("AddContact", "City", 2);
	String state = exlRead.getCellData("AddContact", "State", 2);
	String zip = exlRead.getCellData("AddContact", "Zip", 2);
	String country = exlRead.getCellData("AddContact", "Country", 2);
	
	@Test
	public void validUserShouldBeAbleToCreateCustomer() throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.varifyDashbardHeader();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.insertCountry(country);
		addCustomerPage.clickSubmitButton();
		dashboardPage.clickListCustomerButton();
		addCustomerPage.verifyEnteredNameAndDelete();

	}

}