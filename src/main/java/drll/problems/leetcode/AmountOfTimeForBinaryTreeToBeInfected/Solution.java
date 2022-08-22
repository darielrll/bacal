package drll.problems.leetcode.AmountOfTimeForBinaryTreeToBeInfected;

import java.util.*;

public class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, graph);
        int nodesCount = getTotalNodes(graph);

        return bfsDepth(graph, start, nodesCount);
    }

    private int getTotalNodes(HashMap<Integer, List<Integer>> graph) {
        int nodesCount = 0;

        for(Integer key : graph.keySet()){
            if(key > nodesCount){
                nodesCount = key;
            }
        }

        return nodesCount;
    }

    private void buildGraph(TreeNode root, HashMap<Integer, List<Integer>> graph) {
        if(root == null){
            return;
        }
        if(!graph.containsKey(root.val)){
            graph.put(root.val, new ArrayList<>());
        }
        if(root.left != null){
            graph.get(root.val).add(root.left.val);

            graph.put(root.left.val, new ArrayList<>());
            graph.get(root.left.val).add(root.val);
        }
        if(root.right != null){
            graph.get(root.val).add(root.right.val);

            graph.put(root.right.val, new ArrayList<>());
            graph.get(root.right.val).add(root.val);
        }
        buildGraph(root.left, graph);
        buildGraph(root.right, graph);
    }

    private int bfsDepth(HashMap<Integer, List<Integer>> graph, int startNode, int nodesCount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        boolean[] visited = new boolean[nodesCount + 1];
        Queue<Integer> tmp = new LinkedList<>();
        int depth = 0;

        while (!queue.isEmpty()){
            int node = queue.poll();
            if(!visited[node]){
                visited[node] = true;
                tmp.addAll(graph.get(node));
            }
            if(queue.isEmpty()){
                queue = tmp;
                if(!tmp.isEmpty()){
                    depth++;
                }
                tmp = new LinkedList<>();
            }
        }

        return depth > 0 ? depth - 1 : 0;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}