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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;


public class RegisterLoadTest {
    private WebDriver driver;

    @Before
    public void dummyTest(){


        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/LoadPlannerMain-1.0-SNAPSHOT");
    }

    @Test
    public void registerLoadTest(){


        WebElement element = driver.findElement(By.id("linkForm:administrateLoadLink"));
        element.click();
        element = driver.findElement(By.id("registerLoadForm:contentInput"));
        element.clear();
        element.sendKeys("Cole");
        element = driver.findElement(By.id("registerLoadForm:registerLoadButton")) ;
        element.click();
        element = driver.findElement(By.id("linkForm:showLoads"));
        element.click();
        element = driver.findElement(By.xpath("//td[contains(.,'Cole')]"));

        assertNotNull(element);

    }

    @After
    public void tearDownTest(){
         driver.quit();
    }


}
