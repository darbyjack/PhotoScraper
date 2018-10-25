import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

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

        int slashslash = url.indexOf("//") + 2;

        String rootDomain = url.substring(slashslash, url.indexOf('/', slashslash));

        File dir = new File(rootDomain);
        dir.mkdir();

        WebDriver driver = new ChromeDriver(options);
        for (int i = 1; i < Integer.valueOf(memberCount); i++) {
            driver.get(url.replace("{}", String.valueOf(i)));
        }

        driver.close();
    }


}
