package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class driverFactory {

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    ;
    propertiesFactory propertiesFactory = new propertiesFactory();
    DesiredCapabilities capabilities;

    public void initDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driverThreadLocal.set(new ChromeDriver());
                getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get(propertiesFactory.getUrl());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driverThreadLocal.set(new FirefoxDriver());
                getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get(propertiesFactory.getUrl());
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driverThreadLocal.set(new InternetExplorerDriver());
                getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get(propertiesFactory.getUrl());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driverThreadLocal.set(new EdgeDriver());
                getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                getDriver().manage().window().maximize();
                getDriver().get(propertiesFactory.getUrl());
                break;
            case "android":
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName","Android");
                capabilities.setCapability("platformVersion","13");
                capabilities.setCapability("deviceName","emulator-5554");
                capabilities.setCapability("appPackage","com.wt.apkinfo");
                capabilities.setCapability("appActivity","com.wt.apkinfo.activities.StartActivity");
                try {
                    driverThreadLocal.set(new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                Assert.assertTrue(false, "İstenilen browser seçeneeklerimizde yok");
                break;
        }
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        getDriver().quit();
    }

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }


}
