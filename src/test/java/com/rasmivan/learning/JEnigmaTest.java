package com.rasmivan.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JEnigmaTest {


    @Test
    public void decipheTest(){

        Map<Integer, Character> map = new HashMap<>();
        map.put(23, 'N');
        map.put(234, ' ');
        map.put(89, 'H');
        map.put(78, 'Q');
        map.put(37, 'A');
        JEnigma jEnigmaObj = JEnigma.decipher(map);

        Assertions.assertEquals("N", jEnigmaObj.decipher(Arrays.asList(2,3)));
        Assertions.assertEquals("NH", jEnigmaObj.decipher(Arrays.asList(2,3,8,9)));
        Assertions.assertEquals("1N", jEnigmaObj.decipher(Arrays.asList(1,2,3)));
        Assertions.assertEquals(" ", jEnigmaObj.decipher(Arrays.asList(2,3,4)));
        Assertions.assertEquals("1N73N7 HQ", jEnigmaObj.decipher(Arrays.asList(1,2,3,7,3,2,3,7,2,3,4,8,9,7,8)));

    }
}
