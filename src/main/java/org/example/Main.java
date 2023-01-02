package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;
    static Actions actions;
    static WebDriverWait wait;

    static By myAccount = By.id("myAccount");
    static By loginBtn = By.id("login");
    static By girisYapButon = By.id("btnLogin");
    static By email = By.id("txtUserName");
    static By gecersizMailText = By.cssSelector("form>div>div>div:nth-child(3)");

    public static void main(String[] args) {
        /*
            selenium metodları
            elementleri nasıl alabileceğimizi
            wait metodları
            actions
            assertions


            testng-junit-xunit-nuinit-msunit
            cucumber (bdd- )
            mimarisel güzelleştirmelere
            raporlama(allure report-extent report)
            örnekler
         */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.hepsiburada.com/");
        // Giriş Yap Butonunun üzerine gelme
        actions.moveToElement(wait.until(ExpectedConditions.presenceOfElementLocated(myAccount))).build().perform();
        // Giriş Yap Butonuna tıklama
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
        // Login Sayfasının açıldığını kontrol etme
        Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(girisYapButon)).isDisplayed());
        wait.until(ExpectedConditions.attributeToBe(email,"placeholder","E-posta adresi veya telefon numarası"));
        //Email alanına email yazıcaz
        wait.until(ExpectedConditions.presenceOfElementLocated(email)).sendKeys("eneserdogan");
        //Giriş Yap butonuna tıklanır
        wait.until(ExpectedConditions.presenceOfElementLocated(girisYapButon)).click();
        //Geçersiz mail yazısının kontrolü
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(gecersizMailText)).getText(),"Geçerli bir e-posta adresi girmelisiniz.");

        driver.quit();
    }
}