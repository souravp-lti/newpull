package selenium.in.gov.abdm.blocks.drugregistry.configclass;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

import java.util.concurrent.TimeUnit;

public class AdminLoginAction extends SeleniumBaseClass {
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		@Step("Click Admin Login")
	    public void AdminLoginClick() throws Exception {
			//Thread.sleep(10000);
			Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
	    	driver.findElement(By.xpath(readXpath("AdminLoginXpaths","AdminLogin","drugregistry"))).click();
	    }
		
		@Step("Check user landed in Admin Login page")
	    public String AdminLoginPage() throws Exception {
	    	return driver.findElement(By.xpath(readXpath("AdminLoginXpaths","AdminLoginLogo","drugregistry"))).getText();
	    }
		
		@Step("Check user name logo is present")
	    public String UserNamePresent() throws Exception {
	    	return driver.findElement(By.xpath(readXpath("AdminLoginXpaths","UserNameLabel","drugregistry"))).getText();
	    }
		
		@Step("Username Text box is present")
	    public boolean UserNametxtBoxDis() throws Exception {
	    	return driver.findElement(By.xpath(readXpath("AdminLoginXpaths","UserNameTxtBox","drugregistry"))).isDisplayed();
	    }
		
		@Step("Pass value to username text box")
	    public void UserNameVal(String str) throws Exception {
	    	driver.findElement(By.xpath(readXpath("AdminLoginXpaths","UserNameTxtBox","drugregistry"))).sendKeys(str);
	    }
		
		@Step("Check password logo is present")
	    public String passwordPresent() throws Exception {
	    	return driver.findElement(By.xpath(readXpath("AdminLoginXpaths","PasswordLabel","drugregistry"))).getText();
	    }
		
		@Step("Password Text box is present")
	    public boolean PasstxtBoxDis() throws Exception {
	    	return driver.findElement(By.xpath(readXpath("AdminLoginXpaths","PasswordTxtBox","drugregistry"))).isDisplayed();
	    }
		
		@Step("Pass value to Password text box")
	    public void PasswordVal(String str) throws Exception {
			driver.findElement(By.xpath(readXpath("AdminLoginXpaths", "PasswordTxtBox", "drugregistry"))).sendKeys(str);
		}
		
		@Step("Click on login button")
	    public void loginClick() throws Exception {
			//CAPTCHA
			driver.findElement(By.xpath(readXpath("AdminLoginXpaths","captchaVal","drugregistry"))).sendKeys("123");
			//Thread.sleep(5000);
			Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
	    	driver.findElement(By.xpath(readXpath("AdminLoginXpaths","LoginBtn","drugregistry"))).click();
	    }
		
		@Step("Landing Page reached")
	    public boolean LandPgDis() throws Exception {
			//Thread.sleep(5000);
			Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
	    	return driver.findElement(By.xpath(readXpath("AdminLoginXpaths","LandingPage","drugregistry"))).isDisplayed();
	    }
		
		@Step("Check label in tab")
	    public String tabName(String str) throws Exception {
			js.executeScript("window.scrollBy(0,-400)", "");
			//driver.findElement(By.xpath(readXpath("Xpath6_AdminLogin","tabs1")+str+readXpath("Xpath6_AdminLogin","tabs2")+2+readXpath("Xpath6_AdminLogin","tabs3"))).click();
	    	return driver.findElement(By.xpath(readXpath("AdminLoginXpaths","tabs1","drugregistry")+str+readXpath("AdminLoginXpaths","tabs2","drugregistry")+2+readXpath("AdminLoginXpaths","tabs3","drugregistry"))).getText();
	    }
		
		@Step("Check number in tab")
	    public String tabNum(String str) throws Exception {
			driver.findElement(By.xpath(readXpath("AdminLoginXpaths","tabs1","drugregistry")+str+readXpath("AdminLoginXpaths","tabs2","drugregistry")+2+readXpath("AdminLoginXpaths","tabs3","drugregistry"))).click();
	    	return driver.findElement(By.xpath(readXpath("AdminLoginXpaths","tabs1","drugregistry")+str+readXpath("AdminLoginXpaths","tabs2","drugregistry")+1+readXpath("AdminLoginXpaths","tabs3","drugregistry"))).getText();
	    }		
		
		@Step("Check the value matches with one at the bottom")
	    public String CheckValAtBottom() throws Exception {
			  WebElement l=driver.findElement(By.xpath(readXpath("AdminLoginXpaths","ValInBottom","drugregistry")));
		      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
		      //Thread.sleep(10000);
			  Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
		      String ValAtBottom = l.getText();
		      //System.out.println(ValAtBottom);
		      String ValAtBottom1;
			ValAtBottom1 = ValAtBottom.substring(ValAtBottom.indexOf("of ")+3);
			return ValAtBottom1;
	    }	
		
}
