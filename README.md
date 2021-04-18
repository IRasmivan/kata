# Code Sample

Have picked 3 different Coding Challenge
1. Connected Graph
2. Enigma
3. Nice Strings

**4. My Own Contibution:**
Have also added a GitHub Action to this project to auto-build on a push. This is to make sure that all the test cases are executed without any failure and the Java application can build with out any failure.


## 1. Connected Graph

 Have come up with 2 solutions, But would want you to consider Solution 2 as my submission, a rough code for Solution 1 is available to showcase my thoughts around it.
 
 Solution 1: (Recursive - This runs for all Node and all Edges)
          
          if (Source == Target) Return True

          If (Source != Target) Then
              pick all the edges of Source     (Running on all Edges)
                  Take first unvisited edges
                      GOTO Start              (Running on all Nodes)
          if no match found then return False

 Solution 2:


          Loop until all nodes are visited.
              check for all the immediate Child of the Source
                  if (immediateChild  == Target) Return True
              check if the immediateChild have any unvisited edges, if so add to list of the unvisited node.
          if no match found then Return False
          
## 2. Enigma

Have completed the task with the below assumption.

Assumption 1: If there are multiple keys that are available for the same digits, then the number should be picked in ascending order to replace the character. I came to this assumption based on the available test set. This Rule should be part of the requirement which is currently not.

As for this coding challenge, I have added some rough thought that I had when I was coding for this challenge to showcase my thought process for your review.

## 3. Nice String

Have completed the task.

Please note I have added a wrapper variable for constants (patterns) so the code is easy to ready and has added a code snippet to showcase the logic without any variables as your reference.

## 4. GitHub Action

Since this is a coding challenge, Was thinking about what more I code add to showcase my technical skills. So added a GitHub action to maven Build this project. This will trigger all the JUnit test cases (3 test cases, with multiple datasets) and is available in this repo for your review if you are wondering to check if the code build and all the test cases pass!
