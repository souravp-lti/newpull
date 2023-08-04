package selenium.in.gov.abdm.blocks.testParametrizedData.testsclasses;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.listeners.AllureListener;

import java.io.IOException;


@Listeners(AllureListener.class)
public class test extends SeleniumBaseClass {


	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("user Launch Chrome browser") 
	@Story("To verify that chrome browser was launched properly")
    public void user_Launch_Chrome_browser() throws IOException {
    	test = extent.createTest("user_Launch_Chrome_browser");
        initialization();   
    }
         
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
	@Description("user opens URL") 
    @Story("To verify that URL opened properly")
    public void user_opens_URL() throws Exception {
    	test = extent.createTest("user_opens_URL");
    	driver.get("https://www.amazon.in/");
        Thread.sleep(10000);
        //Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
    }

//    @DataProvider(name = "test-data")
//    public Object[][] dataProvFunc() {
//        return new Object[][]{
//                {"apple"}, {"orange"}
//        };
//    }

    @Test(priority = 3 , dataProvider = "test-data" , dataProviderClass = dataFile.class)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Abt_ABDM_logo") 
    @Story("User able to see About ABDM logo")
    public void dataProvide(String dataStr) throws InterruptedException {
    	
    	test = extent.createTest("Verify_Abt_ABDM_logo");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchBox.click();
        searchBox.sendKeys(dataStr);
        Thread.sleep(10000);
        searchBox.clear();
    }
    

}
