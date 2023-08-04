package selenium.in.gov.abdm.blocks.drugregistry.testsclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import selenium.in.gov.abdm.blocks.drugregistry.configclass.ContactUsAction;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.listeners.AllureListener;

//CHECKS ALL THE FEATURES ARE PRESENT IN THE HOMEPAGE
@Listeners(AllureListener.class)
public class ContactUsTest extends SeleniumBaseClass{
	
	ContactUsAction ContactUsPage;
   
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
    @Severity(SeverityLevel.MINOR)
	@Description("Verify_Contact_Us_logo") 
    @Story("User able to see Contact Us logo")
    public void verifyContactUsABDMlogo() throws Exception {
    	
    	test = extent.createTest("Verify_Contact_Us_logo");
    	ContactUsPage = new ContactUsAction();
    	ContactUsPage.contactUsPage();
    	String contactUs = ContactUsPage.contactUsLogo();
        Assert.assertEquals(contactUs, "Contact Us");       
       
    }
    
    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Name_logo") 
    @Story("User able to see Name logo")
    public void verifyNamelogo() throws Exception {
    	
    	test = extent.createTest("Verify_Name_logo");
    	String nameLogo = ContactUsPage.nameTxtPresent();
        Assert.assertEquals(nameLogo, "Name");       
       
    }
    
    @Test(priority = 5)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Verify Name text box logo")
    @Story("User able to see Name textBox")
    public void verifyNametxtBox() throws Exception {
    	
    	test = extent.createTest("Verify Name text box");
    	boolean nametxtbox = ContactUsPage.nameTxtBoxVisible();
        Assert.assertTrue(nametxtbox);
       
    }
    
    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Email_logo") 
    @Story("User able to see Email logo")
    public void verifyEmaillogo() throws Exception {
    	
    	test = extent.createTest("Verify_Email_logo");
    	String emailLogo = ContactUsPage.emailTxtPresent();
        Assert.assertEquals(emailLogo, "Email");       
       
    }
    
    @Test(priority = 7)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Verify Email text box logo")
    @Story("User able to see Email textBox")
    public void verifyEmailtxtBox() throws Exception {
    	
    	test = extent.createTest("Verify Email text box");
    	boolean Emailtxtbox = ContactUsPage.emailTxtBoxVisible();
        Assert.assertTrue(Emailtxtbox);
       
    }
    
    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Mobile_logo") 
    @Story("User able to see Mobile logo")
    public void verifymobilelogo() throws Exception {
    	
    	test = extent.createTest("Verify_mobile_logo");
    	String mobileLogo = ContactUsPage.mobileTxtPresent();
        Assert.assertEquals(mobileLogo, "Mobile");       
       
    }
    
    @Test(priority = 9)
    @Severity(SeverityLevel.MINOR)
	@Description("Verify Mobile text box logo")
    @Story("User able to see Mobile textBox")
    public void verifyMobiletxtBox() throws Exception {
    	
    	test = extent.createTest("Verify mobile textbox");
    	boolean mobiletxtbox = ContactUsPage.mobileTxtBoxVisible();
        Assert.assertTrue(mobiletxtbox);
       
    }
    
    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Message_logo") 
    @Story("User able to see Message logo")
    public void verifyMessagelogo() throws Exception {
    	
    	test = extent.createTest("Verify_Message_logo");
    	String MessageLogo = ContactUsPage.messageTxtPresent();
        Assert.assertEquals(MessageLogo, "Message");       
       
    }
    
    @Test(priority = 11)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Verify_Message_textbox_logo") 
    @Story("User able to see Message textBox")
    public void verifyMessagetxtBox() throws Exception {
    	
    	test = extent.createTest("Verify_Message_textbox");
    	boolean Messagetxtbox = ContactUsPage.messageTxtBoxVisible();
        Assert.assertTrue(Messagetxtbox);
       
    }
    
    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Address_txt") 
    @Story("User able to see Address text")
    public void verifyAddTxt() throws Exception {
    	
    	test = extent.createTest("Verify_Address_txt");
    	String AddressTxt = ContactUsPage.AddTxtPresent();
        Assert.assertEquals(AddressTxt, "ADDRESS");       
       
    }
    
    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Address_Details") 
    @Story("User able to see Address Details")
    public void verifyAddDetails() throws Exception {
    	
    	test = extent.createTest("Verify_Address_Details");
    	String AddressDet = ContactUsPage.addDetailsPresent();
        Assert.assertEquals(AddressDet, "9th Floor, Tower-l, Jeevan Bharati Building, Connaught Place, New Delhi - 110001");       
       
    }
    
    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Verify_Submit_Btn") 
    @Story("User able to see Submit Button")
    public void verifySubmitBtn() throws Exception {
    	
    	test = extent.createTest("Verify_Submit_Btn");
    	String SubBtn = ContactUsPage.submitBtnPresent();
        Assert.assertEquals(SubBtn, "SUBMIT");
        closeBrowserAfterTest();
    }
   
}
