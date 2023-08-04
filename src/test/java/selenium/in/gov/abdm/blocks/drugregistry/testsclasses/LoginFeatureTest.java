package selenium.in.gov.abdm.blocks.drugregistry.testsclasses;

import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import selenium.in.gov.abdm.blocks.drugregistry.configclass.LoginFeaturesAction;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.listeners.AllureListener;

import java.util.concurrent.TimeUnit;

//CHECKS ALL THE FEATURES ARE PRESENT IN THE HOMEPAGE
@Listeners(AllureListener.class) 
public class LoginFeatureTest extends SeleniumBaseClass{
	
	LoginFeaturesAction LoginFeat;
   
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
    	Thread.sleep(10000);
        //Awaitility.await().atMost(1000, TimeUnit.MILLISECONDS);
    }
    
    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Login_&_regd_btn_text_is_present") 
    @Story("Click Here For Login & regd btn text is present")
    public void LoginRegdPresent() throws Exception {
    	
    	test = extent.createTest("Login_regd_btn_text_is_present");
    	LoginFeat = new LoginFeaturesAction();
    	String LoginRegdTxt = LoginFeat.LoginRegdTxt();
        Assert.assertEquals(LoginRegdTxt, "CLICK HERE FOR LOGIN/REGISTRATION (MANUFACTURER)");
       
    }
    
    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Login_to_your_Acc_present") 
    @Story("Login to your account text is present")
    public void LogintoAccPresent() throws Exception {
    	
    	test = extent.createTest("Login_to_your_Acc_present");
    	LoginFeat.LoginRegdClick();
    	String LogintoAccTxt = LoginFeat.LoginToAccTxt();
        Assert.assertEquals(LogintoAccTxt, "Login to your Account");       
       
    }
    
    @Test(priority = 5)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("For_Existing_user_present") 
    @Story("For Existing user text is present")
    public void ForExistUserPresent() throws Exception {
    	
    	test = extent.createTest("For_Existing_user_present");
    	String ForExistUserTxt = LoginFeat.ForExistUserTxt();
        Assert.assertEquals(ForExistUserTxt, "For Existing User");       
       
    }
    
    @Test(priority = 6)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("For_New_user_present") 
    @Story("For New user text is present")
    public void ForNewUserPresent() throws Exception {
    	
    	test = extent.createTest("For_New_user_present");
    	String ForNewUserTxt = LoginFeat.ForNewUserTxt();
        Assert.assertEquals(ForNewUserTxt, "For New User");       
       
    }
    
    @Test(priority = 7)
    @Severity(SeverityLevel.MINOR)
	@Description("Login_txt_present") 
    @Story("Login text is present")
    public void LoginBtnPresent() throws Exception {
    	
    	test = extent.createTest("Login_txt_present");
    	String LoginTxt = LoginFeat.LoginTxtPres();
        Assert.assertEquals(LoginTxt, "Login");       
       
    }
    
    @Test(priority = 8)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Username_radio_btn_present") 
    @Story("Username text is present")
    public void UserTxtPresent() throws Exception {
    	
    	test = extent.createTest("Username_radio_btn_present");
    	String UserTxt = LoginFeat.UserIDTxt();
        Assert.assertEquals(UserTxt, "User ID / Username");       
       
    }
    
    @Test(priority = 9)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Mobile_radio_btn_present") 
    @Story("Mobile text is present")
    public void MobilePresent() throws Exception {
    	
    	test = extent.createTest("Mobile_radio_btn_present");
    	String MobileTxt = LoginFeat.MobileNumTxt();
        Assert.assertEquals(MobileTxt, "Mobile Number");       
       
    }
    
    @Test(priority = 10)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("UserId_txt_box_present") 
    @Story("UserId btn text is present")
    public void userIdBoxPresent() throws Exception {
    	
    	test = extent.createTest("UserId_txt_box_present");
    	String userBoxPres = LoginFeat.UserIDBoxTxt();
        Assert.assertEquals(userBoxPres, "User ID / Username*");       
       
    }
    
    @Test(priority = 11)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("UserId_box_present") 
    @Story("UserId box is present")
    public void userIdTxtBoxPresent() throws Exception {
    	
    	test = extent.createTest("UserId_box_present");
    	boolean userIdTxtBoxPres = LoginFeat.UserIDTxtBox();
        Assert.assertTrue(userIdTxtBoxPres);
       
    }
    
    @Test(priority = 12)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Login_Btn_is_present") 
    @Story("UserId box is present")
    public void LoginBtTxtBoxnPresent() throws Exception {
    	
    	test = extent.createTest("Login_Btn_is_present");
    	boolean LoginBtn = LoginFeat.LoginBtn();
        Assert.assertTrue(LoginBtn);
       
    }
    
    @Test(priority = 13)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Login_Btn_Txt_bar_is_present") 
    @Story("Login btn txt is present")
    public void LoginBtTxtBoxTxtPresent() throws Exception {
    	
    	test = extent.createTest("Login_Btn_Txt_bar_is_present");
    	String LoginTxtBtn = LoginFeat.LogintxtBtn();
        Assert.assertEquals(LoginTxtBtn, "LOGIN");       
       
    }
    
    @Test(priority = 14)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Check_Submit_Btn_in_Mobile_page") 
    @Story("Submit Btn is present")
    public void SubmitBtnIsPres() throws Exception {
    	
    	test = extent.createTest("Check_Submit_Btn_in_Mobile_page");
    	LoginFeat.MobileNumClick();
    	boolean SubmitBtn = LoginFeat.SubmitBtnVisible();
        Assert.assertTrue(SubmitBtn);
       
    }
    
    @Test(priority = 15)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Check_Submit_Btn_txt_in_Mobile_Page") 
    @Story("Submit Btn text is present")
    public void SubmitBtnTxt() throws Exception {
    	
    	test = extent.createTest("Check_Submit_Btn_txt_in_Mobile_Page");
    	String SubmitTxt = LoginFeat.SubmitBtnTxt();
        Assert.assertEquals(SubmitTxt, "SUBMIT");       
       
    }
    
    @Test(priority = 16)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Check_Register_Btn_txt_in_new_User_Page") 
    @Story("Register as Manufacturer Btn text is present")
    public void RegisAsManuTxt() throws Exception {
    	
    	test = extent.createTest("Check_Register_Btn_txt_in_new_User_Page");
    	LoginFeat.ForNewUserClick();
    	String RegisterTxt = LoginFeat.RegisAsManuTxt();
        Assert.assertEquals(RegisterTxt, "REGISTER AS MANUFACTURER");       
       
    }
    
    @Test(priority = 17)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Check_Register_Btn_in_new_User_Page") 
    @Story("Register as Manufacturer Btn is present")
    public void RegisAsManuBtn() throws Exception {
    	
    	test = extent.createTest("Check_Register_Btn_in_new_User_Page");
    	boolean RegisterBtn = LoginFeat.RegisAsManuVisible();
        Assert.assertTrue(RegisterBtn);
       
    }
    
    @Test(priority = 18)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Already_exist_user_is_present") 
    @Story("Already have a User id is present")
    public void AlredayHaveisPres() throws Exception {
    	
    	test = extent.createTest("Already_exist_user_is_present");
    	String AlredayPres = LoginFeat.AlreadyHavUser();
        Assert.assertEquals(AlredayPres, "Already have a User ID?Login Now");
        closeBrowserAfterTest();
    }
    
}
