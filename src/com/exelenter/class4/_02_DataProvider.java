package com.exelenter.class4;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class _02_DataProvider {

    // DataProvider it works with 2D Array and accept Object[] as data type.
    @Test
    void printData() {
        userList();


    }

    //Manupulating without dataProvider
    
    public void userList() {
        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("John");
        stringArrayList.add("Sam");
        // stringArrayList.add(25); gives error because it is a String
        List<Object> objectList = new ArrayList<>();
        objectList.add("John");
        objectList.add(25);
        System.out.println("stringArrayList = " + stringArrayList);
        System.out.println("objectList = " + objectList);
    }

    public void data() {
        // Single object
        Object user = "John Doe";                            // all data types accepted here but only one at a time

        // Arrays of objects
        Object[] users = {"John Doe", " Sam Lee", 'c', 45};             // Now more than one can be accepted and all data types


        // 2D Array, Arrays of Arrays
        Object[][] user2D = {
                {"John Doe", " Sam Lee", 'c', 0.99},
                {"John Doe", " Sam Lee", 'c', 5.65},
                {"John Doe", " Sam Lee", 'c', 66.99}};
        System.out.println("Arrays.deepToString(user2D) = " + Arrays.deepToString(user2D));
    }


}
