/*
* Test Class to check the login with given set of username & password 
*/
package com.saucedemo.tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.saucedemo.config.BaseEvents;
import com.saucedemo.dataProviders.LoginDataProvider;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;

/**
 * @author nisha
 * Step 1: Launch the url - saucedemo.com
 * Step 2: Login to the system using the user name & password fetched from data file
 * Step 3: On successful login, read the page title
 * Step 4: Click on menu & then logOut
 */
public class Test_Login extends BaseEvents
{
	
	@Test(dataProvider = "LoginData", dataProviderClass =LoginDataProvider.class)
	public void verifyLogin(String userName, String password) throws Exception
	{
		
		
 /*
  *  login() will read from the data file 
  * & pass the credentials to login form. On successful login,
  * user will directed to the ProductsPage.
  */
		boolean login_attempt = loginObj.login(userName, password);
		
		if (login_attempt)
		{
		log.info("Page Title on successfule login : " + prodObj.read_page_title());
		
		prodObj.click_on_menu();
		log.info("Login Successful with username : " + userName);
		System.out.println("Login Successful with username : " + userName);
		}
			
		else
		{
			log.severe("Login Failed  with username : " + userName);
			System.out.println("Login Failed  with username : " + userName);
		
		}	
	
	}
		
}
	
	
	
	
