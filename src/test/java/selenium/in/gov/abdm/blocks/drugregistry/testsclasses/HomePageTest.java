package selenium.in.gov.abdm.blocks.drugregistry.testsclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import selenium.in.gov.abdm.blocks.drugregistry.configclass.HomePageAction;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.listeners.AllureListener;

import java.util.Random;

//CHECKS ALL THE FEATURES ARE PRESENT IN THE HOMEPAGE

@Listeners(AllureListener.class)
public class HomePageTest extends SeleniumBaseClass{
	
	HomePageAction DGHomePage;
   
	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("user Launch Chrome browser") 
	@Story("To verify that chrome browser was launched properly")
    public void user_Launch_Chrome_browser() throws Exception {
    	test = extent.createTest("user_Launch_Chrome_browser");
    	//System.out.println("1");
        initialization();
    }
    
        
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
	@Description("user opens URL") 
    @Story("To verify that URL opened properly")
    public void user_opens_URL() throws Exception {
    	test = extent.createTest("user_opens_URL");
    	//driver.get(takeData.readExcelFile("testData",1,1));
    	System.out.println("3");
    	driver.get(readXpath("config","URL","drugregistry"));
    	System.out.println("6");
    }
    
    
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_home_button") 
    @Story("User able to see home button")
    public void verifyHomeBtn() throws Exception {
    	
    	test = extent.createTest("Verify_Home_Button");
    	DGHomePage = new HomePageAction();
    	boolean homeBtnVisibleval = DGHomePage.homeBtnVisible();
        Assert.assertTrue(homeBtnVisibleval);
    }
    
    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_home_button") 
    @Story("User able to see About ABDM button")
    public void verifyAbtABDM() throws Exception {
    	
    	test = extent.createTest("Verify_About_ABDM_Button");
    	boolean ABtBtnBtnVisibleval = DGHomePage.abtABDMBtnVisible();
        Assert.assertTrue(ABtBtnBtnVisibleval);
       
    }
    
    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_home_button") 
    @Story("User able to see home button")
    public void verifyResCenBtn() throws Exception {
    	
    	test = extent.createTest("Verify_Resource_Center_Button");
    	boolean ResCenBtnVisibleval = DGHomePage.resCenterVisible();
        Assert.assertTrue(ResCenBtnVisibleval);
       
    }
    
    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Contact_Us_button") 
    @Story("User able to see Contact Us button")
    public void verifyContUsBtn() throws Exception {
    	
    	test = extent.createTest("Verify_Contact_Us_Button");
    	boolean ContactUsBtnVisibleval = DGHomePage.contUsBtnVisible();
        Assert.assertTrue(ContactUsBtnVisibleval);
       
    }
    
    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_FAQ_button") 
    @Story("User able to see FAQ button")
    public void verifyFAQBtn() throws Exception {
    	
    	test = extent.createTest("Verify_FAQ_Button");
    	boolean FAQBtnVisibleval = DGHomePage.FAQBtnVisible();
        Assert.assertTrue(FAQBtnVisibleval);
       
    }
    
    @Test(priority = 8)
    @Severity(SeverityLevel.BLOCKER)
	@Description("Verify_ABDM_text") 
    @Story("User able to see ABDM text")
    public void ABDMTxtPres() throws Exception {
    	
    	test = extent.createTest("Verify_ABDM_Text_Present");
    	String ABDMText = DGHomePage.ABDMTextVisible();
        Assert.assertEquals(ABDMText, "Ayushman Bharat Digital Mission");       
       
    }
    
    @Test(priority = 9)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Verify_DG_text") 
    @Story("User able to see Drug Registry text")
    public void DGTxtPres() throws Exception {
    	
    	test = extent.createTest("Verify_Drug_Registry_Text_Present");
    	String DGtext = DGHomePage.DGTextVisible();
        Assert.assertEquals(DGtext, "Drug Registry");       
       
    }
    
    @Test(priority = 10)
    @Severity(SeverityLevel.MINOR)
	@Description("Verify_Search_bar_present") 
    @Story("User able to see Search bar")
    public void verifySearchBar() throws Exception {
    	
    	test = extent.createTest("Verify_Search_Bar");
    	boolean Searchbar = DGHomePage.SearchBarVisible();
        Assert.assertTrue(Searchbar);
       
    }
    
    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Search_button_present") 
    @Story("User able to see Search button")
    public void verifySearchBtn() throws Exception {
    	
    	test = extent.createTest("Verify_Search_Btn");
    	boolean SearchBtn = DGHomePage.SearchBtnVisible();
        Assert.assertTrue(SearchBtn);
       
    }
    
    @Test(priority = 12)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Verify_Search_btn_txt") 
    @Story("User able to see Search button text")
    public void SearchBtnTxtPres() throws Exception {
    	
    	test = extent.createTest("Verify_Search_button_Text_Present");
    	String Searchtext = DGHomePage.SearchBtnTxtVisible();
        Assert.assertEquals(Searchtext, "SEARCH");       
       
    } 
    
    @Test(priority = 13)
    @Severity(SeverityLevel.BLOCKER)
	@Description("Verify_Alphabet_Search_working") 
    @Story("User able to click on alphabet search")
    public void aplhabetSearchWok() throws Exception {
    	
    	test = extent.createTest("Verify_Alphabet_Search_working");
        Random random = new Random();
        String newAlpha = Character.toString((char) (random.nextInt(26) + 'A'));
        System.out.println("alphabet is: "+newAlpha);
    	String aplhaVal = DGHomePage.clickAlpha(newAlpha);
        Assert.assertEquals(aplhaVal, newAlpha);
       
    } 
    
    @Test(priority = 14)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Verify_Click_Here_For_Login_Btn") 
    @Story("User able to see Click Here For Login button")
    public void ClickHereForLoginPresent() throws Exception {
    	
    	test = extent.createTest("Verify_Click_Here_For_Login_Btn");
    	boolean btnPresent = DGHomePage.ClickHereLoginPres();
        Assert.assertTrue(btnPresent);
       
    }
    
    @Test(priority = 15)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Verify_Last_Updated_Date") 
    @Story("User able to see last updated date")
    public void LastUpdatedDate() throws Exception {
    	
    	test = extent.createTest("Verify_Last_Updated_Date");
    	String date = DGHomePage.LastUpdatedDate();
    	System.out.println("\u001B[32m"+"LAST UPDATED DATE IS : "+date+"\u001B[0m");
    	boolean datePresent = DGHomePage.VerifyLastUpdatedDate();
        Assert.assertTrue(datePresent);
        closeBrowserAfterTest();
    }
     
   
    
}
