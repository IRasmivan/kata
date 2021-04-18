package com.rasmivan.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class JNiceStringsTest {

    @Test
    public void niceTest(){
        Assertions.assertEquals(1, JNiceStrings.nice("ugknbfddgicrmopn"));
        Assertions.assertEquals(1, JNiceStrings.nice("aaa"));
        Assertions.assertEquals(0, JNiceStrings.nice("jchzalrnumimnmhp"));
        Assertions.assertEquals(0, JNiceStrings.nice("haegwjzuvuyypxyu"));
        Assertions.assertEquals(0, JNiceStrings.nice("dvszwmarrgswjxmb"));
    }
}
