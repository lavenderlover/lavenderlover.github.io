package com.algorithm.test.demo.nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * 1.密码锁
 * 现在一个紧急的任务是打开一个密码锁。
 * 密码由四位数字组成，每个数字从1到9进行编码。
 * 每次可以对任何一位数字加1或减1。
 * 当将9加1时，数字将变为1，当
 * 将1减1时，数字将变为9.
 * 你也可以交换相邻数字，每一个行动记作异步。
 * 现在你的任务是使用最小的步骤来打开锁。
 *
 * 注意：最左边的数字不与最右边的数字相邻。
 *
 * 输入格式：
 * 第一行输入四位数字，表示密码锁的初始状态。
 * 第二行输入四位数字，表示开锁的密码。
 *
 * 输出格式：
 * 输出一个整数，表示最小步骤。
 *
 * 样例输入：
 * 1234
 * 2144
 * 样例输出
 * 2
 */
public class NowCoder0523Demo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String begin = sc.nextLine();
        String target = sc.nextLine();
        if (begin.equals(target)) {
            System.out.println(0);
            return;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();
                for (String next : getNextDatas(current)) {
                    if (!visited.contains(next)) {
                        if (target.equals(next)) {
                            System.out.println(step);
                            return;
                        }
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        System.out.println(-1);
    }

    private static List<String> getNextDatas(String data) {
        List<String> nextList = new ArrayList<>();
        char[] array = data.toCharArray();
        for (int i = 0; i < 4; i++) {
            char tmp = array[i];
            array[i] = tmp == '9' ? '1' : (char) (tmp + 1);
            nextList.add(new String(array));
            array[i] = tmp == '1' ? '9' : (char) (tmp - 1);
            nextList.add(new String(array));
            array[i] = tmp;
        }

        for (int i = 0; i < 3; i++) {
            if (array[i] == array[i + 1]) {
                continue;
            }
            char tmp1 = array[i];
            char tmp2 = array[i + 1];
            array[i] = tmp2;
            array[i + 1] = tmp1;
            nextList.add(new String(array));
            array[i] = tmp1;
            array[i + 1] = tmp2;
        }
        return nextList;
    }
}
