package com.qa.testapp.factory;

import com.microsoft.playwright.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.BrowserType.LaunchOptions;

public class PlaywrightFactory {
	
	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;
	
	public Page initBrowser(Properties prop) {
		
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setSlowMo(2000).setHeadless(false));
		browserContext = browser.newContext();
		page = browserContext.newPage();
		page.navigate(prop.getProperty("url"));
		
		return page;
	}
	//initialize properties 
	public Properties init_prop() throws IOException {
		
		FileInputStream ip = new FileInputStream("./src/test/resource/config/config.properties");
		prop = new Properties();
		prop.load(ip);
		
		return prop;
		
	}

}
