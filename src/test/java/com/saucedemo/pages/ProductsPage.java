package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.saucedemo.config.BaseEvents;

public class ProductsPage extends BaseEvents
{
	protected WebDriver driver;

	public ProductsPage(WebDriver driver) 
	{
		this.driver= driver;
	}

	/* Locating elements on the products page
	 */
 
	@FindBy(xpath="//button[text()='Open Menu']")
	 private WebElement menu;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logOut;

	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	private WebElement bikeLight;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartBadge;
	
	
	/*
	 * Reads & returns the page title
	 */
	public String read_page_title()
	{
		return (driver.getTitle());
		
	}
	
	/*
	 * 1) clicks on the burger menu on products page, 2) clicks on LogOut
	 */
	public void click_on_menu() 
	{
		menu.click();
		logOut.click();
	}
	
	
	/*
	 * Add the listed product to cart & returns the CartPage Object
	 */
	public CartPage add_product_to_cart()
	{
		bikeLight.click();
		cartBadge.click();
		return cartObj;
		
		
	}

	
	
	
	
	
	
	

	
	
	
	

}
