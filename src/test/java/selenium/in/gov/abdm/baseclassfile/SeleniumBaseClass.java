package selenium.in.gov.abdm.baseclassfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import selenium.in.gov.abdm.utility.ScreenShot;

public class SeleniumBaseClass{
	
	public  static WebDriver driver;
    Properties prop = new Properties();
     
    
  //-----------------------TAKING VALUE FROM CONFIG FILE FOR XPATHS----------------------------------//

    public String readXpath(String Propname, String value, String app) throws IOException
    {
        prop.load(new FileInputStream("src\\test\\resources\\blocks\\"+app+"\\propertyfiles\\"+Propname+".properties"));
        //prop.load(new FileInputStream(""));
        return prop.getProperty(value);

    }
    
  //-----------------------TAKING VALUE FROM CONFIG FILE FOR XPATHS/-----------------------------------//
    
    
   //-----------------------CREATING DATE FOR EXTENT REPORT-----------------------------------//
   Date currentDate = new Date();
   final String date = currentDate.toString().replace(" ", "-").replace(":", "-");
 	
   public String extentFilePathCreate()  {
    	System.out.println("enter extentFilePathCreate()");
    	  
    	  String extentFile = System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\selenium.in.gov.abdm.results.extentreport"+"\\\\"+date+"--"+"ExtentReport.html";//change for common

        System.out.println("exit extentFilePathCreate()");
    	return extentFile;
    	
    }
  //-----------------------CREATING DATE FOR EXTENT REPORT/-----------------------------------//
    
    
  //-----------------------INITIALIZATION-----------------------------------------------------//
    public void initialization() throws IOException
    {
    	System.out.println("enter initialization()");
        String browserName = readXpath("config","browserType","drugregistry");
        //System.out.println(browserName);
        if(browserName.equalsIgnoreCase("chrome"))
        {
        	//System.out.println(System.getProperty("user.dir"));
        //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
        	
        	//FOR LOCAL TESTING USE THE BELOW LINE
        	WebDriverManager.chromedriver().setup();

        	//FOR JENKINS INTEGRATION USE BELOW LINE
        	//System.setProperty("webdriver.chrome.driver", "/bin/chromedriver");
       //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
        
        ChromeOptions opt1 = new ChromeOptions(); 
        //opt1.addArguments("--disable-notifications"); // to disable browser exception
        //opt1.addArguments("--headless");  //WHILE JENKINS INTEGRATION UNCOMMENT THIS LINE
        opt1.addArguments("--window-size=1920,1080");
        opt1.addArguments("--incognito");             // to run the test in Incognito mode 
        opt1.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        opt1.addArguments("--no-sandbox"); // Bypass OS security model
        opt1.addArguments("disable-infobars"); // disabling infobars
        opt1.addArguments("--disable-extensions"); // disabling extensions
        opt1.addArguments("--disable-gpu"); // applicable to windows os only
        opt1.addArguments("--ignore-certificate-errors");
        opt1.addArguments("--disable-popup-blocking");
        opt1.addArguments("--disable-default-apps");
        opt1.addArguments("--disable-extensions-file-access-check");
        driver = new ChromeDriver(opt1);
        
        //soft.assertAll();
        }
        
        else if(browserName.equalsIgnoreCase("gecko"))
        {
        	System.out.print("gecko");
        }
        
        else
        {
        	System.out.print("invalid browser");
        }
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();    //To delete all browser cookies
        
        System.out.println("exit initialization()");
        
    }
  //-----------------------INITIALIZATION/-----------------------------------//

      
    //-------------------------------EXTENT REPORT------------------------------------------------------//
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
	
    @BeforeSuite
    public void beforeSuit()
    {
    	System.out.println("enter beforesuite()");
        spark = new ExtentSparkReporter(extentFilePathCreate());//--------------------2-----------//
        //System.out.println(extentFile);
        extent = new ExtentReports();
        extent.attachReporter(spark);
         
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Host Name", "HP");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Sourav Padhi");
        System.out.println("exit beforesuite()");
    }
     
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
         
            test.fail(result.getThrowable());
            
            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
            String screeshotPath = ScreenShot.failedTCSS(result.getName(),System.getProperty("user.dir")+"\\\\src\\\\test\\\\resources\\\\selenium.in.gov.abdm.results.failedscreenshots\\\\");//change for common
           //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
            
            test.fail("FAILED TEST CASE SCREENSHOT", MediaEntityBuilder.createScreenCaptureFromPath(screeshotPath).build());
            
            
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
        	System.out.println("enter success listener");
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
            System.out.println("exit success listener");
        }
        else if(result.getStatus() == ITestResult.SKIP)
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }

    }
    

    public void closeBrowserAfterTest()
    {
    	System.out.println("enter aftertest()");
    	driver.close();
    }
     
    @AfterSuite
    public void tearDown()
    
    {
    	System.out.println("enter aftersuite()");
    	//JavaEmailSender();
        extent.flush();
        

        System.out.println("exit aftersuite()");

    }
    
  //-------------------------------EXTENT REPORT/------------------------------------------------------//

}
