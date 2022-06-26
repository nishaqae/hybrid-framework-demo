/**
 * BaseEvents Class has all the required annotations to 
 * call the respective functions
 * 1) @Before & @After Class does the setUp & tearDown 
 *     tasks respectively.
 * 2) 
 */

package com.saucedemo.config;

import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;

/**
 * @author nisha
 *
 */
public class BaseEvents extends BaseConfig
{
	protected static LoginPage loginObj = null;
	protected static ProductsPage prodObj = null;
	protected static CartPage cartObj = null;
	protected static CheckoutPage checkoutObj = null;

	@BeforeTest
	 public void setUp() throws IOException
	 {
		loadProperties();
		loginObj=PageFactory.initElements(driver,LoginPage.class);
		prodObj =PageFactory.initElements(driver,ProductsPage.class);
		cartObj =PageFactory.initElements(driver,CartPage.class);
		checkoutObj = PageFactory.initElements(driver,CheckoutPage.class);
		
		
	 }
	
	
	@BeforeMethod
	public void usingLogger(Method m) throws Exception
	{
	  addLogger(m);
		
	}
	
	
	@AfterMethod
	 public void initAfterMethod(ITestResult result) throws Exception
	 {
		 closeLogger();
		 captureScreenShotonFailure(result);
	 }
	
	
	@AfterTest
	public void tearDown() throws IOException
	{
			closeBrowser();
			
		
	}
	 
	
	
	
	
	

}
