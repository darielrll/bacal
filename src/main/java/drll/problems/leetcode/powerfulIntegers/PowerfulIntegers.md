## Link to the problem
 
 - https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3726/
 - https://leetcode.com/problems/powerful-integers/solution/
 
##### Difficulty Level (according to Leetcode)
 
 > Easy (Array | Math )
 
##### Resume of the problem:

Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.

An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.

You may return the answer in any order. In your answer, each value should occur at most once.

```
Example 1:
Input: x = 2, y = 3, bound = 10
Output: [2,3,4,5,7,9,10]
Explanation:
2 = 2^0 + 3^0
3 = 2^1 + 3^0
4 = 2^0 + 3^1
5 = 2^1 + 3^1
7 = 2^2 + 3^1
9 = 2^3 + 3^0
10 = 2^0 + 3^2

Example 2:
Input: x = 3, y = 5, bound = 15
Output: [2,4,6,8,10,14]

Constraints:
1 <= x, y <= 100
0 <= bound <= 106
```

##### Notes

The worst case is when x and/or y is 1
 
  