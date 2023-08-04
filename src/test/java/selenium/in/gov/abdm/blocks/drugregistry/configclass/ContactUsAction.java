package selenium.in.gov.abdm.blocks.drugregistry.configclass;

import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.qameta.allure.Step;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

public class ContactUsAction extends SeleniumBaseClass {

	//SoftAssert softAssert = new SoftAssert();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//
	@Step("Go to Contact Us Page")
	public void contactUsPage() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(readXpath("ContactUsXpaths","contactUsBtn","drugregistry"))).click();
	}

	@Step("Check Contact Us logo is present")
	public String contactUsLogo() throws Exception {
		//Thread.sleep(1000);
		Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","contactUsLogo","drugregistry"))).getText();
	}

	@Step("Check Name is present")
	public String nameTxtPresent() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","nameTxtBox","drugregistry"))).getText();
	}

	@Step("Name text box visible")
	public boolean nameTxtBoxVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","nameTxtEnter","drugregistry"))).isDisplayed();
	}

	@Step("Check Email is present")
	public String emailTxtPresent() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","emailTxtBox","drugregistry"))).getText();
	}

	@Step("Email text box visible")
	public boolean emailTxtBoxVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","emailTxtEnter","drugregistry"))).isDisplayed();
	}

	@Step("Check Mobile is present")
	public String mobileTxtPresent() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","mobileTxtBox","drugregistry"))).getText();
	}

	@Step("Mobile text box visible")
	public boolean mobileTxtBoxVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","mobileTxtEnter","drugregistry"))).isDisplayed();
	}

	@Step("Check Message is present")
	public String messageTxtPresent() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","msgTxtBox","drugregistry"))).getText();
	}

	@Step("Message text box visible")
	public boolean messageTxtBoxVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","msgTxtEnter","drugregistry"))).isDisplayed();
	}

	@Step("Address text Present")
	public String AddTxtPresent() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","AddText","drugregistry"))).getText();
	}

	@Step("Address Details Present")
	public String addDetailsPresent() throws Exception {
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","AdddetailText","drugregistry"))).getText();
	}

	@Step("Submit Button Present")
	public String submitBtnPresent() throws Exception {
		js.executeScript("window.scrollBy(0,250)", "");
		return driver.findElement(By.xpath(readXpath("ContactUsXpaths","submitBtn","drugregistry"))).getText();
	}

}