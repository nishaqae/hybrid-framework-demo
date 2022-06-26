/**
 * BaseConfig Class is the base class
 * 1) load the key-value pair from config.properties file
 * 2) load the driver based on browser type
 * 3) launch the browser with the given url
 * 
 */
package com.saucedemo.config;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

/**
 * @author nisha
 *
 */
public abstract class BaseConfig {

    protected  WebDriver driver 	= null;
    protected Logger log;
    protected Handler handler;
    protected  String baseUrl 	    = null;
	protected  String productUrl	= null;
	private    String browser 		= null;
	private    String chromePath 	= null;
	private    String firefoxPath 	= null;
	private    String edgePath 		= null;
	private    String firefoxdriver = null;
	private    String logFile 		= null;
	//private    String fileStream	= null;
	protected  String screenshotPath= null;
	private  	static String userName;
	private  	static String password;
	
	
	/* loadProperties() will load the values from the
	 * config file to variables declared and load the driver as per
	 * the chosen browser type
	 */
	protected void loadProperties() throws IOException
		{
		FileInputStream file = new FileInputStream("C:\\SeleniumTraining\\Workspace\\Java\\JavaDummy\\DataDrivenFrameworkDemo\\src\\test\\java\\com\\saucedemo\\config\\config.properties");
		Properties prop      = new Properties();
		prop.load(file);
		
		browser 	= prop.getProperty("browser");
		chromePath 	= prop.getProperty("chromePath");
		baseUrl 	= prop.getProperty("baseUrl");
		productUrl  = prop.getProperty("productUrl");
		userName    = prop.getProperty("Username");
		password    = prop.getProperty("Password");
		logFile     = prop.getProperty("logFile");
		//fileStream  = prop.getProperty("fileStream");
		screenshotPath=prop.getProperty("screenshotPath");
		
		
	switch(browser)
		{
		
		case "Chrome" : 
		case "chrome" :
			
			  System.setProperty("webdriver.chrome.driver", chromePath);
			  driver = new ChromeDriver();
			  launchBrowser();
			  break;
			  
		case "Firefox" :
		case "FF":
		case "firefox":
			
			  System.setProperty("webdriver.gecko.driver", firefoxPath);
			  driver = new FirefoxDriver();
			  launchBrowser();
			  break;
			  
		case "Edge" :
		case "edge" :
		
			  System.setProperty("webdriver.edge.driver", edgePath);
			  driver = new EdgeDriver();
			  launchBrowser();
			  break;
		
		}
		
	}
	
	
	/* launchBrowser() will: 1) launch the browser with the given url
	 * 						 2) maximize the browser window
	 * 						 3) manage pageload & implicit wait timeouts
	 */
  protected void launchBrowser()
	{
		 
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		
	}
	
  
  /* closeBrowser() will : 1) quits the driver
   * 					   2) kills the tasks explicitly in the task manager to free the resources
   */
	protected void closeBrowser() throws IOException
	{
		driver.close();
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		
		
	}
	
	
	/* set_valid_login(): loads the valid user name & password for login  */
	 
	protected String[] set_valid_login()
	{
		String[]keys	 = new String[2];
				keys[0]  = userName;
				keys[1]	 = password;
				return  keys;
		
	}
	
	
	/* Initializes and sets up the Logger */
	
	protected void addLogger(Method m) throws Exception
	
	{
		logFile = logFile +  m.getName() + ".txt";
		log		= Logger.getLogger(logFile);
		handler = new java.util.logging.FileHandler(logFile);
		log.addHandler(handler);
		log.setLevel(Level.ALL);
		handler.setFormatter(new SimpleFormatter());
		
	}
	
	/* Closes the logger and all connected handlers */
	
	protected void closeLogger()
	{
		Handler[] h= log.getHandlers();
		   for(Handler hs:h)
			   hs.close();
	}
	

	public void captureScreenShotonFailure(ITestResult result) throws Exception
	  {
		 if( ITestResult.FAILURE == result.getStatus())
		 {
			   TakesScreenshot ssr =(TakesScreenshot)driver;
			   File source = ssr.getScreenshotAs(OutputType.FILE);
			   String destPath = screenshotPath + result.getMethod().getMethodName()+".png";
			   File dest = new File(destPath);
			   FileHandler.copy(source, dest);
			 
			 
		 }
	  }


}

