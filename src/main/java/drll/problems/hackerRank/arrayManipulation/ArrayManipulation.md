 ## Link to the problem
 
 > https://www.hackerrank.com/challenges/crush/problem
 
 ##### Difficulty Level (according to HackerRank)
 
 > Hard (Data Structures | Arrays)
 
 ##### Resume of the problem:

An update query add a value in a range over an array.
Given a set of update queries over an array you need to give the maximum amount of position can reach. 
 
 ##### Notes
 
 I started using segment tree, but it was taking so much time, after I started to make a solution ordering
 the queries using the end of the range and trying to find local maximums and after take the global, but
 was a very long case that breaks this approach, and I can not found where was the error, so, I started
 finding, and I found the data structure Fenwick tree, or Binary Indexed Tree(BIT), I started using it to
 solve the exercise, but the range update operation was expensive, there are modification that can improve
 the range update in a BIT, but after making other iteration and discuss with a friend he talks to me about
 difference arrays and using it I solve de exercise in O(m), where m is the amount of queries. 


## Final result

I implemented BIT data structure for future use, because finally I do not use in the final solution

## Some useful links I used

http://www.oia.unsam.edu.ar/wp-content/uploads/2017/11/Fenwick-Trees.pdf
https://es.wikipedia.org/wiki/%C3%81rbol_binario_indexado
https://prodeportiva.wordpress.com/2013/02/17/arbol-de-fenwick/
https://prodeportiva.wordpress.com/tag/arbol-de-fenwick/
https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees/
https://www.youtube.com/watch?v=kkOgLGWd5CY
https://www.youtube.com/watch?v=qmDSms50rJY
https://www.youtube.com/watch?v=90cKCcZh7nw