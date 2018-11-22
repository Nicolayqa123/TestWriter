package com;

import com.automation.remarks.video.recorder.VideoRecorder;
import io.qameta.allure.Attachment;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

import static com.google.common.io.Files.toByteArray;

public class MyRule extends TestWatcher {
    public FirefoxDriver driver;







    @Override
    protected void starting(Description description) {
        System.setProperty("webdriver.gecko.driver", "C://Programms/geckodriver.exe");
        driver = new FirefoxDriver();
        System.out.println("---before()---");
    }

    @Override
    protected void finished(Description description) {
        System.out.println("---after()---");
    }

    @Override
    protected void succeeded(Description description) {
        System.out.println("---succeeded()---");
    }

    @Override
    protected void failed(Throwable e, Description description) {
    makeScreenshotOnFailure();
    System.out.println("---failed()---");
    }








        @Attachment("Screenshot on failure")
        private void makeScreenshotOnFailure() {

            ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }

        @Attachment(value = "video record", type = "video/mp4")
        byte[] attachVideo() {
            try {
                return toByteArray(VideoRecorder.getLastRecording());
            } catch (IOException e) {
                e.printStackTrace();
                return new byte[0];
            }
        }




}
