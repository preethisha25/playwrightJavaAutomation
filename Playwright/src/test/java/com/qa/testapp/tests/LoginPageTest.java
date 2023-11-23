package com.qa.testapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testapp.base.BaseTest;

public class LoginPageTest extends BaseTest {

		
	
		@Test(priority =1)
		public void LoginPageTitleTest() {
			String actualTitle = loginPage.getLoginPageTitle();
			Assert.assertEquals(actualTitle, "Swag Labs");
			
		}
		
		@Test(priority =2)
		public void LoginPageUrlTest() {
			String actualURL = loginPage.getLoginPageUrl();
			Assert.assertEquals(actualURL,"https://www.saucedemo.com/" );
		}
		@Test(priority=3)
		public void Login() {
			String resultHeader =loginPage.Login(prop.getProperty("UName"),prop.getProperty("Pwd"));
			
			Assert.assertEquals(resultHeader, "Products");
			
		}
		
		@Test(priority =4)
		public void navigateToYourCartTest() {
			 String checkoutPageTitle = loginPage.navigateToYourInfo();
			 Assert.assertEquals(checkoutPageTitle, "Checkout: Your Information");
			}
		
	
		
		@Test(priority = 5)
		public void CheckOutInfoDetailsTest() {
		String taxValue = loginPage.CheckOutInfoDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zcode"));
		
		Assert.assertEquals(taxValue, "Tax: $2.40");



}
}


