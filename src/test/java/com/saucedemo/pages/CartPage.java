/**
 * 
 */
package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.saucedemo.config.BaseEvents;

/**
 * @author nisha
 *
 */
public class CartPage extends BaseEvents
{

	protected WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	@FindBy(id="checkout")
	
	private WebElement checkoutButton;
	public CheckoutPage click_on_checkout()
	{
		checkoutButton.click();
		return checkoutObj;
	}

	
}
