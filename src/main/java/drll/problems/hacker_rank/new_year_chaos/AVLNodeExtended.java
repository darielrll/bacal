
package drll.problems.hacker_rank.new_year_chaos;

public class AVLNodeExtended implements Comparable<AVLNodeExtended> {

    public int familyCount;
    public final Integer value;

    public AVLNodeExtended(Integer value) {
        this.value = value;
    }

    @Override
    public int compareTo(AVLNodeExtended avlNodeExtended) {
        return value.compareTo(avlNodeExtended.value);
    }
}