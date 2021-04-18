package com.rasmivan.learning;

import java.util.*;
import java.util.stream.Collectors;

public class JConnectedGraph {
    // Find if two nodes in a directed graph are connected.
    // Based on http://www.codewars.com/kata/53897d3187c26d42ac00040d
    // For example:
    // a -+-> b -> c -> e
    //    |
    //    +-> d
    // run(a, a) == true
    // run(a, b) == true
    // run(a, c) == true
    // run(b, d) == false


    /**
     *
     * @param source
     * @param target
     * @return true or false
     *
     * Have come up with 2 solution
     * Solution 1: (Recursive - This runs for all Node and all Edges)
     *          REPEAT::
     *          if (Source == Target) Return True
     *
     *          If (Source != Target) Then
     *              pick all the edges of Source     (Running on all Edges)
     *                  Take first unvisited edges
     *                      GOTO REPEAT              (Running on all Nodes)
     *          if no match found then return False
     *
     * Solution 2:
     *
     *
     *          Loop until all nodes are visited.
     *              check for all the immediate Child of the Source
     *                  if (immediateChild  == Target) Return True
     *              check if the immediateChild have any unvisited edges, if so add to list of unvisited node.
     *          if no match found then Return False
     *
     */
    public static boolean run(JNode source, JNode target) {

        /**
         * Solution 1:
            Just added a rough Version

            Set<JNode> visited = new HashSet<>();
            return isConnectedOption1(source, target, visited);
         */

        /**
         * Solution 2: My Preferred Solution so not Commented the method call for you evolution.
         */
       return isConnectedOption2(source, target);
    }

    /**
     * Solution 2: Implementation
     *
     * @param source
     * @param target
     * @return
     */
    private static boolean isConnectedOption2(JNode source, JNode target) {
        Set<JNode> baseNode = new HashSet<>(); // This is added for not allowing duplicate as there can be cyclic
        // edges connecting the same node.
        List<JNode> immediateChild;
        baseNode.add(source);
        // Check until all the Nodes are visited.
        /**
         * baseNode can be added for isVisited false and all the visited node can be removed from the baseNode,
         * But just wanted to show case my idea around this basedNode for the intension of it.
         *
         * Another way of having this baseNode is to delete all the visited node and have this while loop to run
         * until baseNode is empty. But again as mentioned just have the below implementation to showcase my thought
         * process around this.
         */
        while(baseNode.stream().filter( bn -> bn.isVisited == false).collect(Collectors.toList()).size() > 0){
            immediateChild = new ArrayList<>();
            immediateChild.addAll(baseNode); // Adding the base Node/Current Node for checking if the immediate child
            // is TARGET
            for (JNode imc: immediateChild) {
                imc.isVisited = true;
                if(imc.value == target.value){
                    return true;
                }
                baseNode.addAll(imc.edges.stream().filter( edg -> edg.isVisited == false).collect(Collectors.toList()));
            }
        }
        return false;
    }

    /**
     * Solution 1: Implementation
     *
     * @param source
     * @param target
     * @return
     */
    private static boolean isConnectedOption1(JNode source, JNode target, Set<JNode> visited) {
    /*
        Check if Source and Target are the same, If Same RETURN true;

        Check if node have any child Node
            then iterate all the child Node
                check if the node is already visited,
                    if visited move to the next Node
                Else, add the current node to visited Node
            repeat above step until the Node is visited
                if the target node is found then RETURN True;

         if the Target Node is not found then RETURN false

     */

        if(source.value == target.value) {
            return true;
        }

        if(!source.edges.isEmpty()){
            for (JNode jNode:source.edges) {
                if(visited.stream().filter(vis -> vis.value == source.value && vis.isVisited == true).collect(Collectors.toList()).size() > 0){
                    continue;
                }
                JNode visit = new JNode(source.value);
                visit.isVisited = true;
                visited.add(visit);

                if(isConnectedOption1(jNode, target, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Node Class
     */
    public static class JNode {
        public int value;
        public List<JNode> edges;
        public boolean isVisited = false;
        public JNode(final int value, final List<JNode> edges) {
            this.value = value;
            this.edges = edges;
        }
        public JNode(final int value) {
            this.value = value;
            this.edges = Collections.emptyList();
        }
    }

}