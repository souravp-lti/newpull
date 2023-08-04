package selenium.in.gov.abdm.blocks.drugregistry.configclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.qameta.allure.Step;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

public class AboutABDMAction extends SeleniumBaseClass {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	//
	@Step("Go to About ABDM page")
	public void abtABDmPage() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(readXpath("HomePageXpaths","AbtABDMBtn","drugregistry"))).click();
	}

	@Step("Check About ABDM logo is present")
	public String abtABDmLogo() throws InterruptedException, IOException {
		//Thread.sleep(1000);
		Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","AbtABDMLogo","drugregistry"))).getText();
	}

	@Step("Check ABDM full form is present")
	public String ABDMfullForm() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","ABDMFullForm","drugregistry"))).getText();
	}

	@Step("About Button")
	public boolean AbtBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","AboutButton","drugregistry"))).isDisplayed();
	}

	@Step("About Button text")
	public String AbtBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","AboutButton","drugregistry"))).getText();
	}

	@Step("Background Button")
	public boolean BackgroundBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","BackgroundButton","drugregistry"))).isDisplayed();
	}

	@Step("Background Button text")
	public String BackgroundBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","BackgroundButton","drugregistry"))).getText();
	}

	@Step("Vision Button")
	public boolean VisionBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","VisionButton","drugregistry"))).isDisplayed();
	}

	@Step("Vision Button text")
	public String VisionBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","VisionButton","drugregistry"))).getText();
	}

	@Step("Object Button")
	public boolean ObjectBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","ObjButton","drugregistry"))).isDisplayed();
	}

	@Step("Object Button text")
	public String ObjectBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","ObjButton","drugregistry"))).getText();
	}

	@Step("Opportunities Button")
	public boolean OppBtnVisible() throws Exception {
		js.executeScript("window.scrollBy(0,250)", "");
		//Thread.sleep(3000);
		Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","OppButton","drugregistry"))).isDisplayed();
	}

	@Step("Opportunities Button text")
	public String OppBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","OppButton","drugregistry"))).getText();
	}

	@Step("Benefits Button")
	public boolean BenBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","BenefitButton","drugregistry"))).isDisplayed();
	}

	@Step("Benefits Button text")
	public String BenBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","BenefitButton","drugregistry"))).getText();
	}

	@Step("Principles Button")
	public boolean PrincBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","PrincipleButton","drugregistry"))).isDisplayed();
	}

	@Step("Principles Button text")
	public String PrincBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","PrincipleButton","drugregistry"))).getText();
	}

	@Step("Building Blocks Button")
	public boolean BuildBlBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","BuildingButton","drugregistry"))).isDisplayed();
	}

	@Step("Building Blocks Button text")
	public String BuildBlBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","BuildingButton","drugregistry"))).getText();
	}

	@Step("Architecture Button")
	public boolean ArchBtnVisible() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","ArchButton","drugregistry"))).isDisplayed();
	}

	@Step("Architecture Button text")
	public String ArchBtnTxt() throws Exception {
		return driver.findElement(By.xpath(readXpath("AboutABDMXpaths","ArchButton","drugregistry"))).getText();
	}

}