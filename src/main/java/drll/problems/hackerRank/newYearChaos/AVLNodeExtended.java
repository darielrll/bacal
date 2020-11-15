
package drll.problems.hackerRank.newYearChaos;

public class AVLNodeExtended implements Comparable<AVLNodeExtended> {

    public int familyCount;
    public Integer value;

    public AVLNodeExtended(Integer value) {
        this.value = value;
    }

    @Override
    public int compareTo(AVLNodeExtended avlNodeExtended) {
        return value.compareTo(avlNodeExtended.value);
    }
}