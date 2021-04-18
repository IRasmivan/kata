package com.rasmivan.learning;

import com.rasmivan.learning.JConnectedGraph.JNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class JConnectedGraphTest {

    JNode n2;
    JNode n9;
    JNode n10;
    JNode n11;
    JNode n8;
    JNode n5;
    JNode n7;
    JNode n3;


    private void reSetDate(){
        n2 = new JNode(2);
        n9 = new JNode(9);
        n10 = new JNode(10);
        n11 = new JNode(11, Arrays.asList(n2, n9, n10));
        n8 = new JNode(8, Collections.singletonList(n9));
        n5 = new JNode(5,  Collections.singletonList(n11));
        n7 = new JNode(7,  Arrays.asList(n11, n8));
        n3 = new JNode(3,  Arrays.asList(n8, n10));
        n9.edges = Collections.singletonList(n3);
    }


    @Test
    public void runTest(){

        reSetDate(); // Rest Data
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n2));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n11));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n9));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n10));
        reSetDate();

        Assertions.assertEquals(true, JConnectedGraph.run(n7, n2));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n7, n11));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n7, n8));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n7, n9));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n7, n10));
        reSetDate();


        Assertions.assertEquals(true, JConnectedGraph.run(n3, n10));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n3, n8));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n3, n9));
        reSetDate();



        Assertions.assertEquals(false, JConnectedGraph.run(n2, n11));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n2, n5));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n2, n7));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n2, n3));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n2, n10));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n2, n9));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n2, n8));
        reSetDate();


        Assertions.assertEquals(true, JConnectedGraph.run(n11, n11));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n11, n5));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n11, n7));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n11, n3));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n11, n10));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n11, n9));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n11, n8));
        reSetDate();

        Assertions.assertEquals(true, JConnectedGraph.run(n5, n11));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n5));
        reSetDate();
        Assertions.assertEquals(false, JConnectedGraph.run(n5, n7));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n3));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n10));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n9));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n8));
        reSetDate();
        Assertions.assertEquals(true, JConnectedGraph.run(n5, n2));
        reSetDate();


    }
}
