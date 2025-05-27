
package drll.data_structures.bit;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class FenwickTree {

    private final int size;
    private final HashMap<Integer, Long> tree;

    public FenwickTree(int size) {
        this.size = size;
        tree = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public long sum(int i, int j){
        return i > 1
                    ? sum(j) - sum(i - 1)
                    : sum(j);
    }

    public long sum(int i){
        if(i <= 0  ||  i > size){
            throw new IndexOutOfBoundsException();
        }

        long result = 0;

        while (i > 0) {
            tree.putIfAbsent(i, 0L);
            result += tree.get(i);
            i -= lessSignificantBit(i);
        }

        return result;
    }

    public void update(int i, int j, long value){

        if(i > j){
            throw new InvalidParameterException("Value of i should let value of j.");
        }

        for (int k = i; k <= j; k++) {
            update(k, value);
        }
    }

    public void update(int i, long value){

        if(i <= 0  ||  i > size){
            throw new IndexOutOfBoundsException();
        }

        do {
            tree.putIfAbsent(i, 0L);
            tree.put(i, tree.get(i) + value);
            i += lessSignificantBit(i);
        } while (i <= size);
    }

    /**
     * Return 2 pow to position of LSB of an integer i
     * @param i Integer i
     * @return 2 pow to position of less significant bit(LSB), starting
     *          from position 0 from right to left.
     */
    private int lessSignificantBit(int i){
        return i & -i;
    }

    /**
     * Return MSB of an integer i
     * @param i Integer i
     * @return Position of the most significant bit(LSB), starting
     *          from position 1 from right to left.
     */
    private int mostSignificantBit(int i){
        int rightShits = 0;

        while(1 < i){
            i >>= 1;
            rightShits++;
        }

        return ++rightShits;
    }

    /**
     *
     * @param i Node i
     * @return True if the node is only responsible for its value
     *          False if the node is responsible for store a frequency
     */
    private boolean isDependentNode(int i){
        return (i & 1) == 1;
    }

    /**
     *
     * @param node
     * @return
     */
    private boolean isBigResponsibleNodeInRange(int node, int startRange){
        return node - lessSignificantBit(node) + 1 == startRange;
    }

    /**
     * Get How many bit are 1 in i binary representation
     * @param i Number to know how many bit are 1 in its binary representation
     * @return How many bit are 1 in i binary representation
     */
    private int activatedBits(int i){
        int result = 0;

        while (i > 0){
            if((i & 1) == 1){
                result++;
            }
            i >>= 1;
        }

        return result;
    }
}
