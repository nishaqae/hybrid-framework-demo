/**
 * 
 */
package com.saucedemo.pages;
import com.saucedemo.config.BaseEvents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author nisha
 *
 */
public class LoginPage extends BaseEvents
{ 
	protected WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver= driver;
	}

	/* Locating form fields: user name, password & login button
	 */
 
	@FindBy(id="user-name")
	  private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="login-button")
	private WebElement loginButton;
	
	 @FindBy(xpath="//div[@class='error-message-container error']")
	private WebElement errorMsg;
	
	
	 
	 public void setValues(String name, String pwd)throws Exception
	 {
		// System.out.println("In LOGIN Page : user = "+ name + " pwd =" + pwd);
		  userName.clear();
		  userName.sendKeys(name);
		  password.clear();
		  password.sendKeys(pwd);  
		  
		  loginButton.click();
		 
	 }
	 

		/*
		 * login() will read from the data file 
		 * & pass the credentials to login form. On successful login,
		 * user will directed to the ProductsPage.
		 */
  public boolean login(String name, String pwd) throws Exception 
	{
	  boolean login_attempt= false;
	  
	  String productUrl = "https://www.saucedemo.com/inventory.html";
	  
	  setValues(name, pwd); 
	  
	  if(productUrl.equals(driver.getCurrentUrl()))
		   login_attempt = true;
	  
	  
	  return login_attempt;
	  
	
	}
  
     
	  
   }
  
	
	
	
	
	

