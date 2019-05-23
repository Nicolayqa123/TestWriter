package com.vipwriters;


import com.PageClient.Registered;
import com.PageWriter.Lending;
import io.qameta.allure.*;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
//@RunWith(SeleniumRunner.class)
//@RunWith(MyRunner.class)
//@Listeners(ListenerTest.class)



    public class LoginTest extends WebDriverSettings{
    public static WebElement element = null;
    public RemoteWebDriver driver;

    /*DesiredCapabilities capability = DesiredCapabilities.firefox();
    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

    public LoginTest() throws MalformedURLException {
    }*/




    /* @Rule
     public TestWatcher screenshotOnFailure = new TestWatcher() {
         @Override
         protected void failed(Throwable e, Description description) {
             makeScreenshotOnFailure();
         }

         @Attachment("Screenshot on failure")
         public byte[] makeScreenshotOnFailure() {
             return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
         }
     };
 */











        @Test
        @Description("Тест логина")
        public void Loginuser() throws Exception {
            driver.get("https://writer.urgentpapers.org/");
            TimeUnit.SECONDS.sleep(5);

            driver.findElementByXPath("//*[@id=\"sign-in-button\"]").click();
            TimeUnit.SECONDS.sleep(5);
            Lending.userName(driver).click();
            Lending.userName(driver).sendKeys(mail);
            Lending.password(driver).sendKeys(pass);
            Lending.loginButton(driver).click();
            TimeUnit.SECONDS.sleep(7);
            //   driver.findElementById("writers-available-orders-amount").click();
            Assert.assertEquals("Available Orders", driver.findElement(By.cssSelector("#root > div > div > div.writers-content > div:nth-child(2) > h2")).getText());

        }

        public void UnLoginNoValid() throws InterruptedException {

            driver.get("https://writer.urgentpapers.org/");
            WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/header/div/div[2]/nav/ul/li[11]/a"));
            WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/form/div/div[2]/input"));
            WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/form/div/div[3]/input"));
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/form/div/div[4]/input"));
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(3);
            login.click();
            TimeUnit.SECONDS.sleep(2);
            username.sendKeys("asdasd@ya.ru");
            password.sendKeys("asdasdasd");
            loginButton.click();
            TimeUnit.SECONDS.sleep(1);
            Assert.assertEquals("Please enter a correct username and password.", driver.findElement(By.cssSelector(".label")).getText());
        }


        public void UnLoginEmptyFields() throws InterruptedException {

            driver.get("https://writer.urgentpapers.org/");
            WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/header/div/div[2]/nav/ul/li[11]/a"));
            WebElement username = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/form/div/div[2]/input"));
            WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/form/div/div[3]/input"));
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div/form/div/div[4]/input"));
            driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
            TimeUnit.SECONDS.sleep(3);
            login.click();
            TimeUnit.SECONDS.sleep(2);
            loginButton.click();
            TimeUnit.SECONDS.sleep(1);
            Assert.assertEquals("Please enter a correct username and password.", driver.findElement(By.cssSelector(".label")).getText());

        }

        @Test
        public void LoginPaptest1() throws Exception {
            driver.get("https://client.urgentpapers.org/");

            driver.findElement(loginClient).click();
            driver.findElement(loginClientUserName).sendKeys("nicolaychiuri@gmail.com");
            driver.findElement(loginClientPassword).sendKeys("nicolay");
            driver.findElement(loginClientSubmit).click();
            TimeUnit.SECONDS.sleep(20);
        }



}

