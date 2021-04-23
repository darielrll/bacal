## Link to the problem
 
 > https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 
##### Difficulty Level (according to Leetcode)
 
 > Medium (Tree | Depth-first Search | Binary Search Tree | Recursion)
 
##### Resume of the problem:

Given a tree like this:

              1    
           1  1  1    
        1  2  3  2  1  
      1 3  6  7  6  3  9    
    1 4 10 16 19 16 10 4 1  

Return the position of the first even number given a row
 
  
##### Notes
 
I started creating the target row using only the previous row, 
I made it using boolean operations taking in account that, 
even + even = even, odd + odd = even, even + odd = odd, so, 
I used a boolean array where true = even and false = odd. Of course
this solution raised a time out. So I changed after a few days of 
struggling my head to this final solution. 


## Final result

For an odd row the even number will be always in position 2, for 
even rows the position of the even number will be in position
3 or 4.  
    3: - if sumatory of naturals number from 0 to (row - 1) is even  
    4: - otherwise 

