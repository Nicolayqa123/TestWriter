package com.vipwriters;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class SaveFilesTest extends WebDriverSettings {
    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    @Test
    public void sf() throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;


        LoginPap();
        TimeUnit.SECONDS.sleep(10);
        jse.executeScript("scroll(0, 950);");
        driver.findElement(previousOrders).click();
        TimeUnit.SECONDS.sleep(10);
        jse.executeScript("scroll(0, -350);");
        driver.findElement(order10272).click();
        TimeUnit.SECONDS.sleep(2);
        jse.executeScript("scroll(0, 950);");
        TimeUnit.SECONDS.sleep(7);
        driver.findElement(addNewFile).click();
        TimeUnit.SECONDS.sleep(2);
        TestFileDrop();

        if (driver.findElement(aNFUpload).isEnabled()) {
            driver.findElement(aNFUpload).click();
        } else  {
            driver.findElement(addNewFile).click();
            TimeUnit.SECONDS.sleep(2);
            TestFileDrop();
            driver.findElement(aNFUpload).click();
        }



       /* try {
            driver.findElement(aNFUpload).click();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
      //  driver.findElement(aNFUpload).click();

        /*TimeUnit.SECONDS.sleep(10);
        jse.executeScript("scroll(0, 550);");
        TimeUnit.SECONDS.sleep(10);
        //  driver.findElementByCssSelector("#collapseFour > div > div.box-white.for-circle-loader > div.box-white > button").click();
        driver.findElement(aNFUpload).click();*/
      //  jse.executeScript("scroll(0, 950);");
      //  TimeUnit.SECONDS.sleep(10);
      //  driver.findElement(aNFUpload).click();

    }
}
