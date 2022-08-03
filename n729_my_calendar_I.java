package leetcode.dailychallenge;

public class n729_my_calendar_I {
    class MyCalendar {
        //使用二叉搜索树
        class BSTreeNode{
            //每个节点记录区间[start,end)
            int start, end;
            BSTreeNode left, right;

            public BSTreeNode(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        private BSTreeNode root;
        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            if(root == null){
                root = new BSTreeNode(start, end);
                return true;
            }

            //进行二叉搜索
            BSTreeNode cur = root;
            while(true){
                //当在左子树时
                if(end <= cur.start){
                    if(cur.left == null){
                        cur.left = new BSTreeNode(start, end);
                        return true;
                    }
                    cur = cur.left;
                }
                //当在右子树时
                else if(start >= cur.end){
                    if(cur.right == null){
                        cur.right = new BSTreeNode(start, end);
                        return true;
                    }
                    cur = cur.right;
                }
                //区间重叠时
                else
                    return false;
            }
        }
    }
}
