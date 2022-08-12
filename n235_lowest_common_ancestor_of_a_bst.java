package leetcode.dailychallenge;

public class n235_lowest_common_ancestor_of_a_bst {
    //利用二叉搜索树的特点，
    //1.如果p、q的值都小于root，说明p q 肯定在root的左子树中；
    //2.如果p q都大于root，说明肯定在root的右子树中，
    //3.如果一个在左一个在右 则说明此时的root记为对应的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            else if(root.val < p.val && root.val < q.val)
                root = root.right;
            else
                break;
        }
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


