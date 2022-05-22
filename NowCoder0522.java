public class NowCoder0522 {

    /**
     * 选择排序
     * 时间复杂度 O(N^2)
     * 空间复杂度O(1)
     * @param array
     * @return
     */
    public static int[] selectedSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 冒泡排序
     * 时间复杂度 O(N^2)
     * 空间复杂度O(1)
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    /**
     * 异或运算
     * 1、 0^N = N  ;   N^N = 0
     * 2、交换率、结合率
     *     a^b = b^a ;  (a^b)^c = a^(b^c)
     * 3、交换 a和b的值 (前提：a和b指向的地址不一样，内存中是不一样的，即以下这个方法中的i和j需要不相等)
     *     a = a ^ b;
     *     b = a ^ b; (a ^ b ^ b = a ^ 0 = a)
     *     a = a ^ b; (a ^ b ^ a = a ^ a ^ b = 0 ^ b = b)
     * @param array
     * @param i
     * @param j
     */
    private static void swap1(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[j] ^ array[i];
    }

    /**
     * 找到数组中出现奇数次的1个数字
     * 其它的数字都出现偶数次
     * @param array
     * @return
     */
    public static int oddTimesNum(int[] array) {
        int eor = 0;
        for (int num : array) {
            eor ^= num;
        }
        return eor;
    }

    /**
     * 找到数组中出现奇数次的2个数字(a != b)
     * 其它的数字都出现偶数次
     * @param array
     * @return
     */
    public static int[] evenTimesNum(int[] array) {
        int eor = 0;
        for (int num : array) {
            eor ^= num;
        }
        // eor = a ^ b
        // & : 1 & 1 = 1 ; 其余为0
        // | : 0 | 0 = 0 ; 其余为1
        // 提取出eor1最右侧的1 : eor & (~eor + 1)
        int rightOne = eor & (~eor + 1);

        int a = 0;
        for (int num : array) {
            if ((num ^ rightOne) == 0) {
                a ^= num;
            }
        }
        int b = eor ^ a;
        return new int[]{a, b};
    }

    /**
     * 插入排序
     * 时间复杂度 O(N^2)
     * 空间复杂度 O(1)
     */
    public static int[] insetSort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j > 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
        return array;
    }

    /**
     * 二分查找
     * 时间复杂度 O(logN)
     *
     * 在一个有序数组array中，找某个数num是否存在
     * @param array
     * @param num
     * @return
     */
    public static boolean searchNumExist(int[] array, int num) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (array[mid] == num) {
                return true;
            } else if (array[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    /**
     * 二分查找
     *
     * 在一个有序数组array中，找到 >=num 最左侧的位置下标，如果找不到则返回 -1
     * @param array
     * @param num
     * @return
     */
    public static int searchLeftBiggerThanNum(int[] array, int num) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (array[mid] >= num && array[mid - 1] < num) {
                return mid;
            }

            if (array[mid] >= num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * 局部最小值
     * 返回一个局部最小值的下标，如果没有则返回 -1
     * @param array
     * @return
     */
    public static int searchLocalMin(int[] array) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) {
                return mid;
            } else if (array[mid] > array[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}

