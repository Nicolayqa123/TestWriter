package com.vipwriters;


import com.PageWriter.Lending;
import com.SeleniumRunner;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
public class LoginTest extends WebDriverSettings {

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
    @Rule
    public TestWatcher watcher = new TestWatcher() {


        @Override
        public void finished(Description description) {
            System.out.println("finished");
            driver.quit();
        }

        @Override
        public void failed(Throwable e, Description description) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                String filePathRoot = "C:\\Program Files (x86)\\Jenkins\\workspace\\MavenTest\\TestWriter\\target\\surefire-reports" + "Test1";
                String fullFilePath = filePathRoot + description.getClassName() + "\\" + description.getMethodName() + ".jpg";

                FileUtils.copyFile(screenshot, new File(fullFilePath));
            } catch (Exception ex) {
                System.out.println(ex.toString());
                System.out.println(ex.getMessage());
            }
            System.out.println("failed");
            driver.quit();
        }
    };
        @Test
        public void Loginuser() throws Exception {
            driver.get("https://writer.urgentpapers.org/");
            Lending.loginForm(driver).click();
            Lending.userName(driver).click();
            Lending.userName(driver).sendKeys(mail);
            Lending.password(driver).sendKeys(pass);
            Lending.loginButton(driver).click();
            TimeUnit.SECONDS.sleep(7);
            assertEquals("Available Orders123", driver.findElement(By.cssSelector("#root > div > div > div.writers-content > div:nth-child(2) > h2")).getText());


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

