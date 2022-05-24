/**
 * 剑指 Offer II 077. 链表排序
 */
public class NowCoder0523Demo3 {
    
    // 766. 托普利茨矩阵
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                // 每一个数与它的左上角数相比较
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
