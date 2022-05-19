package com.huawei.test.demo.nowcoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 迷宫问题 - bfs
 * 题目描述
 * 小华一不小心进入了一个迷宫.这个迷宫有一个出口.小华可以上下左右移动.迷宫里也有障碍物,如果这个地方是有障碍的,
 * 那么这个地方是不能走进去的.现在小华想知道他能否走出迷宫,若能走出迷宫至少需要多少步.
 *
 * 解答要求
 * 时间限制：1000ms, 内存限制：100MB
 * 输入
 * 对于每个输入文件,第一行输入一个整数N(1<=N<=500),接下来N行,每行N个字符,表示这个迷宫的状态.
 * 其中’S’表示小华的位置,’E’表示终点,’#’表示障碍物,’.’表示可以走的地方.
 *
 * 输出
 * 如果可以走到终点,请输出走到终点的最少步数,否则输出-1.
 *
 * 样例
 * 输入样例 1
 * 3
 * #S#
 * ...
 * E##
 *
 * 输出样例 1
 * 3
 */
public class NowCoder0519Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || n > 500) {
            System.out.println(-1);
        }
        char[][] sq = new char[n][n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            char[] row = sc.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                sq[i][j] = row[j];
                if ('S' == row[j]) {
                    x = i;
                    y = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int step = 0;
        int[][] dirs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
        sq[x][y] = '#';
        boolean hasRoad = false;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                if (queue.isEmpty()) {
                    break;
                }
                int[] tmp = queue.poll();
                int tx = tmp[0];
                int ty = tmp[1];

                for (int[] dir : dirs) {
                    int ntx = tx + dir[0];
                    int nty = ty + dir[1];
                    if (ntx < 0 || ntx >= n || nty < 0 || nty >= n || '#' == sq[ntx][nty]) {
                        continue;
                    }

                    if ('E' == sq[ntx][nty]) {
                        queue = new LinkedList<>();
                        hasRoad = true;
                        break;
                    } else {
                        sq[ntx][nty] = '#';
                    }

                    queue.offer(new int[]{ntx, nty});
                }
            }
        }

        System.out.println((step != 0 && hasRoad) ? step : -1);
    }
}
