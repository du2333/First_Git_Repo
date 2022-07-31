package leetcode.dailychallenge;


import com.sun.source.tree.Tree;

public class n307_range_sum_query {
    class NumArray {
        //定义线段树节点
        class TreeNode{
            public int sum;
            public TreeNode left, right;
            public int start, end;
            public TreeNode(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        private TreeNode root;
        public NumArray(int[] nums) {
            root = buildTree(nums, 0, nums.length - 1);
        }

        public void update(int index, int val) {
            update(root, index, val);
        }

        public int sumRange(int left, int right) {
            return sumRange(root, left, right);
        }

        private TreeNode buildTree(int[] nums, int start, int end){
            if(start > end) return null;
            //base case: 当达到叶子节点
            if(start == end){
                //new一个叶子节点，它的值也就是原本的数值
                TreeNode node = new TreeNode(start, end);
                node.sum = nums[start];
                return node;
            }

            TreeNode node = new TreeNode(start, end);

            int mid = start + (end - start) / 2;
            //获取左右子节点
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);

            //当前节点的sum就是左右子节点sum的和
            node.sum = node.left.sum + node.right.sum;

            return node;
        }

        private void update(TreeNode root, int index, int val){
            //base case: 到达叶子节点，更新相应的数值
            if(root.start == index && root.end == index){
                root.sum = val;
                return;
            }

            //寻找index在左半部分还是右半部分
            int mid = root.start + (root.end - root.start) / 2;
            if(index <= mid)
                update(root.left, index, val);
            else
                update(root.right, index, val);

            //自下而上更新各个节点的值
            root.sum = root.left.sum + root.right.sum;
        }

        private int sumRange(TreeNode root, int left, int right){
            //base case: 恰好范围吻合，直接返回当前节点的值
            if(root.start == left && root.end == right)
                return root.sum;

            //寻找这个范围在左半部分还是右半部分
            int mid = root.start + (root.end - root.start) / 2;
            //在左半部分
            if(right <= mid)
                return sumRange(root.left, left, right);
            //在右半部分
            else if(left > mid)
                return sumRange(root.right, left, right);
            //左边也有，右边也有
            else
                return sumRange(root.left, left, mid) + sumRange(root.right, mid + 1, right);
        }
    }
}
