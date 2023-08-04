package selenium.in.gov.abdm.blocks.drugregistry.configclass;


import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

import java.util.concurrent.TimeUnit;

public class FAQAction extends SeleniumBaseClass {

	//SoftAssert softAssert = new SoftAssert();

	@Step("FAQ logo is clicked")
	public void FAQClick() throws Exception {
		//Thread.sleep(10000);
		Awaitility.await().atMost(10000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath(readXpath("FAQXpaths","FAQBtn","drugregistry"))).click();
	}

	@Step("Check FAQ logo is present")
	public String FAQLogo() throws Exception {
		//Thread.sleep(1000);
		Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath(readXpath("FAQXpaths","Drug_Reg_logo","drugregistry"))).getText();
	}

	@Step("Enter value in Search box and check")
	public boolean SearchBoxWorking(String txt) throws Exception {

		//Thread.sleep(1000);
		Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
		System.out.println(txt);
		driver.findElement(By.xpath(readXpath("FAQXpaths","SearchBox","drugregistry"))).sendKeys(txt);
		//Thread.sleep(10000);
		int len = txt.length();
		String FirstRes = driver.findElement(By.xpath(readXpath("FAQXpaths","SearchRes","drugregistry"))).getText().substring(0,len);
		if (txt.toLowerCase() == FirstRes.toLowerCase()) return true;
		else return false;

	}

}