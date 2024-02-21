import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP24TravellingGuidePageTest {
    public static void main(String[] args) {
        try {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://qatravelguide.ccbp.tech/");

        WebElement varanasiBtn = driver.findElement(By.id("varanasi"));
        varanasiBtn.click();

        driver.switchTo().frame("frame");

        WebElement aboutVaranasi = driver.findElement(By.id("aboutTabContent"));
        System.out.println(aboutVaranasi.getText());

        WebElement timeToVisitButton = driver.findElement(By.id("timeToVisitButton"));
        timeToVisitButton.click();

        WebElement timeToVisitVaranasi = driver.findElement(By.id("timeToVisitTabContent"));
        System.out.println(timeToVisitVaranasi.getText());

        WebElement attractionsButton = driver.findElement(By.id("attractionsButton"));
        attractionsButton.click();

        WebElement attractionsVaranasi = driver.findElement(By.id("attractionsTabContent"));
        System.out.println(attractionsVaranasi.getText());

        driver.quit();

    }catch(Exception e){
        System.out.println("The Exception is: "+e);
    }
    }

}
