package selenium.in.gov.abdm.blocks.abha.testsclasses;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.blocks.abha.configclass.CreateAbhaUsingAadhaarAction;

import java.io.IOException;

public class CreateAbhaUsingAadhaarTest extends SeleniumBaseClass {

    CreateAbhaUsingAadhaarAction createAbhaAadhaar;
    @BeforeClass
    public void user_Launch_Chrome_browser() throws IOException, InterruptedException {
        test = extent.createTest("user_Launch_Chrome_browser_and_open_ABHA_URL");
        initialization();
        Thread.sleep(2000);
        driver.get(readXpath("config","URL","abha"));
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify User clicks on create ABHA number button")
    public void verifyCreateABHABtn() throws Exception {
        test = extent.createTest("Verify_create_ABHA_number_button is_clicked");
        createAbhaAadhaar = new CreateAbhaUsingAadhaarAction();
        boolean value = createAbhaAadhaar.createAbhaBtn();
        Assert.assertEquals(value, true);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify User select create ABHA using Aadhaar option")
    public void verifyAbhaUsingAadhaar() throws Exception {
        test = extent.createTest("Verify_create_ABHA_using Aadhaar_option_is_selected");
        createAbhaAadhaar.createAbhaBtnClick();
        boolean value = createAbhaAadhaar.abhaUsingAadhaar();
        Assert.assertEquals(value, true);

    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify User enter Aadhaar number")
    public void verifyEnterAadhaarNumber() throws IOException, InterruptedException {
        test = extent.createTest("Verify_Aadhaar_number_is_entered");
        boolean value = createAbhaAadhaar.enterAadhaarNumber();
        Assert.assertEquals(value, true);

    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify User clicks on I Agree checkbox")
    public void verifyTickIAgreeCheckbox() throws IOException, InterruptedException {
        test = extent.createTest("Verify_user_clicks_I_Agree_checkbox");
        boolean value = createAbhaAadhaar.tickIAgreeCheckbox();
        Assert.assertEquals(value, true);

    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify User enters the captcha")
    public void verifyEnterCaptcha() throws IOException, InterruptedException {
        test = extent.createTest("Verify_user_enter_the_captcha");
        boolean value = createAbhaAadhaar.enterCaptcha();
        Assert.assertEquals(value, true);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user clicks on Next button")
    public void verifyClickNextButton() throws IOException, InterruptedException {
        test = extent.createTest("Verify_user_clicks_on_next_button");
        boolean value = createAbhaAadhaar.clickNextButton();
        Assert.assertEquals(value, true);
        Thread.sleep(5000);
    }

    @AfterClass
    public void closeWin() {
        driver.close();
    }


}