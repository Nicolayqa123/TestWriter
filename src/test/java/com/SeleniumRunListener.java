package com;

import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;

public class SeleniumRunListener extends RunListener {

    public FirefoxDriver driver;



    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("Before tests run: " + description);
    }


    @Override
    public void testRunFinished(Result result) throws Exception {
       /* System.out.println("Result of the test run:");
        System.out.println("Run time: " + result.getRunTime() + " ms");
        System.out.println("Run count: " + result.getRunCount());
        System.out.println("Failure count: " + result.getFailureCount());
        System.out.println("Ignored count: " + result.getIgnoreCount());*/

    }


    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("Test starts: " + description);
    }


    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("Test finished: " + description);
    }


    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("Test failed with: "
                + failure.getException());

        /*WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot)augmentedDriver).
                getScreenshotAs(OutputType.FILE);*/

        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        String path = "\\target\\screenshots\\" + screenshot.getName();
        FileUtils.copyFile(screenshot, new File(path));

    }


    @Override
    public void testAssumptionFailure(Failure failure) {
        System.out.println("Test assumes: " + failure.getException());
    }


    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("Test ignored: " + description);
    }


}
