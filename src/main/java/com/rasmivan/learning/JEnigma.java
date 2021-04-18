package com.rasmivan.learning;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class JEnigma {

    // We have a system to transfer information from one place to another. This system
    // involves transferring only list of digits greater than 0 (1-9). In order to decipher
    // the message encoded in the list you need to have a dictionary that will allow
    // you to do it following a set of rules:
    //    > Sample incoming message: (​1,2,3,7,3,2,3,7,2,3,4,8,9,7,8)
    //    > Sample dictionary (​23->‘N’,234->‘ ’,89->‘H’,78->‘Q’,37 ->‘A’)
    //  - Iterating from left to right, we try to match sublists to entries of the map.
    //    A sublist is a sequence of one or more contiguous entries in the original list,
    //    eg. the sublist (1, 2) would match an entry with key 12, while the sublist (3, 2, 3)
    //    would match an entry with key 323.
    //  - Whenever a sublist matches an entry of the map, it’s replaced by the entry value.
    //    When that happens, the sublist is consumed, meaning that its elements can’t be used
    //    for another match. The elements of the mapping however, can be used as many times as needed.
    //  - If there are two possible sublist matches, starting at the same point, the longest one
    //    has priority, eg 234 would have priority over 23.
    //  - If a digit does not belong to any matching sublist, it’s output as is.
    //
    // Following the above rules, the message would be: “1N73N7 HQ”
    // Check the tests for some other (simpler) examples.

    private final Map<Integer, Character> map;

    private JEnigma(final Map<Integer, Character> map) {
        this.map = map;
    }

    public static JEnigma decipher(final Map<Integer, Character> map) {
        return new JEnigma(map);
    }

    /**
     * This Method decipher the given list of Integer to readable text.
     * @param message
     * @return
     */
    public String decipher(List<Integer> message) {
        // map does not have duplicate value
        StringBuilder originalMessageAsSB = new StringBuilder(convertListToString(message));
        Map<Integer, Character> orderedMap = orderingMap(); // Ordering the Given Map based on the criteria that the
        // larger subset should be replaced as priority and followed by the rest.

        for (Map.Entry<Integer, Character> entry : orderedMap.entrySet()) {
            /** Replace all Occurrence of the String,
             * So Checking if the String Exists, if Exist :: Replace the String to decipher
             */
            while(originalMessageAsSB.indexOf(entry.getKey().toString()) != -1) {
                originalMessageAsSB = originalMessageAsSB.replace(
                        originalMessageAsSB.indexOf(entry.getKey().toString()), // Starting Index
                        originalMessageAsSB.indexOf(entry.getKey().toString()) + entry.getKey().toString().length(),
                        // Ending Index
                        entry.getValue().toString() // String to Replace with
                        );
            }
        }
        return originalMessageAsSB.toString();
    }

    private String convertListToString(List<Integer> message) {
        return message.stream().map(e -> e.toString()).reduce("",
                String::concat);
    }

    @NotNull
    private Map<Integer, Character> orderingMap() {

        Map<Integer, Character> treeMap = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer firstKey, Integer secondKey) {
                        if (firstKey.toString().length() > secondKey.toString().length()) {
                            return -1;
                        } else if (firstKey.toString().length() < secondKey.toString().length()) {
                            return 1;
                        } else {
                            return firstKey.compareTo(secondKey);
                        }
                    }
                });

        treeMap.putAll(map);

        /**
         ** MY Thought!! **
            This question is missing some criteria, My view the below commented code is also a possible solution. Not
         sure whats the criteria for ordering the same length key's

         map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMapReverse.put(x.getKey(), x.getValue()));
         System.out.println(sortedMapReverse);

        **/
        return treeMap;
    }
}
