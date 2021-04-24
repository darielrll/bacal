## Link to the problem
 
 > https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 
##### Difficulty Level (according to Leetcode)
 
 > Medium (Tree | Depth-first Search | Binary Search Tree | Recursion)
 
##### Resume of the problem:

Given a tree like this:

                     4    
           1                  6    
       0       2          5       7  
                  3                   8    


Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that 
every key of the original BST is changed to the original key plus sum of all keys greater 
than the original key in BST.

```
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
```
 
  
##### Notes
 
The interesting part of this exercise was to test it. I had to implement a method to convert the
in a tree, the idea of this was taking in account this was a binary search tree and exist a way to
convert it to an array like the input and vice versa.

Given a position `i` in the array, the left child will be in the position `2 * i + 1`, the right 
child will be at position `2(i + 1)` and the father will be at position `[(i - 1) / 2]`(the integer 
part of the division)




