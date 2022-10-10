package drll.problems.leetcode.LongestUploadedPrefix;

public class LUPrefix {

    boolean[] video;
    int longest = 0;
    public LUPrefix(int n) {
        video = new boolean[n + 1];
    }

    public void upload(int videoPosition) {
        video[videoPosition] = true;

        if(videoPosition == 1){
            longest = 1;
        }
        while(longest < video.length - 1  &&  video[longest + 1]){
            longest++;
        }
    }

    public int longest() {
        return longest;
    }
}