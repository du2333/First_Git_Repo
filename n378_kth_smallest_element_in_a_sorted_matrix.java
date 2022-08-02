package leetcode.dailychallenge;

public class n378_kth_smallest_element_in_a_sorted_matrix {
    //因为是有序的矩阵，因此可以使用二分查找
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        //终止条件left == right
        while(left < right){
            int mid = left +(right - left) / 2;

            if(check(matrix, n, k, mid))
                right = mid;
            else
                left = mid + 1;
        }

        //因为二分查找是逐渐缩小范围，会把不符合要求的范围直接排除，所以最后留下的肯定是符合要求的数
        return left;
    }

    private boolean check(int[][] matrix, int n, int k, int mid){
        //i -- 行, j -- 列
        int i = 0;
        int j = n - 1;

        //记录小于等于mid的个数
        int count = 0;

        while(i < n && j >= 0){
            //如果这一行的这个数小于mid，那么它左边的数字肯定都小于mid
            if(matrix[i][j] <= mid){
                //将自己和左边数字的个数加到总数里
                count += j + 1;
                //移动到下一行
                i++;
            }
            else
                j--;
        }

        //要寻找的目标是否在左半部分
        //如果小于等于mid的个数大于等于k，那么表示第k小的数字肯定小于等于mid
        return count >= k;
    }
}
