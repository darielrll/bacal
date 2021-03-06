package drll.problems.leetcode.triangle;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        Node extremeLeft = new Node(triangle.size() - 1, 0, triangle);
        while(extremeLeft != null){
            min = Math.min(min, findMinimumPath(extremeLeft, 0));
            extremeLeft = extremeLeft.rightSibling();
        }
        return min;
    }

    private Integer findMinimumPath(Node node, Integer summation){
        if(node == null  ||  node.accumulate <= summation + node.value){
            return Integer.MAX_VALUE;
        }
        if(node.isRoot()){
            node.accumulate = Math.min(node.accumulate, summation + node.value);
            return node.accumulate;
        }
        node.accumulate = summation + node.value;
        return Math.min(
                findMinimumPath(node.leftFather(), node.accumulate),
                findMinimumPath(node.rightFather(), node.accumulate)
        );
    }
}


class Node{
    public final Integer value;
    public Integer accumulate;
    private final Integer row;
    private final Integer position;
    private Node rightSibling, leftSibling, leftFather, rightFather;
    private final List<List<Integer>> triangleTree;

    public Node(int row, int position, List<List<Integer>> triangleTree){
        this.row = row;
        this.position = position;
        this.triangleTree = triangleTree;

        value =  triangleTree.get(row).get(position);
        accumulate = Integer.MAX_VALUE;
    }

    public boolean isRoot(){
        return row == 0  &&  position == 0;
    }

    public Node rightSibling(){
        if(position == triangleTree.get(row).size() - 1){
            return null;
        }
        if(rightSibling == null){
            rightSibling = new Node(row, position + 1, triangleTree);
            rightSibling.leftSibling = this;
        }
        return rightSibling;
    }

    public Node rightFather(){
        if(position == triangleTree.get(row).size() - 1){
            return null;
        }
        if(rightFather == null){
            rightFather = new Node(row - 1, position, triangleTree);
            if(leftFather != null){
                leftFather.rightSibling = rightFather;
                rightFather.leftSibling = leftFather;
            }
        }
        return rightFather;
    }

    public Node leftFather(){
        if(position == 0){
            return null;
        }
        if(leftFather == null){
            leftFather = leftSibling.rightFather;
        }
        return leftFather;
    }
}