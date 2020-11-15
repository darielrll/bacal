## Link to the problem
 
 > https://www.hackerrank.com/challenges/journey-to-the-moon/problem
 
##### Difficulty Level (according to HackerRank)
 
 > Medium (Algorithms | Graph Theory )
 
##### Resume of the problem:
 
 Given a list of pairs of astronauts that belong to the same city and a number for the
 total of astronauts, the problem is calculate how many pair of  astronauts can be 
 formed with the constraint that they should belong to different countries.
 
##### Notes
 
 Potentially a city can have only one astronaut, so, will not exist a pair of astronauts
 for that city, but, is given the total number of astronauts, and all the astronauts that
 not have a pair are astronauts for cities with only one. I divided my solution taking in 
 account `small cities(with only one astronaut)` and `big cities(with two or more astronauts)`.
   

## Final result

 Total pairs = pairs formed only in big cities 
                + pairs between small and big cities 
                + pairs formed only with small cities

