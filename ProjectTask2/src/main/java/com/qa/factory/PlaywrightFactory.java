package com.qa.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	Page page;
	BrowserContext browserContext;
	
	public Page initBrowser(String browserName) {
		
		playwright = Playwright.create();
		
		switch(browserName) {
		case "chromium":
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
			break;
		case "firefox":
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
			default:
				System.out.println("Please pass right broswer");
		}
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate("https://www.saucedemo.com/");
		
		return page;
		
	}

}
