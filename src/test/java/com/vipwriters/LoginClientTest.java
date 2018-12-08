package com.vipwriters;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginClientTest extends WebDriverSettings {

    @Test
    public void Login1() throws InterruptedException, IOException, AWTException {
        driver.get("https://client.urgentpapers.org/");

      //  driver.findElement(By.id("********154391*******")).click();
        driver.findElementByCssSelector("*[id*='tawkchat-chat-bubble-close']").click();
     //   driver.switchTo().frame(driver.findElementByCssSelector("*[id*='tawkchat-chat-bubble-close']"));
      //  driver.findElement(By.id("tawkchat-chat-bubble-close")).click();
      //  driver.findElement(By.id("tawkchat-chat-bubble-close")).findElement(By.id("********1543915******")).click();
      //  driver.findElementByXPath("//*[@id=\"tawkchat-chat-bubble-close\"]").click();
     //   System.out.println(lala);
//*[@id="tawkchat-status-text-container"]
        //*[@id="tawkchat-chat-bubble-close"]

       // driver.findElement(By.xpath(".//iframe[1]"));
        /*driver.switchTo().frame(driver.findElementById("tawkchat-chat-bubble-close"));
        driver.findElementById("tawkchat-chat-bubble-close").click();*/


      //  String test = driver.findElementByLinkText("chat widget").getText();

     //   driver.findElementById("RHbiLi3-1543485793777").findElement(By.xpath("/html")).findElement()findElement(By.id("tawkchat-chat-bubble-close")).click();


       /* driver.switchTo().frame(driver.findElement(By.id("RHbiLi3-1543485793777")));
        driver.findElement(By.id("tawkchat-chat-bubble-close")).click();*/

      /*  driver.Url = @"http://jqueryui.com/datepicker/";
        driver.SwitchTo().Frame(
                driver.FindElement(By.CssSelector("iframe.demo-frame")));
        SetDatepicker(driver, "#datepicker", "02/20/2002");
*/




        /*driver.findElement(loginClient).click();
        driver.findElement(loginClientUserName).sendKeys("nicolaychiuri@gmail.com");
        driver.findElement(loginClientPassword).sendKeys("nicolay");
        driver.findElement(loginClientSubmit).click();
        TimeUnit.SECONDS.sleep(10);
        Assert.assertFalse("NicolayQA", Boolean.parseBoolean(driver.findElementByXPath("//*[@id=\"mm-0\"]/div[3]/div/div[1]/div[1]/div[2]/span[1]").getText()));
*/
    }

   /* @After
    public void closes(ITestResult testResult) throws Exception {

        if (testResult.getStatus() == ITestResult.CREATED) {
            takeScreenshot(driver, testResult.getName());
        }
        driver.quit();

    }*/

    public void LoginUserWrongPassword()throws InterruptedException {
        driver.get("https://client.urgentpapers.org/");

        driver.findElement(loginClient).click();
        driver.findElement(loginClientUserName).sendKeys("nicolayqa@gmail.com");
            TimeUnit.SECONDS.sleep(3);
        driver.findElement(loginClientPassword).sendKeys("asdasda456");
        driver.findElement(loginClientSubmit).click();
            TimeUnit.SECONDS.sleep(2);
        assertEquals("Invalid credentials", driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div/div/div[1]/div[4]")).getText());

    }

    public void LoginUserIsBlocked()throws Exception {
        driver.get("https://client.urgentpapers.org/");


        driver.findElement(loginClient).click();
        driver.findElement(loginClientUserName).sendKeys("nicolayqa@gmail.com");
            TimeUnit.SECONDS.sleep(3);
        driver.findElement(loginClientPassword).sendKeys("nicolayqa");
        driver.findElement(loginClientSubmit).click();
            TimeUnit.SECONDS.sleep(2);
        assertEquals("Authorization has been denied for this request.", driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div/div/div[1]/div[4]")).getText());

    }
    public void LoginPap() {
        driver.get("https://client.urgentpapers.org/");


        driver.findElement(loginClient).click();
        driver.findElement(loginClientUserName).sendKeys("nicolaychiuri@gmail.com");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(loginClientPassword).sendKeys("nicolay");
        driver.findElement(loginClientSubmit).click();
        assertEquals("NicolayQA", driver.findElement(By.xpath("//*[@id=\"mm-0\"]/div[3]/div/div[1]/div[1]/div[2]/span[1]")).getText());
    }





}
