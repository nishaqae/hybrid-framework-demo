/**
 * 
 */
package com.saucedemo.dataProviders;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

/**
 * @author nisha
 *
 */

public class LoginDataProvider
{	
	
	@DataProvider(name = "LoginData")
 public String[][] getLogin() throws IOException
  {
 
 XSSFWorkbook book = new XSSFWorkbook("C:\\SeleniumTraining\\Workspace\\Java\\JavaDummy\\DataDrivenFrameworkDemo\\src\\test\\java\\com\\saucedemo\\config\\login_data.xlsx");
 XSSFSheet sheet = book.getSheet("Login_Credentials");	
 
  int rows = sheet.getPhysicalNumberOfRows();
  int cols = sheet.getRow(0).getPhysicalNumberOfCells();
  
  String[][]userDetails = new String[rows][cols];
   
   for(int i=0; i<rows; i++)
   {
	  
	    for( int j=0; j<cols ; j++)
	    {
	    	userDetails[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
	    	 //System.out.println(userDetails[i][j]);
	    }
	   
	   
	   
   }
  
 book.close();
 return userDetails;
 

  }

}
