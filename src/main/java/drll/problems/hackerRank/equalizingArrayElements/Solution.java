package drll.problems.hackerRank.equalizingArrayElements;

import java.util.List;
import java.util.Vector;

public class Solution {
    public int minOperations(List<Integer> arr, int threshold, int d) {
        int MAX = 1000000;
        Vector<Integer> []v = new Vector[MAX];
        for(int i = 0; i < v.length; i++){
            v[i] = new Vector<Integer>();
        }
        for(int i = 0; i < arr.size(); i++){
            int cnt = 0;
            v[arr.get(i)].add(0);
            while (arr.get(i) > 0){
                int x  = arr.get(i) / d;
                arr.set(i,x);
                cnt++;
                v[arr.get(i)].add(cnt);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < MAX; i++){
            if (v[i].size() >= threshold){
                int move = 0;
                for(int j = 0; j < threshold; j++){
                    move += v[i].get(j);
                }
                ans = Math.min(ans, move);
            }
        }
        return ans;
    }
}
