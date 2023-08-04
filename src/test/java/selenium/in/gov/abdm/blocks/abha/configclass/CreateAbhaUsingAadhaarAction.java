package selenium.in.gov.abdm.blocks.abha.configclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import selenium.in.gov.abdm.utility.FetchOTP;

import java.io.IOException;

public class CreateAbhaUsingAadhaarAction extends SeleniumBaseClass {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    //Actions act = new Actions(driver);
    FetchOTP fetchOtp = new FetchOTP();

    public boolean createAbhaBtn() throws Exception {
        WebElement createABHABtn = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "createABHANumberBtn", "abha")));
        Thread.sleep(9000);
        return createABHABtn.isDisplayed();
    }

    public void createAbhaBtnClick() throws Exception {
        WebElement createABHABtn = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "createABHANumberBtn", "abha")));
        createABHABtn.click();
        Thread.sleep(3000);

    }


    public boolean abhaUsingAadhaar() throws Exception {
        WebElement usingAadhaarOpt = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "usingAadhaarOpt", "abha")));
        // act.moveToElement(usingAadhaarOpt);
        boolean value = usingAadhaarOpt.isDisplayed();
        usingAadhaarOpt.click();
        Thread.sleep(2000);
        return value;
    }

    public boolean enterAadhaarNumber() throws InterruptedException, IOException {
        WebElement aadhaarField1 = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "AadhaarNumber1", "abha")));
        // act.moveToElement(aadhaarNumber1);
        aadhaarField1.click();
        Thread.sleep(1000);
        aadhaarField1.sendKeys("2360");
        Thread.sleep(1000);
        WebElement aadhaarField2 = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "AadhaarNumber2", "abha")));
        //act.moveToElement(aadhaarNumber2);
        aadhaarField2.click();
        Thread.sleep(2000);
        aadhaarField2.sendKeys("6487");
        Thread.sleep(1000);

        WebElement aadhaarField3 = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "AadhaarNumber3", "abha")));
        //act.moveToElement(aadhaarNumber3);
        aadhaarField3.click();
        Thread.sleep(2000);
        aadhaarField3.sendKeys("6582");
        Thread.sleep(2000);

        return aadhaarField3.isDisplayed();

    }
    public boolean tickIAgreeCheckbox() throws InterruptedException, IOException {
        //js.executeScript("window.scrollBy(0,500)");
        WebElement iAgreeCheckbox = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "I_Agree_Checkbox", "abha")));
        js.executeScript("arguments[0].scrollIntoView();", iAgreeCheckbox);
        boolean value = iAgreeCheckbox.isDisplayed();
        iAgreeCheckbox.click();
        Thread.sleep(1000);
        return value;
    }


    public boolean enterCaptcha() throws InterruptedException, IOException {
        WebElement enterCaptcha = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "Captcha_Textbox", "abha")));
        js.executeScript("arguments[0].scrollIntoView();", enterCaptcha);
        boolean value = enterCaptcha.isDisplayed();
        enterCaptcha.click();
        enterCaptcha.sendKeys("5");
        Thread.sleep(1000);
        return value;
    }

    public boolean clickNextButton() throws IOException, InterruptedException {
        WebElement nextBtn = driver.findElement(By.xpath(readXpath("abhaUsingAddhaarXpaths", "nextButton", "abha")));
        js.executeScript("arguments[0].scrollIntoView();", nextBtn);
        nextBtn.click();
        Thread.sleep(2000);
        return nextBtn.isEnabled();

    }

}