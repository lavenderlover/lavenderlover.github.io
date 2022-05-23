/**
 * 59. 螺旋矩阵 II
 *  给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class NowCoder0522Demo1 {

    public static int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int[][] matrix = new int[n][n];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int num = 1;
        matrix[0][0] = num;
        int dirIndex = 0;
        int x = 0;
        int y = 0;
        int[] dir = dirs[dirIndex];
        while (++num <= maxNum) {
            if (isValidPosition(x, y, dir, n) || matrix[x + dir[0]][y + dir[1]] != 0) {
                dirIndex = dirIndex == 3 ? 0 : dirIndex + 1;
                dir = dirs[dirIndex];
            }
            x += dir[0];
            y += dir[1];
            matrix[x][y] = num;
            if (num == maxNum) {
                break;
            }
        }

        return matrix;
    }

    public static boolean isValidPosition(int x, int y, int[] dir, int n) {
        return x + dir[0] >= n || y + dir[1] >= n || x + dir[0] < 0 || y + dir[1] < 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + (j == n - 1 ? "" : ","));
            }
            System.out.println();
        }
    }
}
