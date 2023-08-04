package selenium.in.gov.abdm.utility;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

public class ScreenShot extends SeleniumBaseClass{
	
	
  	//public static String failedTCSS(String testMethodName) throws IOException {  
  	public static String failedTCSS(String testMethodName, String screenSPath) throws IOException {  	
  		
  		Date currentdate = new Date();
  		String screenShotName = currentdate.toString().replace(" ", "-").replace(":", "-");	
  		File scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(screenSPath+testMethodName+"-"+screenShotName+"_FAILED.png");
  		FileUtils.copyFile(scrShot, dest);
  		return dest.getAbsolutePath();
  	
  	}

}
