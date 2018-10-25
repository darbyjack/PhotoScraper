import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by GlareMasters
 * Date: 10/25/2018
 * Time: 12:50 PM
 */
public class PhotoScraper {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        String url = args[0];
        String memberCount = args[1];

        WebDriver driver = new ChromeDriver(options);
        driver.get(url.replace("{}", String.valueOf(1)));
        System.out.println(url);
        System.out.println(memberCount);
        driver.close();
    }


}
