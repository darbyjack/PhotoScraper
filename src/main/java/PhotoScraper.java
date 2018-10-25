import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by GlareMasters
 * Date: 10/25/2018
 * Time: 12:50 PM
 */
public class PhotoScraper {


    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("headless");

        String url = args[0];
        String memberCount = args[1];

        int slashslash = url.indexOf("//") + 2;

        String rootDomain = url.substring(slashslash, url.indexOf('/', slashslash));

        File dir = new File(rootDomain);
        dir.mkdir();

        WebDriver driver = new ChromeDriver(options);
        for (int i = 1; i < Integer.valueOf(memberCount); i++) {
            driver.get(url.replace("{}", String.valueOf(i)));
            Thread.sleep(800);
            WebElement img = driver.findElement(By.cssSelector(" div.avatarScaler > span > img"));
            if (img.isDisplayed()) {
                URL imgURL = new URL(img.getAttribute("src"));
                ReadableByteChannel readableByteChannel = Channels.newChannel(imgURL.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(dir + "/" + i + ".jpg");
                fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            }
        }

        driver.close();
    }


}
