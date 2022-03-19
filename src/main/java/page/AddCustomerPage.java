package page;


	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
import org.testng.Assert;

	public class AddCustomerPage extends BasePage {
	
		WebDriver driver;
		
		public AddCustomerPage(WebDriver driver) {
			this.driver = driver;
		}

		// Element Liberary
		@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'Add Contact')]")
		WebElement ADD_CONTACT_HEADER_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
		WebElement FULL_NAME_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
		WebElement COMPANY_NAME_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
		WebElement EMAIL_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
		WebElement PHONE_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
		WebElement ADDRESS_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
		WebElement CITY_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
		WebElement STATE_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
		WebElement ZIP_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
		WebElement COUNTRY_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
		WebElement SUBMIT_BUTTON_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/a")
		WebElement SUMMARY_ON_PROFILE_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"application_ajaxrender\"]/a")
		WebElement PROFILE_CUSTOMER_ELEMENT;

		@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]")
		WebElement ADD_CUSTOMER_LIST_CUSTOMER_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]")
		WebElement SEARCH_BAR_LIST_CUSTOMER_ELEMENT;
		
		
		public void verifyAddContactPage() throws InterruptedException {
//			Thread.sleep(2000);
//			System.out.println("--------------------------" + ADD_CONTACT_HEADER_ELEMENT.getText());
			waitForElement(driver, 10, ADD_CONTACT_HEADER_ELEMENT);
			
			Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), "Add Contact", "Wrong Page!!!");
		}
		
		String enteredName; 
		public void insertFullName(String fullName) {
			int generatedNum = generateRandomNumber(9999);
			enteredName = fullName + generatedNum;
			FULL_NAME_ELEMENT.sendKeys(enteredName);
		}
		
		public void insertCompany(String company) {
			selectFromDropdown(COMPANY_NAME_ELEMENT, company);
		}

		public void insertEmail(String email) {
			EMAIL_ELEMENT.sendKeys(generateRandomNumber(999) + email);
		}
		
		
		public void insertPhone(String phone) {
			PHONE_ELEMENT.sendKeys(phone + generateRandomNumber(999));
		}
		
		public void insertAddress(String address) {
			ADDRESS_ELEMENT.sendKeys(address);
		}
		
		public void insertCity(String city) {
			CITY_ELEMENT.sendKeys(city);
		}
		
		public void insertState(String state) {
			STATE_ELEMENT.sendKeys(state);
		}
		
		public void insertZip(String zip) {
			ZIP_ELEMENT.sendKeys(zip);
		}
		
		public void insertCountry(String country) {
			selectFromDropdown(COUNTRY_ELEMENT, country);
		}
		
		public void clickSubmitButton() {
			SUBMIT_BUTTON_ELEMENT.click();
		}
		
		//tbody/tr[i]/td[3]
		//tbody/tr[1]/td[3]
		//tbody/tr[2]/td[3]
		//tbody/tr[3]/td[3]
		//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
		
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";
		String after_xpath_delete = "]/td[3]/following-sibling::td[4]/a[2]";
		
		public void verifyEnteredNameAndDelete() {
			
			for(int i = 1; i <= 10; i++) {
				String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
				System.out.println(name);
				Assert.assertEquals(name, enteredName, "Wrong name!!!");
				if(name.contains(enteredName)) {
					//driver.findElement(By.xpath(before_xpath + i + after_xpath_delete)).click();
				break;
				}
				
			}
			
		}
		
	}