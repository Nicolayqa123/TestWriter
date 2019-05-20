package com.vipwriters;

import com.PageWriter.DetailedOrder;
import com.PageWriter.MyOrders;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;

public class MyOrdersUploadFile extends WebDriverSettings {

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    String FileName1 = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/div[3]/div[1]/div[2]/p";
    String FileName2 = "No files yet!";

    @Test
    public void dropfiles1() throws Exception {
        int i;
        WritersLogin();

        for (i = 1; i < 10; i++) {

            TimeUnit.SECONDS.sleep(4);
            driver.findElementByXPath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[" + i + "]/td[1]/a").click();
           String NameFile = driver.findElementByXPath("//*[@id=\"root\"]/div/div/div[2]/div[2]/div[2]/div[2]/div/div[3]").getText();
            if (FileName2 == NameFile) {
                DetailedOrder.uploadFile(driver).click();
                DetailedOrder.fileRecipientClient(driver).click();
                DetailedOrder.fileTypeAditiMater(driver).click();
                DetailedOrder.drop(driver).click();
                TestFileDrop();
                DetailedOrder.confirm(driver).click();

            } else {
                System.out.println("FileUpload");
            }
            TimeUnit.SECONDS.sleep(4);
            driver.findElementByXPath("//*[@id=\"root\"]/div/div/div[1]/ul/li[1]/a").click();

            // TimeUnit.SECONDS.sleep(10);
            //  driver.findElementById("2261").click();
            //   driver.findElementByXPath("/html/body/div[2]/div/div[3]/button[1]").click();
            //  assertEquals("File successfully upload!", driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText());

        }

    }

}