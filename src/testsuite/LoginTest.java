package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);//opening browser
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");//finding element for username and send value
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");//finding element for username and send key
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();//finding element and click
        String expectedMessage = "Secure Area";//Storing the expected message
        WebElement actualMessage = driver.findElement(By.xpath("//h2[contains(text(),' Secure Area')]"));//Actual message finding element
        String actualMessage1 = actualMessage.getText();//Actual message Storing
        //System.out.println(actualMessage1);
       Assert.assertEquals("Error Message is not Displayed",expectedMessage,actualMessage1);//Comparing the both element
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith1");//finding element for username and send value
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");//finding element for username and send key
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();//finding element and click
        //verifying the error message is displayed or not
        String expectedMessage = "Your username is invalid!";//Storing the expected message
        WebElement actualMessage = driver.findElement(By.xpath("//div[@id='flash']"));//Actual message finding element
        String actualMessageText = actualMessage.getText().substring(0,25);//Actual message Storing
       // System.out.println(actualMessageText);
        Assert.assertEquals("Your username is invalid",expectedMessage,actualMessageText);//Comparing the both element

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");//finding element for username and send value
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");//finding element for username and send key
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();//finding element and click
        String expectedText = "Your password is invalid!";//Storing the expected message
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));//Actual message finding element
        String actualText = actualTextElement.getText().substring(0,25);//Actual message Storing
        Assert.assertEquals(expectedText, actualText);//Comparing the both element

    }

    @After
    public void tearDown() {
        driver.quit();
        //  closeBrowser();
    }

}
