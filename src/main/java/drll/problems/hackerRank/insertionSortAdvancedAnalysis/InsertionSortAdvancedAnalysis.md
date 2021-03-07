 ## Link to the problem
 
 > https://www.hackerrank.com/challenges/insertion-sort/problem
 
 ##### Difficulty Level (according to HackerRank)
 
 >  Advanced (Algorithms | Sorting)
 
 ##### Resume of the problem:
 Find all inverted pairs of numbers in a list, given that `i < j` if `list[i] > list[j]`,
 then there is an inverted pair, or a shift.
 
 ##### Notes
 - My first solution was this:
   * I made a double bucle forming pairs(x, y), where `x = arr[i]` and `y = arr[j]`,
 then if `x > y` there is an inverted pair. So, I just need to count and return the 
 amount of inverted pairs. And my method was this: 
 ```
 public static int insertionSort(int[] arr) {    
        int result  = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++ ) {
                if (arr[i] > arr[j]) {
                    result++;
                }
            }
        }
        return result;
    }
 ```

 
   - But this solution was not enough for all test cases provided by the online judge,
     because for more than the half of the cases the response was a timeout, that means 
     that this solution was very inefficient. Because I was finding shifts in O(n2) pairs,
     exactly in `n(n-1)/2` pairs.
 
-  My second solution was this:
   * Keeping in mind the principle that I need to count all inverted pairs, then
 I needed to find a way that not involve forming explicitly O(n2) pairs, in 
 order to do that I will use a binary search tree.
   * Then the idea is, iterate over the list and build the tree taking as root
the first element of the list. When a new value is inserted in a node, if the
value is greater or equals than the value in the node, then I proceed to insert
the new value as a new left child if not exist, else I repeat the process in the 
left child. If the new value is less than the value in the node, then, here is the
main idea of the solution, this new value is inverted respect to the actual node
value and also respect to node´s left child and his descendants, so, I just need
to count inverted cases all the times that new value go to the right side of a 
node, until the new value was inserted as a leaf in the tree.
   * This is the binary tree: 
```
class BiNode{
    private int value;
    private int familyCount;
    private BiNode leftChild;
    private BiNode rightChild;

    BiNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public BiNode getLeftChild() {
        return leftChild;
    }

    public BiNode getRightChild() {
        return rightChild;
    }

    public int getFamilyCount() {
        return familyCount;
    }

    public int calculateShifts(BiNode child){

        if(child.getValue() >= getValue()){
            if (getRightChild() == null){
                rightChild = child;
                familyCount++;
                return 0;
            }
            familyCount++;
            return getRightChild().calculateShifts(child);
        }
        if(getLeftChild() == null){
            leftChild = child;
            familyCount++;
            if (getRightChild() == null){
                return 1;
            }
            return 1 + 1 + getRightChild().getFamilyCount();
        }
        if (getRightChild() == null){
            familyCount++;
            return 1 + getLeftChild().calculateShifts(child);
        }
        familyCount++;
        return 1 +
                1 + getRightChild().getFamilyCount() +
                getLeftChild().calculateShifts(child);
    }
}
```
 > If you notice method calculateShifts(...) insert a new node in the tree, but,
 this method return the number of pairs inverted in the tree respect to the new
 value.
 
 
* Then my initial method `public static int insertionSort(int[] arr){...}`
 change as follow:
 ```
  public static long insertionSort(int[] arr) {
         long result  = 0;
         BiNode root = new BiNode(arr[0]);
         for (int i = 1; i < arr.length; i++){
             result += root.calculateShifts(new BiNode(arr[i]));
         }
         return result;
     }
 ```
 
 * This solution was better than first one, but, one more time, was not enough, 
 because fail 2 test cases over 14, because for very long list of the same number
 response a timeout.
 
 * After that I introduce the concept of twins nodes, in order to not repeat
 nodes with the same value, then the method to insert new values changed as 
 follow:
 ```
public int calculateShifts(BiNode child){

        if (child.getValue() == value){
            twins++;
            if(rightChild == null){
                return 0;
            }
            return 1 + rightChild.getTwins() + rightChild.getFamilyCount();
        }
        if(child.getValue() > value){
            if (getRightChild() == null){
                rightChild = child;
                familyCount++;
                return 0;
            }
            familyCount++;
            return getRightChild().calculateShifts(child);
        }
        if(getLeftChild() == null){
            leftChild = child;
            familyCount++;
            if (getRightChild() == null){
                return 1 + twins;
            }
            return 1 + twins + 1 + getRightChild().getTwins() + getRightChild().getFamilyCount();
        }
        if (getRightChild() == null){
            familyCount++;
            return 1 + twins + getLeftChild().calculateShifts(child);
        }
        familyCount++;
        return 1 + twins +
                1 + getRightChild().getTwins() + getRightChild().getFamilyCount() +
                getLeftChild().calculateShifts(child);
    }
```

   * This solution was even better but now again was not enough, 
because fail for 1 test cases over 14, because for ordered lists, 
ascendant or descendant the response was  a timeout, and that 
because the tree is extremely unbalanced, in this case its the 
worst case for the binary tree search. For that reason in my next
solution I will use binary search tree balanced by height


## Final result

* My final solution was implement an avl tree, all test cases run correctly now.
I implement a generic avl, only the insertion process, and I extend it to use
it in my solution, because not only do I take charge when the new value was 
inserted in right side or in left side, but also of the rotations produced by
imbalances in the tree.