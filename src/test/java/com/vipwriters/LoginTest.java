package com.vipwriters;


import com.PageWriter.Lending;
import io.qameta.allure.*;

import org.apache.commons.io.FileUtils;
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





   // @Step
    /*public void stringWlog () {
        driver.findElementById("sign-in-button").click();
    }*/
    @Step
    public void stringUsename () {
        driver.findElement(By.xpath("//*[@id=\"signinForm\"]/div/div[2]/input")).sendKeys(mail);
    }
    @Step
    public void stringpass () {
        driver.findElement(By.xpath("//*[@id=\"signinForm\"]/div/div[3]/input")).sendKeys(pass);
    }
    @Step
    public void stringloginbutton () {
        driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[4]/input")).click();
    }


    @Test
    @Story("TestLog")
    @Description("Test Descripti")
    public void Loginuserasd123testTest() throws Exception {

    WritersLogin();

        TimeUnit.SECONDS.sleep(7);
        assertEquals("Available Orders123", driver.findElement(By.cssSelector("#root > div > div > div.writers-content > div:nth-child(2) > h2")).getText());
        checkScreen();
        getBytes("test");
        Allure.addAttachment("Результат", "application/json");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Write Screenshot to a file
    }










        @Test
        @Step
        public void Loginuser() throws Exception {
            driver.get("https://writer.urgentpapers.org/");
            TimeUnit.SECONDS.sleep(10);
            Lending.loginForm(driver).click();
            Lending.userName(driver).click();
            Lending.userName(driver).sendKeys(mail);
            Lending.password(driver).sendKeys(pass);
            Lending.loginButton(driver).click();
            TimeUnit.SECONDS.sleep(7);
            assertEquals("Available Orders123", driver.findElement(By.cssSelector("#root > div > div > div.writers-content > div:nth-child(2) > h2")).getText());
            checkScreen();
            getBytes("test");


        }


    String path = "C:\\Programms\\PNG\\"  + getClass() +  ".png";


    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("C:\\Programms\\PNG\\", resourceName));

    }


    @Step("test screen")
    public static void checkScreen() throws IOException {
        getBytes("picture.jpg");
        getBytes("text.txt");
        return;
    }











    @Attachment("My cool attachment")
    private byte[] createAttachment() {
        String content = "attachmentContent";
        return content.getBytes();
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
            assertEquals("Please enter a correct username and password.", driver.findElement(By.cssSelector(".label")).getText());
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
            assertEquals("Please enter a correct username and password.", driver.findElement(By.cssSelector(".label")).getText());

        }



}

