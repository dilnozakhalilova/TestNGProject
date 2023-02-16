package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed");

        // code you can take a screenshot or do something else
    }






}
