package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class driverFactory {

    public static ThreadLocal<WebDriver>  driverThreadLocal =  new ThreadLocal<>();;
    propertiesFactory propertiesFactory = new propertiesFactory();

    public void initDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driverThreadLocal.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driverThreadLocal.set(new FirefoxDriver());
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driverThreadLocal.set(new InternetExplorerDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driverThreadLocal.set(new EdgeDriver());
                break;
            default:
                Assert.assertTrue(false, "İstenilen browser seçeneeklerimizde yok");
                break;
        }
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get(propertiesFactory.getUrl());
    }

    public void closeDriver() {
        getDriver().quit();
    }

    public static synchronized WebDriver getDriver() {
        return driverThreadLocal.get();
    }


}
