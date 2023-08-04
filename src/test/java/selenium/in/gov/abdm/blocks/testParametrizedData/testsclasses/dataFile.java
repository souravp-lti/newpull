package selenium.in.gov.abdm.blocks.testParametrizedData.testsclasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import selenium.in.gov.abdm.listeners.AllureListener;

@Listeners(AllureListener.class)
public class dataFile{

    @DataProvider(name = "test-data")
    public static Object[][] dataProvFunc() {
        return new Object[][]{
                {"apple"}, {"orange"}
        };


    }
}
