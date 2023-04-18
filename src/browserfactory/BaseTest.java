package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        //launch URl
        driver.get(baseUrl);
        //maximize the window
        driver.manage().window().maximize();
        //implicit timeout for method
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public  void closeBrowser(){
        //closing the browser code
        driver.quit();
    }}
