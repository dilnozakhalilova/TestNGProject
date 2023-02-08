package com.exelenter.class3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseClass;

public class _01_SoftAssertRecap extends BaseClass {

    @Test
    public void testCase(){
//       System.out.println("Before Assert");
//       Assert.assertTrue(false);
//       System.out.println("After Assert");


        System.out.println("Before Soft Assert");
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("After Soft Assert");// This line will print, even if Soft assert before it fails.
        softAssert.assertAll();
    }

}
