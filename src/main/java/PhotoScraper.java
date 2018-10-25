import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by GlareMasters
 * Date: 10/25/2018
 * Time: 12:50 PM
 */
public class PhotoScraper {

    private static File file = new File("src/main/resources/chromedriver.exe");
    private static String absolutePath = file.getAbsolutePath();


    public static void main(String[] args) throws URISyntaxException {
        System.setProperty("webdriver.chrome.driver", absolutePath);

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }


}
