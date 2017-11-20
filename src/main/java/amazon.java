
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by igortimokhin on 11/19/17.
 */
public class amazon {

    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "6703cab3");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "4.4.2");


        cap.setCapability("appPackage",
                "com.amazon.mShop.android.shopping");
        //adb -a " +ID+ " shell dumpsys window windows | grep mCurrentFocus
        cap.setCapability("appActivity",
                "com.amazon.mShop.home.HomeActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).click();
        driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).
                sendKeys("Samsung Galaxy S8");
        driver.pressKeyCode(66);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(driver.findElementByXPath("//android.widget.TextView[@index='5']").getText());


        driver.quit();

    }
}
