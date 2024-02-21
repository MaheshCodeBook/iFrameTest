import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedNxtAppsTest {
    public static void main(String args[]) {
        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");

            // Launch the Chrome browser
            WebDriver driver = new ChromeDriver();

            // Navigate to the NxtApps Application
            driver.get("https://qanxtapps.ccbp.tech/");

            WebElement headingEle = driver.findElement(By.id("app-heading"));

            String expectedHeading = "My Applications";
            String actualHeading = headingEle.getText();
            if(expectedHeading.equals(actualHeading)){
                System.out.println("Acutal Heading Matched with the Expected Heading");
            }
            else {
                System.out.println("Acutal Heading is not Matched with the Expected Heading");
            }

            WebElement blogHubEle = driver.findElement(By.cssSelector("div.cards > :nth-child(2)"));
            blogHubEle.click();

            driver.switchTo().frame("appFrameCard");
            WebElement usernameEle = driver.findElement(By.className("user-name"));
            System.out.println(usernameEle.getText());

            WebElement aboutLink = driver.findElement(By.linkText("About"));
            aboutLink.click();

            driver.switchTo().frame("appFrameCard");

            WebElement aboutPageHeadingEle  = driver.findElement(By.className("about-me-section-heading"));

            expectedHeading = "About me";
            actualHeading = aboutPageHeadingEle.getText();

            if(expectedHeading.equals(actualHeading)){
                System.out.println("Acutal Heading Matched with the Expected Heading -- " + actualHeading);
            }
            else {
                System.out.println("Acutal Heading is not Matched with the Expected Heading -- "+ actualHeading);
            }
            //Switch to Parent iframe
            driver.switchTo().parentFrame();

            // Access Home Page link
            WebElement homeLink = driver.findElement(By.linkText("Home"));
            homeLink.click();

            usernameEle = driver.findElement(By.className("user-name"));
            System.out.println(usernameEle.getText());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
