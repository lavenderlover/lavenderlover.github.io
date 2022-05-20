import java.util.Scanner;

/**
 * 分割两字符串得到回文串
 * 题目描述
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。
 * 由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，
 * 同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。
 * 请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 *
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。
 * 比方说， s = “abc” 那么 “” + “abc” ， “a” + “bc” ， “ab” + “c” 和 “abc” + “” 都是合法分割。
 *
 * 如果 能构成回文字符串 ，那么请输出 “true”，否则输出 “false” 。
 *
 * 请注意， x + y 表示连接字符串 x 和 y 。
 *
 * 示例 1：
 *
 * 输入：a = “x”, b = “y”
 * 输出：true
 * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * aprefix = “”, asuffix = “x”
 * bprefix = “”, bsuffix = “y”
 * 那么 aprefix + bsuffix = “” + “y” = “y” 是回文串。
 * 示例 2：
 *
 * 输入：a = “ulacfd”, b = “jizalu”
 * 输出：true
 * 解释：在下标为 3 处分割：
 * aprefix = “ula”, asuffix = “cfd”
 * bprefix = “jiz”, bsuffix = “alu”
 * 那么 aprefix + bsuffix = “ula” + “alu” = “ulaalu” 是回文串。
 *
 * 解答要求
 * 时间限制：1000ms, 内存限制：256MB
 * 输入
 * 分两行输入两个字符串a，b
 * 1 <= a.length, b.length <= 100000
 * a.length == b.length
 * a 和 b 都只包含小写英文字母
 *
 * 输出
 * 如果 能构成回文字符串 ，那么请输出 “true”，否则输出 “false” 。
 *
 * 样例
 * 输入样例 1 复制
 * x
 * y
 * 输出样例 1
 * true
 */
public class NowCoder0520Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int length = a.length();
        if (length < 1 || length > 100000) {
            System.out.println(false);
            return ;
        }
        boolean flag = hasSameString(a, b, length) || hasSameString(b, a, length);
        System.out.println(flag);
    }

    public static boolean hasSameString(String a, String b, int length) {
        char[] stra = a.toCharArray();
        char[] strb = b.toCharArray();
        int left = 0;
        while (left <= length / 2) {
            if (stra[left] == strb[length - 1 - left]) {
                left++;
            } else {
                break;
            }
        }

        if (left >= length) {
            return true;
        }

        return check(a.substring(left, length - left)) || check(b.substring(left, length - left));
    }

    public static boolean check(String content) {
        int length = content.length();
        char[] array = content.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            if (array[i] != array[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
