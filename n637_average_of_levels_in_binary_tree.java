package leetcode.dailychallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n637_average_of_levels_in_binary_tree {

    public static void main(String[] args) {

    }
    public class TreeNode {
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

    public class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            if(root == null) return new ArrayList<Double>();

            //使用BFS
            Queue<TreeNode> q = new LinkedList<>();
            List<Double> ans = new ArrayList<>();
            q.add(root);
            while(!q.isEmpty()){
                int n = q.size();
                //记录每层节点的和
                double sum = 0;
                for(int i = 0; i < n; ++i){
                    TreeNode node = q.poll();
                    sum += node.val;
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
                //将结果加入答案
                ans.add(sum / n);
            }

            return ans;
        }
    }
}

