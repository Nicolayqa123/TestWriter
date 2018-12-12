package com;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.xml.transform.Result;

public class ListenerTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("The name of the testcase failure is :"+ iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        System.out.println("The name of the testcase failed is :"+ iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("The Test Finish");
    }
}
