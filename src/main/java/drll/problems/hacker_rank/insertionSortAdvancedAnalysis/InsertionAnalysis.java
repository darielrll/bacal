
package drll.problems.hacker_rank.insertionSortAdvancedAnalysis;

public class InsertionAnalysis implements Comparable<InsertionAnalysis>{

    public final int value;
    public int familyCount;
    public int twins;

    public InsertionAnalysis(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(InsertionAnalysis other) {
        return Integer.compare(value, other.value);
    }
}