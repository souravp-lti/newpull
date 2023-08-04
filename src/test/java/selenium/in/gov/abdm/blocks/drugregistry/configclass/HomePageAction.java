package selenium.in.gov.abdm.blocks.drugregistry.configclass;

import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class HomePageAction extends SeleniumBaseClass {

	@Step("Home Button")
	public boolean homeBtnVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","homeButton","drugregistry"))).isDisplayed();
	}

	@Step("About ABDM Button")
	public boolean abtABDMBtnVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","AbtABDMBtn","drugregistry"))).isDisplayed();
	}

	@Step("Resource Center Button")
	public boolean resCenterVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","ResourceCenterBtn","drugregistry"))).isDisplayed();
	}

	@Step("Contact Us Button")
	public boolean contUsBtnVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","ContactUsBtn","drugregistry"))).isDisplayed();
	}

	@Step("FAQ Button")
	public boolean FAQBtnVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","FAQBtn","drugregistry"))).isDisplayed();
	}

	@Step("ABDM text present")
	public String ABDMTextVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","ABDMText","drugregistry"))).getText();
	}

	@Step("Drug Registry text present")
	public String DGTextVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","DrugRegistryTxt","drugregistry"))).getText();
	}

	@Step("Search bar present")
	public boolean SearchBarVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","SearchBar","drugregistry"))).isDisplayed();
	}

	@Step("Search button present")
	public boolean SearchBtnVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","SearchBtn","drugregistry"))).isDisplayed();
	}

	@Step("Search button text present")
	public String SearchBtnTxtVisible() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","SearchBtn","drugregistry"))).getText();
	}

	@Step("Click any alphabet")
	public String clickAlpha(String alpha) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		driver.findElement(By.xpath(readXpath("HomePageXpaths","SelectAlpha","drugregistry")+alpha+"')]")).click();
		Thread.sleep(10000);
		String drugName = driver.findElement(By.xpath(readXpath("HomePageXpaths","ConfirmSelAlpha","drugregistry"))).getText();
		return drugName.substring(0, 1);
	}

	@Step("Click Here for login.... button present")
	public boolean ClickHereLoginPres() throws Exception {
		driver.findElement(By.xpath(readXpath("HomePageXpaths","homeButton","drugregistry"))).click();
		driver.manage().timeouts().implicitlyWait(80, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","ClickHereForLogin&regd","drugregistry"))).isDisplayed();
	}

	@Step("Last Updated Date")
	public String LastUpdatedDate() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","LastUpdatedDate","drugregistry"))).getText().substring(30);
	}

	@Step("Verify Last Updated Date")
	public boolean VerifyLastUpdatedDate() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, SECONDS);
		return driver.findElement(By.xpath(readXpath("HomePageXpaths","LastUpdatedDate","drugregistry"))).isDisplayed();
	}
}

