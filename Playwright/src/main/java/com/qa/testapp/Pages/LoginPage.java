package com.qa.testapp.Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	//1. String Locators- Object Repository
			private Page page;
			
			private String username = "//input[@id='user-name']";
			private String password = "//input[@id='password']";
			private String loginbutton = "//input[@id='login-button']";
			private String resultHeader = "//span[@class='title']";
			private String AddtoCartbutton ="//button[@id='add-to-cart-sauce-labs-backpack']";
			private String yourCartIcon ="//a[@class=\"shopping_cart_link\"]";
			private String checkoutbutton ="//button[@id='checkout']";
			private String firstName = "//input[@id='first-name']";
			private String lastName ="//input[@id='last-name']";
			private String zipCode ="//input[@id='postal-code']";
			private String continuebutton ="//input[@id='continue']";
			private String checkoutPageTitle ="//span[contains(text(),'Checkout: Your Information')]";
			
			//2. Page Constructor
			
			public LoginPage(Page page) {
				this.page=page;
			}
			
			//3. Page actions/methods:
			
			public String getLoginPageTitle() { 
				String title = page.title();
				System.out.println("Page title :" + title);
				return page.title();
				
			}
			
			public String getLoginPageUrl() {
				
				String url = page.url();
				System.out.println("page url : " + url);
				return page.url();
			}
			
			public String Login(String UName, String Pwd) {
				page.fill(username, UName);
				page.fill(password, Pwd);
				page.click(loginbutton);
				
			return page.textContent(resultHeader);
				
				}
			
			public String navigateToYourInfo() {
				page.click(AddtoCartbutton);
				page.click(yourCartIcon);
				page.click(checkoutbutton);
				return page.textContent(checkoutPageTitle);
				
				}
			

			public String CheckOutInfoDetails(String f_Name, String L_Name, String z_code) {
				page.fill(firstName, f_Name);
				page.fill(lastName, L_Name);
				page.fill(zipCode, z_code);
				page.click(continuebutton);
				page.evaluate("window.scrollTo(0, document.body.scrollHeight)");
				
				String taxValue =page.locator("text = Tax: $2.40" ).textContent();
				
			    System.out.println("Tax is calculated correctly :" + taxValue);
			
				return taxValue;
				
				
			}
			
}
			



	



