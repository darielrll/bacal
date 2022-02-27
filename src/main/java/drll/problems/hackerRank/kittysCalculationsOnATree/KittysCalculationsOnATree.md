## Link to the problem

> https://www.hackerrank.com/challenges/kittys-calculations-on-a-tree/problem

##### Difficulty Level (according to HackerRank)

> Advanced (Data Structure | Tree)

##### Resume of the problem:

##### Prerequisites
 - (Optional) For this problem was mandatory to implement I/O, in order to play with it, it is mandatory to
create an environment variable called ```OUTPUT_PATH```, I created it at the of my zshrc profile, for 
example: ```export OUTPUT_PATH=/.../output.txt```, and after that it is needed to reload the environment-

##### Notes

Until now I try to resolve the problem using Floyd Warshal Algorithm but it is failling for very large
 inputs. There are test cases covering this failing scenarios. I think that the next approach is to take an 
advance in the fact that the graph is a tree and use the algorithm LCA, to know the weight of the unique path 
for each par of nodes in a tree.

Some references here:
- https://mathoverflow.net/questions/59680/all-pairs-shortest-paths-in-trees
- https://en.m.wikipedia.org/wiki/Lowest_common_ancestor
- https://en.m.wikipedia.org/wiki/Eulerian_path
- https://www.geeksforgeeks.org/lca-for-general-or-n-ary-trees-sparse-matrix-dp-approach-onlogn-ologn/
- https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
- https://contest.cs.cmu.edu/295/s20/tutorials/lca.mark

## Final result
