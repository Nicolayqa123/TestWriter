package com;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
//@RunWith(SeleniumRunner.class)
public class SeleniumRunListener extends RunListener {
    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("Before tests run: " + description);
    }

    /**
     * Вызывается когда все тесты завершены
     * @param result результат выполнения тестов
     */
    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("Result of the test run:");
        System.out.println("Run time: " + result.getRunTime() + " ms");
        System.out.println("Run count: " + result.getRunCount());
        System.out.println("Failure count: " + result.getFailureCount());
        System.out.println("Ignored count: " + result.getIgnoreCount());

    }

    /**
     * Вызывается перед запуском каждого теста.
     * @param description описание теста, который собирается запуститься
     * (обычно имя класса и метода)
     */
    /*@Override
    public void testStarted(Description description) throws Exception {
        System.out.println("Test starts: " + description);
    }
*/
    /**
     * Вызывается после завершения каждого теста,
     * несмотря на результат выполнения.
     * @param description описание теста, который завершился
     */
   /* @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("Test finished: " + description);
        System.out.println("--------------------------------------");
    }
*/
    /**
     * Вызывается когда тест завершается неудачей.
     * @param failure описывает тест, который завершился ошибкой
     * и полученное исключение.
     */
    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("Test failed with: "
                + failure.getException());


        try {
            getBytes("picture.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            getBytes("text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
makeScreenshotOnFailure();
        driver.quit();


    }

    /**
     * Вызывается когда не выполняется условие в классе Assume
     *
     * @param failure описывает тест, который не был выполнен
     * и исключение {@link AssumptionViolatedException}
     */
    @Override
    public void testAssumptionFailure(Failure failure) {
        try {
            getBytes("picture.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            getBytes("text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test assumes: " + failure.getException());

        try {
            makeScreenshotOnFailure();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    /**
     * Вызывается когда тест не будет запущен,
     * в основном потому что стоит аннотация @Ignore
     *
     * @param description описание теста который не будет запущен
     */
    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("Test ignored: " + description);
        System.out.println("--------------------------------------");

    }
    public FirefoxDriver driver;


    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }


    @Attachment("Screenshot on failure")
    public void makeScreenshotOnFailure () throws Exception {
        String newAutoTest = "newAutoTest1";
        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        String path = "C:\\Program Files (x86)\\Jenkins\\workspace\\MavenTest\\TestWriter\\allure-report\\data\\attachments\\" + newAutoTest + screenshot.getName() + ".json";
        FileUtils.copyFile(screenshot, new File(path));
        driver.quit();
    }





}

