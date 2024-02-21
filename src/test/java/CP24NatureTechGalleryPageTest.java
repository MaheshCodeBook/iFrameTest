import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP24NatureTechGalleryPageTest {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://qanaturegallery.ccbp.tech/");


            WebElement headingElement;
            WebElement descriptionElement;

            headingElement = driver.findElement(By.tagName("h1"));
            System.out.println(headingElement.getText());

            for (int i=0; i<3; i++){
                driver.switchTo().frame(i);

                headingElement = driver.findElement(By.tagName("h2"));
                System.out.println(headingElement.getText());

                descriptionElement = driver.findElement(By.tagName("p"));
                System.out.println(descriptionElement.getText());
                driver.switchTo().defaultContent();

            }










            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}