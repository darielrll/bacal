 ## Link to the problem
 
 > https://www.hackerrank.com/challenges/new-year-chaos/problem
 
 ##### Difficulty Level (according to HackerRank)
 
 > Medium (Algorithms | Constructive Algorithms) 
 (_But, I could be harder than that I think_)
 
 ##### Resume of the problem:
Find the amount of bribes in a list. A bribe happens when a number interchange his position with a 
number less than him, and also that number is just at his left. A number can only be made at least 
two bribes. At the beginning you have an ordered list from 1 to n, then the input is an unordered list, 
the output is the number of bribes made in the initial ordered list to reach the input. If there
is no solution possible the output is a text indicating that the list is too chaotic.
 
 ##### Solution provided 
 - Having an array of length equal to the initial input array length, fill each position with the
 difference of the `index of the array plus one` and `the value in the input array in that position 
 without the plus one`. After that, if a value is less than `-2` it means that the number made more than
 two bribes, and that it is not allowed. This is the only case to return that the input is too chaotic.
 All negatives values modularity correspond to bribe. The thing is how to recognize bribes in the
 positive values.
 The answer is that we are in presence of a bribe(s) if there is a positive value(s) that have a 
 greater positive value before him. Then we will have as many bribes as greater values before him has 
 a positive value(shift).
 So, the answer is `bribes` = `sumation of negatives values * -1` + `bribes detected in positives values`. 