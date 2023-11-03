package com.qa.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	Page page;
 
//Locators
	private String txt_UserName ="//input[@id='user-name']"; 
	private String txt_Password ="//input[@id='password']"; 
	private String btn_Login ="//input[@id='login-button']";
	
	//Select item page
	private String btn_AddToCart="(//button[contains(text(),'Add to cart')])[1]";
	private String logo_cart="//div[@id='shopping_cart_container']";
	private String btn_Checkout="//button[@id='checkout']";
	
	//checkout page
	private String txt_Firstname="//input[@id='first-name']";
	private String txt_Lastname="//input[@id='last-name']";
	private String txt_PostalCode="//input[@id='postal-code']";
	private String btn_Continue="//input[@id='continue']";
	
	//checkout overview page for validation
	private String lbl_ItemTotal="//div[contains(text(),'Item total')]";
	private String lbl_Tax="//div[contains(text(),'Tax')]";
	private String lbl_Total="//div[contains(text(),'Total: $')]";
	//private String btn_Finish="//button[@id='finish']";
	
//page constructor
	public HomePage(Page page) {
		this.page = page;
	}
	
	
//page methods
	
	public void loginSaucedemo(String UserID, String Password)  {
		page.fill(txt_UserName,UserID);
		page.fill(txt_Password,Password);
		page.waitForSelector(btn_Login);
		page.click(btn_Login);
	}
	
	
	public String getHomeTitle() {
		return page.title();
	}
	
	public String getHomeURL() {
		return page.url();
	}
	
	public void addCart() {
		page.waitForSelector(btn_AddToCart);
		page.click(btn_AddToCart);
		page.click(logo_cart);
		page.click(btn_Checkout);
	}
	
	public void checkout(String FName, String LName, String PCode) {
		page.waitForSelector(txt_Firstname);
		page.fill(txt_Firstname,FName);
		page.fill(txt_Lastname,LName);
		page.fill(txt_PostalCode,PCode);
		page.locator(btn_Continue).scrollIntoViewIfNeeded();
		page.waitForSelector(btn_Continue);
		page.click(btn_Continue);
		
	}
	
	public void overview() {
		page.locator(lbl_ItemTotal).scrollIntoViewIfNeeded();
		page.waitForSelector(lbl_ItemTotal, new Page.WaitForSelectorOptions().setTimeout(70000));
		String ItemTotal=page.locator(lbl_ItemTotal).innerText();
		String Tax=page.locator(lbl_Tax).innerText();
		String Total=page.locator(lbl_Total).innerText();
		System.out.println("ItemTotal: "+ItemTotal);
		System.out.println("Tax: "+Tax);
		System.out.println("Total: "+Total);
		
		
	}
}
