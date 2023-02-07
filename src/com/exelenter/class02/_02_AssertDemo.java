package com.exelenter.class02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

/**
 * TC 01: Login Validation Test (Happy Path)
 * Open chrome browser
 * Go to https://exelentersdet.com
 * Enter valid username and password
 * Click on login button
 * Verify login is successful
 * Close the browser
 *
 * TC 02: Login Validation Test (Negative Test)
 * Open chrome browser
 * Go to http://exelentersdet.com
 * Enter valid username
 * Leave password field empty
 * Verify error message with text “Password cannot be empty” is displayed.
 */
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
