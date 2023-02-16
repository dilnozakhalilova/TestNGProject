package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        // code you can take a screenshot or do something else
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== Regression Test Started ==== " + context.getName() +" | "+ context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("=== Regression Test Started === " + context.getName() +" |  "+ context.getEndDate());
    }
}

