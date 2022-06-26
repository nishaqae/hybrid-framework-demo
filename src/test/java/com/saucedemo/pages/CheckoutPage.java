package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.saucedemo.config.BaseEvents;

public class CheckoutPage extends BaseEvents
{
	protected WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement postalCode;
	
	@FindBy(id="continue")
	private WebElement continueButton;

	@FindBy(id="finish")
	private WebElement finishButton;
	
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	private WebElement orderMsg;
	
	
	public String fill_checkout_form() throws InterruptedException
	{
	  firstName.clear();
	  firstName.sendKeys("standard");
	  lastName.clear();
	  lastName.sendKeys("user");
	  postalCode.clear();
	  postalCode.sendKeys("30020");
	  continueButton.click();
	  finishButton.click();
	  String result = orderMsg.getText();
	  return result;
	 
	}
			
	
	

}
