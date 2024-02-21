import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CP24IOTPageTest {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://qaiotlorawan.ccbp.tech/");

            WebElement headingElement = driver.findElement(By.tagName("h1"));
            System.out.println(headingElement.getText());

            driver.switchTo().frame("conference");

            WebElement headingFrameElement = driver.findElement(By.className("conference-title"));
            System.out.println(headingFrameElement.getText());

            WebElement knowMoreButton = driver.findElement(By.className("btn"));
            knowMoreButton.click();


            WebElement iframeElement = driver.findElement(By.className("embed-responsive-item"));
            driver.switchTo().frame(iframeElement);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ytp-title-text")));

            WebElement videoTitleElement = driver.findElement(By.className("ytp-title-text"));
            String expectedText = "The Things Conference India 2019 | After Movie";
            String actualText = videoTitleElement.getText();
            if(actualText.equals(expectedText)) {
                System.out.println("Video title matched");
            } else {
                System.out.println("Mismatch found in the video title");
            }

            driver.switchTo().parentFrame();

            headingElement = driver.findElement(By.tagName("h1"));
            expectedText = "The Things Conference";
            actualText = headingElement.getText();
            if(actualText.equals(expectedText)) {
                System.out.println("Heading matched");
            } else {
                System.out.println("Mismatch found in the heading");
            }










            Thread.sleep(4000);
            driver.quit();

        } catch (Exception e) {
            System.out.println("The Exception is: " + e);
        }
    }
}
