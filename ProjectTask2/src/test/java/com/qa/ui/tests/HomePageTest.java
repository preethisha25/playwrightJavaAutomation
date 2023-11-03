package com.qa.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.factory.PlaywrightFactory;
import com.qa.pages.HomePage;

public class HomePageTest {
	PlaywrightFactory pf;
	Page page;
	HomePage homePage;

	@BeforeTest
	public void setup() {
		pf= new PlaywrightFactory();
		page=pf.initBrowser("chrome");
		homePage = new HomePage(page);
		
	}
	
	
	@Test(priority=1)
	public void login() {
		homePage.loginSaucedemo("standard_user", "secret_sauce");
	}
	
	@Test(priority=2)
	public void addcartItem() {
		homePage.addCart();
	}
	
	@Test(priority=3)
	public void checkoutItem() {
		homePage.checkout("Swapnil", "Sharma", "411057");
	}
	
	@Test(priority=4)
	public void OverViewItem() {
		homePage.overview();
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
