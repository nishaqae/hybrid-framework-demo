/**
 * Test Case Steps:
 *  1. Goto https://www.saucedemo.com/
 *  2. Login with valid user name & password fetched from the data file
 *      username = standard_user password = secret_sauce
 *  3. Add Sauce Labs Bike Lights to cart
 *  4. Click on cart icon
 *  5. Click on CheckOut
 *  6. Fill-in the checkout info: firstname, last name & postal code
 *  7. Click on Continue
 *  8. Click on Finish
 *  9. Verify the order confirmation message:"THANK YOU FOR YOUR ORDER"
 *  10. LogOut 
 */
package com.saucedemo.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.config.BaseEvents;

/**
 * @author nisha
 *
 */
public class Test_CheckOut extends BaseEvents
{
	
	@Test
	public void verifyCheckOut() throws Exception
	{
		
		String[]keys = new String[2];
		
		log.info("Passing login Credentials");
		keys = set_valid_login(); //function in BaseConfig class to set login credentials
		
		try {
		
			loginObj.setValues(keys[0], keys[1]);
			} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	  log.info("Adding product to cart");
	  cartObj       =  prodObj.add_product_to_cart();//
	  checkoutObj   =  cartObj.click_on_checkout();
	  String result =  checkoutObj.fill_checkout_form();
	  				   prodObj.click_on_menu();
		
	  Assert.assertEquals(result,"THANK YOU FOR YOUR ORDER", "Order Failed");
					  
	  log.info("Order Success");
	 //System.out.println("Order Successfully Placed!");
					  
		
		
		
		
		
	}
	
	

}
