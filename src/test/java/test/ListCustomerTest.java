package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
	WebDriver driver;
	String userName;
	String Password;

	String fullName;
	String companyName;
	String email;
	String phone;
	String address;
	String city;
	String country;
	String state;
	String zip;

	@Test
	@Parameters({ "userName", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country",
			"State", "Zip" })
	public void validUserShouldBeAbleToUseAddCustomer(String userName, String password, String fullName,
			String companyName, String email, String phone, String address, String city, String country, String state,
			String zip) {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersButton();
		dashboardPage.clickListCustomersButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomerPage();

		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.clickSaveButtonOnAddContact();

		addCustomerPage.verifySummaryPage();
		dashboardPage.clickListCustomersButton();

		addCustomerPage.insertNameOnSearchBarOnListCustomer();
		addCustomerPage.verifySearchBarAndSummaryOnListCustomer();

		addCustomerPage.verifySummaryPage();

		// addCustomerPage.verifyEnteredNameAndDelete();
		// addCustomerPage.deleteConformOk();

		BrowserFactory.tearDown();

	}

}
