package com.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
	Properties prop;
	
	public Page initBrowser(Properties prop) {
		String brow=prop.getProperty("browser");
		playwright = Playwright.create();
		
		switch(brow) {
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
		page.navigate(prop.getProperty("url").trim());
		
		return page;
		
	}
	public Properties init_prop() {
		try {                                         
			FileInputStream ip = new FileInputStream("./src/main/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
