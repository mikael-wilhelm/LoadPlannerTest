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

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ReserveLoadTest {
    private WebDriver driver;
    @Before
    public void dummyTest(){
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/LoadPlannerMain-1.0-SNAPSHOT");
    }


    public void reserveLoadTest(){
        String actualContent = "reservableContent";
        String actualHarbor ="Stockholm";
        String actualDestination = "Helsingfors";

        SignIn.signIn(driver);

        WebElement element = driver.findElement(By.linkText("Administrate Loads"));
        element.click();
        RegisterLoad.registerLoad(driver, actualContent, actualHarbor, actualDestination);
        element = driver.findElement(By.linkText("Show Loads"));
        element.click();

        //SUT
        reserveLoad(actualContent);
        element = driver.findElement(By.linkText("Administrate Loads"));
        element.click();
        AssertTextWasFound.assertTextWasFound(driver,actualContent,actualHarbor,actualDestination);
    }

    private void reserveLoad(String contentToReserve){
        WebElement element = driver.findElement(By.linkText(contentToReserve));
        element.click();
    }

    @After
    public void tearDownTest(){
         driver.quit();
    }


}
