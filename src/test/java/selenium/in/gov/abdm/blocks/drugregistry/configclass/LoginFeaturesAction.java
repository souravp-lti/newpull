package selenium.in.gov.abdm.blocks.drugregistry.configclass;

import org.openqa.selenium.By;
import io.qameta.allure.Step;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

public class LoginFeaturesAction extends SeleniumBaseClass {


	@Step("Click Here For Login & regd btn is clicked")
	public void LoginRegdClick() throws Exception {
		Thread.sleep(1000);
		//await().atMost(10000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","ClickHereForLogin&regd","drugregistry"))).click();
	}
	//TC5_DR_LoginFeature
	@Step("Click Here For Login & regd btn text is fetched")
	public String LoginRegdTxt() throws Exception {
		Thread.sleep(1000);
		//await().atMost(10000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","ClickHereForLogin&regd","drugregistry"))).getText();
	}

	@Step("Login to Acc text is present")
	public String LoginToAccTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","LoginToAccTxt","drugregistry"))).getText();
	}

	@Step("For Existing user text is present")
	public String ForExistUserTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","ForExistUser","drugregistry"))).getText();
	}

	@Step("For New user text is present")
	public String ForNewUserTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","ForNewUser","drugregistry"))).getText();
	}

	@Step("For New user text is clicked")
	public void ForNewUserClick() throws Exception {
		driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","ForNewUser","drugregistry"))).click();
	}

	@Step("Login text is present")
	public String LoginTxtPres() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","LoginTxt","drugregistry"))).getText();
	}

	@Step("User ID / Username text is present")
	public String UserIDTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","UserIdRadio","drugregistry"))).getText();
	}

	@Step("Mobile Number text is present")
	public String MobileNumTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","MobileNumRadio","drugregistry"))).getText();
	}

	@Step("Mobile Number Radio Btn Clicked")
	public void MobileNumClick() throws Exception {
		driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","MobileNumRadio","drugregistry"))).click();
	}

	@Step("User ID / Username box text is present")
	public String UserIDBoxTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","UseridTxt","drugregistry"))).getText();
	}

	@Step("User ID / Username text box is present")
	public boolean UserIDTxtBox() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","UserTxtBox","drugregistry"))).isDisplayed();
	}

	@Step("Login Btn is present")
	public boolean LoginBtn() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","LoginBtn","drugregistry"))).isDisplayed();
	}

	@Step("Login Btn txt is present")
	public String LogintxtBtn() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","LoginBtn","drugregistry"))).getText();
	}

	@Step("Submit Btn text present")
	public String SubmitBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","SubmitBtn","drugregistry"))).getText();
	}

	@Step("Submit Button is present")
	public boolean SubmitBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","SubmitBtn","drugregistry"))).isDisplayed();
	}

	@Step("Register as manufacturer text present")
	public String RegisAsManuTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","RegisterAsManu","drugregistry"))).getText();
	}

	@Step("Register as manufacturer Button is present")
	public boolean RegisAsManuVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","RegisterAsManu","drugregistry"))).isDisplayed();
	}

	@Step("Register Already Have a User ID")
	public String AlreadyHavUser() throws Exception {
		return driver.findElement(By.xpath(readXpath("LoginFeatureXpaths","RegisAlreadyUsertxt","drugregistry"))).getText();
	}

}

