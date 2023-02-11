package com.exelenter.class4;

import org.testng.annotations.Test;

public class _01_GroupsDemo {
    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test(groups = "smoke")
    void test2() {
        System.out.println("Test 2");
    }

    @Test(groups ="regression")
    void test3() {
        System.out.println("Test 3");
    }

    @Test(groups = {"smoke","regression"})
    void test4() {
        System.out.println("Test 4");
    }

}
