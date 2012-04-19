package acceptanceTests;

import acceptanceTestHelper.RegisterLoad;
import asserters.AssertTextWasFound;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import sun.awt.color.ProfileActivator;

import java.io.File;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


public class RegisterLoadTest {
    private WebDriver driver;

    @Before
    public void dummyTest(){


        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/LoadPlannerMain-1.0-SNAPSHOT");
    }

    @Test
    public void registerLoadTest(){
        String actualContent = "Cole";
        String actualHarbor ="Stockholm";
        String actualDestination = "Helsingfors";
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
