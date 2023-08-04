package selenium.in.gov.abdm.blocks.drugregistry.testsclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import selenium.in.gov.abdm.blocks.drugregistry.configclass.FAQAction;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.listeners.AllureListener;

//CHECKS ALL THE FEATURES ARE PRESENT IN THE HOMEPAGE
@Listeners(AllureListener.class)
public class FAQTest extends SeleniumBaseClass {
	
	FAQAction FAQPage;
   
	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("user Launch Chrome browser") 
	@Story("To verify that chrome browser was launched properly")
    public void user_Launch_Chrome_browser() throws Exception {
    	test = extent.createTest("user_Launch_Chrome_browser");
        initialization();   
    }
         
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
	@Description("user opens URL") 
    @Story("To verify that URL opened properly")
    public void user_opens_URL() throws Exception {
    	test = extent.createTest("user_opens_URL");
    	driver.get(readXpath("config","URL","drugregistry"));
    	
    }
     
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_FAQ_logo") 
    @Story("User able to see FAQ logo")
    public void verifyFAQlogo() throws Exception {
    	
    	test = extent.createTest("Verify_FAQ_logo");
    	FAQPage = new FAQAction();
    	FAQPage.FAQClick();
    	String FAQ = FAQPage.FAQLogo();
        Assert.assertEquals(FAQ, "Drug Registry FAQs"); 
        
        boolean status = FAQPage.SearchBoxWorking("what");
        Assert.assertFalse(status);
        closeBrowserAfterTest();
    }
    
  
    
}
