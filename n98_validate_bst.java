package leetcode.dailychallenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class n98_validate_bst {
    public boolean isValidBST(TreeNode root) {
        //创建一个栈，辅助中序遍历
        Deque<TreeNode> stack = new ArrayDeque();
        //前一个值
        long preVal = Long.MIN_VALUE;
        //当栈不为空或当前节点不为null时
        while (!stack.isEmpty() || root != null) {
            //不停的把左边的节点压入栈中，直到达到最左边的叶节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //弹栈
            root = stack.pop();
            //如果当前节点值小于前一节点的值，说不不是二叉搜索树
            if (root.val <= preVal) return false;
            //更新preVal
            preVal = root.val;
            //尝试前往当前节点的右子节点
            root = root.right;
        }

        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
