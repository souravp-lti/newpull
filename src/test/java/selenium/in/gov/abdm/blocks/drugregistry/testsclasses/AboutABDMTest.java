package selenium.in.gov.abdm.blocks.drugregistry.testsclasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import selenium.in.gov.abdm.blocks.drugregistry.configclass.AboutABDMAction;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.listeners.AllureListener;

//CHECKS ALL THE FEATURES ARE PRESENT IN THE HOMEPAGE
@Listeners(AllureListener.class)
public class AboutABDMTest extends SeleniumBaseClass {
	
	AboutABDMAction AbtABDMPage;
   
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
    	driver.get(readXpath("config","URL","drugregistry"));
        Thread.sleep(10000);
        //Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Abt_ABDM_logo") 
    @Story("User able to see About ABDM logo")
    public void verifyAbtABDMlogo() throws Exception {
    	
    	test = extent.createTest("Verify_Abt_ABDM_logo");
    	AbtABDMPage = new AboutABDMAction();
    	AbtABDMPage.abtABDmPage();
    	String AbtABDM = AbtABDMPage.abtABDmLogo();
        Assert.assertEquals(AbtABDM, "About ABDM");
       
    }
    
    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify ABDM Full form_button")
    @Story("User able to see ABDM full form")
    public void verifyABDMFullform() throws Exception {
    	
    	test = extent.createTest("Verify_ABDM_Fullform_button");
    	String ABDMfullForm = AbtABDMPage.ABDMfullForm();
        Assert.assertEquals(ABDMfullForm, "Ayushman Bharat Digital Mission (ABDM)");       
       
    }
    
    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_About_button_present") 
    @Story("User able to see About button")
    public void AboutBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_About_button_present");
    	boolean AbtBtnpre = AbtABDMPage.AbtBtnVisible();
        Assert.assertTrue(AbtBtnpre);
       
    }
    
    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_About_button_text") 
    @Story("User able to see About text")
    public void AboutBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_About_button_text");
    	String AbtBtnTxt = AbtABDMPage.AbtBtnTxt();
        Assert.assertEquals(AbtBtnTxt, "About");
       
    }
    
    @Test(priority = 7)
    @Severity(SeverityLevel.MINOR)
	@Description("Verify_Background_button_present") 
    @Story("User able to see Background button")
    public void BackgroundBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_Background_button_present");
    	boolean BackgroundBtnpre = AbtABDMPage.BackgroundBtnVisible();
        Assert.assertTrue(BackgroundBtnpre);
       
    }
    
    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
	@Description("Verify_Background_button_text") 
    @Story("User able to see About text")
    public void BackgroundBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Background_button_text");
    	String BackgroundBtnTxt = AbtABDMPage.BackgroundBtnTxt();
        Assert.assertEquals(BackgroundBtnTxt, "Background");
       
    }
    
    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Vision_button_present") 
    @Story("User able to see Vision button")
    public void VisionBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_Vision_button_present");
    	boolean VisionBtnpre = AbtABDMPage.VisionBtnVisible();
        Assert.assertTrue(VisionBtnpre);
       
    }
    
    @Test(priority = 10)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Verify_Vision_button_text") 
    @Story("User able to see Vision text")
    public void VisionBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Vision_button_text");
    	String VisionBtnTxt = AbtABDMPage.VisionBtnTxt();
        Assert.assertEquals(VisionBtnTxt, "Vision");
       
    }
    
    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Object_button_present") 
    @Story("User able to see Object button")
    public void ObjectBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_Object_button_present");
    	boolean ObjectBtnpre = AbtABDMPage.ObjectBtnVisible();
        Assert.assertTrue(ObjectBtnpre);
       
    }
    
    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Object_button_text") 
    @Story("User able to see Object text")
    public void ObjectBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Object_button_text");
    	String ObjectBtnTxt = AbtABDMPage.ObjectBtnTxt();
        Assert.assertEquals(ObjectBtnTxt, "Objectives");
       
    }
    
    @Test(priority = 13)
    @Severity(SeverityLevel.MINOR)
	@Description("Verify_Opportunities_button_present") 
    @Story("User able to see Opportunities button")
    public void OppBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_Opportunities_button_present");
    	boolean OppBtnpre = AbtABDMPage.OppBtnVisible();
        Assert.assertTrue(OppBtnpre);
       
    }
    
    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Opportunities_button_text") 
    @Story("User able to see Opportunities text")
    public void OppBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Opportunities_button_text");
    	String OppBtnTxt = AbtABDMPage.OppBtnTxt();
        Assert.assertEquals(OppBtnTxt, "Opportunities");
       
    }
    
    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Benefits_button_present") 
    @Story("User able to see Benefits button")
    public void BenefitsBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_Benefits_button_present");
    	boolean BenBtnpre = AbtABDMPage.BenBtnVisible();
        Assert.assertTrue(BenBtnpre);
       
    }
    
    @Test(priority = 16)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Benefits_button_text") 
    @Story("User able to see Benefits text")
    public void BenBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Benefits_button_text");
    	String BenBtnTxt = AbtABDMPage.BenBtnTxt();
        Assert.assertEquals(BenBtnTxt, "Benefits");
       
    }
    
    @Test(priority = 17)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Principles_button_present") 
    @Story("User able to see Principles button")
    public void PrincBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_Principles_button_present");
    	boolean PrincBtnpre = AbtABDMPage.PrincBtnVisible();
        Assert.assertTrue(PrincBtnpre);
       
    }
    
    @Test(priority = 18)
    @Severity(SeverityLevel.MINOR)
	@Description("Verify_Principles_button_text") 
    @Story("User able to see Principles text")
    public void PrincBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Principles_button_text");
    	String PrincBtnTxt = AbtABDMPage.PrincBtnTxt();
        Assert.assertEquals(PrincBtnTxt, "Principles");
       
    }
    
    @Test(priority = 19)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Building_Blocks_button_present") 
    @Story("User able to see Building Blocks button")
    public void BuildBlBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_Building_Blocks_button_present");
    	boolean BuildBlBtnpre = AbtABDMPage.BuildBlBtnVisible();
        Assert.assertTrue(BuildBlBtnpre);
       
    }
    
    @Test(priority = 20)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Building_Blocks_button_text") 
    @Story("User able to see Building Blocks text")
    public void BuildBlBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Building_Blocks_button_text");
    	String BuildBlBtnTxt = AbtABDMPage.BuildBlBtnTxt();
        Assert.assertEquals(BuildBlBtnTxt, "Building Blocks");
       
    }
    @Test(priority = 21)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Architecture_button_present") 
    @Story("User able to see Architecture button")
    public void ArchBtnPres() throws Exception {
    	
    	test = extent.createTest("Verify_Architecture_button_present");
    	boolean ArchBtnpre = AbtABDMPage.ArchBtnVisible();
        Assert.assertTrue(ArchBtnpre);
       
    }
    
    @Test(priority = 22)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Architecture_button_text") 
    @Story("User able to see Architecture text")
    public void ArchBtnTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Architecture_button_text");
    	String ArchBtnTxt = AbtABDMPage.ArchBtnTxt();
        Assert.assertEquals(ArchBtnTxt, "Architecture");
        closeBrowserAfterTest();
    }

}
