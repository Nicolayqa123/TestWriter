package com.vipwriters;

import com.PageWriter.AppliedOrders;
import com.PageWriter.DetailedOrder;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AppliedUploadFilesTest extends WebDriverSettings {
    @Test
    public void download() throws Exception {
        WritersLogin();
        TimeUnit.SECONDS.sleep(4);
        AppliedOrders.appliedOrders(driver).click();
        AppliedOrders.order10354(driver).click();
        TimeUnit.SECONDS.sleep(2);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 650);");
        DetailedOrder.uploadFile(driver).click();
        DetailedOrder.fileRecipientClient(driver).click();
        DetailedOrder.fileTypeAditiMater(driver).click();
        DetailedOrder.drop(driver).click();
        TestFileDrop();
        DetailedOrder.confirm(driver).click();
       // TimeUnit.SECONDS.sleep(10);
        //  driver.findElementById("2210").click();
        // driver.findElementByXPath("/html/body/div[2]/div/div[3]/button[1]").click();
      //  TimeUnit.SECONDS.sleep(10);
      //  assertEquals("File successfully upload!", driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText());


    }


    public void screen() throws Exception {
        String newAutoTest = "newAutoTest" + x;
        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        String path = "C:\\Programms\\PNG\\" + getClass() + ".png";
        FileUtils.copyFile(screenshot, new File(path));

    }

}