import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NxtAppsTest {
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

            // Switch to the iframe
            driver.switchTo().frame("appFrameCard");

            // Locate and Verify Username
            WebElement usernameEle = driver.findElement(By.className("user-name"));
            System.out.println(usernameEle.getText());
            String expectedUsername = "Wade Warren";
            String actualUsername = usernameEle.getText();
            if(expectedUsername.equals(actualUsername)){
                System.out.println("Acutal Username Matched with the Expected Username");
            }
            else {
                System.out.println("Acutal Username is not Matched with the Expected Username");
            }
            //Switch to default content
            driver.switchTo().defaultContent();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}