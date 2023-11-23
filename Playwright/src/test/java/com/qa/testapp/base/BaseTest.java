package com.qa.testapp.base;


import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Page;
import com.qa.testapp.Pages.LoginPage;
import com.qa.testapp.factory.PlaywrightFactory;


public class BaseTest {
	
	PlaywrightFactory pf;
	Page page;
	public Properties prop;
	public LoginPage loginPage;
	
    
	@BeforeTest
	public void setup()  { 
		pf = new PlaywrightFactory();
		try {
			prop =pf.init_prop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		page = pf.initBrowser(prop);
		loginPage = new LoginPage(page);
		}
	
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	

}
