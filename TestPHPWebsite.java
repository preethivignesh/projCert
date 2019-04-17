package website;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
 
public class TestPHPWebsite {
 
        public static void main(String[] args) throws IOException, InterruptedException {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\preet\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--no-sandbox");
 
                WebDriver driver = new ChromeDriver(chromeOptions);
 
                driver.get("http://ec2-54-226-38-2.compute-1.amazonaws.com:8000/");
 
                Thread.sleep(1000);
                
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
 
                String sampleText = driver.findElement(By.id("About Us")).getText();
                driver.findElement(By.id("About Us")).click();
                Thread.sleep(5000);
                Assert.assertEquals(sampleText, "About Us");
                Thread.sleep(5000);
                System.out.println("Test Completed");
                driver.quit();
        }
}
