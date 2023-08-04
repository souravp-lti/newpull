package selenium.in.gov.abdm.blocks.drugregistry.testsclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import selenium.in.gov.abdm.blocks.drugregistry.configclass.AdminLoginAction;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.listeners.AllureListener;

//CHECKS ALL THE FEATURES ARE PRESENT IN THE HOMEPAGE
@Listeners(AllureListener.class)
public class AdminLoginTest extends SeleniumBaseClass{
	
	AdminLoginAction AdminLog;
   
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
	@Description("Check_We_nav_to_Admin_Login") 
    @Story("Check we navigated to Admin Login Page")
    public void NavAdminLogin() throws Exception {
    	
    	test = extent.createTest("Check_We_nav_to_Admin_Login");
    	AdminLog = new AdminLoginAction();
    	AdminLog.AdminLoginClick();
    	String AdminLogtxt = AdminLog.AdminLoginPage();
        Assert.assertEquals(AdminLogtxt, "Admin Login");       
       
    }
    
    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_Username_Logo_Present") 
    @Story("Check Username Logo Present")
    public void UserNamePres() throws Exception {
    	
    	test = extent.createTest("Check_Username_Logo_Present");
    	AdminLog.AdminLoginClick();
    	String UserNameTxt = AdminLog.UserNamePresent();
        Assert.assertEquals(UserNameTxt, "Username*");       
       
    }
    
    @Test(priority = 5)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Check_Password_Logo_Present") 
    @Story("Check Password Logo Present")
    public void PasswordPres() throws Exception {
    	
    	test = extent.createTest("Check_Password_Logo_Present");
    	String PassTxt = AdminLog.passwordPresent();
        Assert.assertEquals(PassTxt, "Password*");       
       
    }
    
    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check Username text box Present")
    @Story("Check Username text box Present")
    public void UserNametxtPres() throws Exception {
    	
    	test = extent.createTest("Check Username text box Present");
    	boolean UserNamebox = AdminLog.UserNametxtBoxDis();
        Assert.assertTrue(UserNamebox);
       
    }
    
    @Test(priority = 7)
    @Severity(SeverityLevel.MINOR)
	@Description("Check Password text box Present")
    @Story("Check Password text box Present")
    public void PasstxtPres() throws Exception {
    	
    	test = extent.createTest("Check Password text boxPresent");
    	boolean Passbox = AdminLog.PasstxtBoxDis();
        Assert.assertTrue(Passbox);
       
    }
    
    @Test(priority = 8)
    @Severity(SeverityLevel.TRIVIAL)
	@Description("Login_And_check_landing") 
    @Story("Login and check whether you reached landing page")
    public void LoginAdmin() throws Exception {
    	
    	test = extent.createTest("Login_And_check_landing");
    	AdminLog.AdminLoginClick();
    	AdminLog.UserNameVal(readXpath("AdminLoginXpaths","AdminUser","drugregistry"));
    	AdminLog.PasswordVal(readXpath("AdminLoginXpaths","AdminPass","drugregistry"));
    	AdminLog.loginClick();
    	boolean LandPg = AdminLog.LandPgDis();
        Assert.assertTrue(LandPg);
       
    }
    
    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_label_in_Submitted") 
    @Story("Check label in Submitted ")
    public void SubmitLabelFetch() throws Exception {
    	
    	test = extent.createTest("Check_label_in_Submitted");
    	String SubmitLabel = AdminLog.tabName("1");
        Assert.assertEquals(SubmitLabel, "Submitted");   
    	
    }
    
    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_value_in_Submitted") 
    @Story("Check value in Submitted ")
    public void SubmitValFetch() throws Exception {
    	
    	test = extent.createTest("Check_value_in_Submitted");
    	String SubmitVal = AdminLog.tabNum("1");
    	String bottomValSubmit = AdminLog.CheckValAtBottom();
      	Assert.assertEquals(SubmitVal, bottomValSubmit);
    	
    }
    
    @Test(priority = 11)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_label_in_Approved") 
    @Story("Check label in Approved ")
    public void ApprovedLabelFetch() throws Exception {
    	
    	test = extent.createTest("Check_label_in_Approved");
    	String ApprovedLabel = AdminLog.tabName("2");
        Assert.assertEquals(ApprovedLabel, "Approved");   
    	
    }
    
    @Test(priority = 12)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_value_in_Approved") 
    @Story("Check value in Approved ")
    public void ApprovedValFetch() throws Exception {
    	
    	test = extent.createTest("Check_value_in_Approved");
    	String ApprovedVal = AdminLog.tabNum("2");
    	String bottomValApproved = AdminLog.CheckValAtBottom();
      	Assert.assertEquals(ApprovedVal, bottomValApproved);
    	
    }
    
    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_label_in_Deactivated") 
    @Story("Check label in Deactivated")
    public void DeactivatedLabelFetch() throws Exception {
    	
    	test = extent.createTest("Check_label_in_Deactivated");
    	String DeactivatedLabel = AdminLog.tabName("3");
        Assert.assertEquals(DeactivatedLabel, "Deactivated");   
    	
    }
    
    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_value_in_Deactivated") 
    @Story("Check value in Deactivated ")
    public void DeactivatedValFetch() throws Exception {
    	
    	test = extent.createTest("Check_value_in_Deactivated");
    	String DeactivatedVal = AdminLog.tabNum("3");
    	String bottomValDeactivated = AdminLog.CheckValAtBottom();
      	Assert.assertEquals(DeactivatedVal, bottomValDeactivated);
    	
    }
    
    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_label_in_Rejected") 
    @Story("Check label in Rejected")
    public void RejectedLabelFetch() throws Exception {
    	
    	test = extent.createTest("Check_label_in_Rejected");
    	String RejectedLabel = AdminLog.tabName("4");
        Assert.assertEquals(RejectedLabel, "Rejected");   
    	
    }
    
    @Test(priority = 16)
    @Severity(SeverityLevel.CRITICAL)
	@Description("Check_value_in_Rejected") 
    @Story("Check value in Deactivated ")
    public void RejectedValFetch() throws Exception {
    	
    	test = extent.createTest("Check_value_in_Rejected");
    	String RejectedVal = AdminLog.tabNum("4");
    	String bottomValRejected = AdminLog.CheckValAtBottom();
      	Assert.assertEquals(RejectedVal, bottomValRejected);
        closeBrowserAfterTest();
    }


     
}
