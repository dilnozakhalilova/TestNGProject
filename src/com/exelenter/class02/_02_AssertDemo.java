package com.exelenter.class02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _02_AssertDemo extends BaseClass {
   @BeforeMethod
   void openBrowser(){
       setUp();

   }

   @AfterMethod
   void quitBrowser(){
       tearDown();
   }

   @Test















}
