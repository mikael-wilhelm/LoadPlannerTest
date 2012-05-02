package acceptanceTests;

import acceptanceTestHelper.RegisterLoad;
import acceptanceTestHelper.SignIn;
import asserters.AssertTextWasFound;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RegisterLoadTest {
    private WebDriver driver;

    @Before
    public void dummyTest(){
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/LoadPlannerMain-1.0-SNAPSHOT");
    }


    public void registerLoadTest(){

        String actualContent = "Cole";
        String actualHarbor ="Stockholm";
        String actualDestination = "Helsingfors";

        SignIn.signIn(driver);
        WebElement element = driver.findElement(By.linkText("Administrate Loads"));
        element.click();

        //SUT
        RegisterLoad.registerLoad(driver, actualContent, actualHarbor, actualDestination);
        element = driver.findElement(By.linkText("Show Loads"));
        element.click();

        AssertTextWasFound.assertTextWasFound(driver,actualContent,actualHarbor,actualDestination);
    }


    @After
    public void tearDownTest(){
         driver.quit();
    }


}
