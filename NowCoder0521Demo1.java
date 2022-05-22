import java.util.Scanner;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 *     你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 提示：
 *     0 <= nums.length <= 105
 *     -109 <= nums[i] <= 109
 *     nums 是一个非递减数组
 *     -109 <= target <= 109
 */
public class NowCoder0521Demo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String arrayStr = input.substring(1, input.indexOf(']'));
        int target = Integer.parseInt(input.substring(input.length() - 1));

        String[] numsStr = arrayStr.split(",");
        int length = numsStr.length;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        if (nums.length == 0) {
            System.out.println("-1,-1");
            return;
        }

        int[] result = new int[2];
        int first = searchBiggerEqualThan(nums, target, 0);
        if (first != nums.length && nums[first] == target) {
            result[0] = first;
            result[1] = searchBiggerEqualThan(nums, target + 1, first) - 1;
        } else {
            result[0] = result[1] = -1;
        }
        System.out.println(result[0] + "," + result[1]);
    }

    private static int searchBiggerEqualThan(int[] nums, int target, int l) {
        int ans = nums.length;
        int r = nums.length - 1;
        while (l <= r) {
           int mid = (l + r) / 2;
           if (nums[mid] >= target) {
               r = mid - 1;
               ans = mid;
           } else {
               l = mid + 1;
           }
        }
        return ans;
    }
}
