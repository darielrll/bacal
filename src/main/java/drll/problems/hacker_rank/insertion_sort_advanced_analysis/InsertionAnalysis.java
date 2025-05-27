
package drll.problems.hacker_rank.insertion_sort_advanced_analysis;

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