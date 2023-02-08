package com.exelenter.class3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseClass;

public class _01_SoftAssertRecap extends BaseClass {

    @Test
    public void testCase(){    // Use only one assert at a time

        // Example of hard Assert
//       System.out.println("Before Assert");
//       Assert.assertTrue(false);
//       System.out.println("After Assert");    // This will not print if line before fails.



        // Example of Soft Assert

        System.out.println("Before Soft Assert");
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("After Soft Assert");// This line will print, even if Soft assert before it fails.
        softAssert.assertAll();
        System.out.println("ALL test steps passed.");  // This line will only print if all steps  pass, otherwise it will not print
    }

    // Remember: Use only one Assertion per test case(@Test method)
    // I am using multiple only because of hard and soft assert Demonstration
}
