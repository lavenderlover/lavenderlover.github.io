package com.huawei.test.demo.nowcoder;

import java.util.Scanner;

public class Nowcoder519 {

    /**
     * Hello , Welcome to   my   country
     * A10;S20;;W10;D30;X;A1A;B10A11;;A10;;
     * ABC;AKL;DA1;;
     * @param args
     */
    public static void main(String[] args) {
        // HJ1 字符串最后一个单词的长度
        Scanner sc = new Scanner(System.in);
        String content = sc.nextLine();
        String[] list = content.split("\\s+");
        System.out.println(list[list.length - 1].length());

        // HJ17
        String positionStr = sc.nextLine();
        String regex = "^[ASWD][0-9]{1,2}$";
        String[] positions = positionStr.split(";+");
        int x = 0;
        int y = 0;
        for (String position : positions) {
            if (position.matches(regex)) {
                String dir = position.substring(0, 1);
                int num = Integer.parseInt(position.substring(1));
                switch (dir) {
                    case "A":
                        x -= num;
                        break;
                    case "D":
                        x += num;
                        break;
                    case "W":
                        y += num;
                        break;
                    case "S":
                        y -= num;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(x + "," + y);
    }
}
