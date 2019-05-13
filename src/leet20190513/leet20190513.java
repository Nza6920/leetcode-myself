package leet20190513;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 *
 *     尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *     要求使用空间复杂度为 O(1) 的原地算法。
 */
public class leet20190513 {
    /**
     * 额外空间
     * @param nums 目标数组
     * @param k 右移个数
     */
    public static void  rotate(int[] nums, int k)
    {
        if (nums.length == 1 || k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k - nums.length;
        }

        int[] result = new int[nums.length];

        for (int i = nums.length - k, j = 0; i < nums.length; i++, j++) {
            result[j] = nums[i];
        }

        for (int i = 0, j = k; i < nums.length - k && j < result.length; i++, j++) {
            result[j] = nums[i];
        }
        // 原数组， 原数组的开始位置， 目标数组， 目标数组的开始位置， 拷贝个数
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    /**
     * 反转
     * @param nums 目标数组
     * @param k 右移个数
     */
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);       // 整体反转
        reverse(nums, 0, k - 1);       // 局部反转(前)
        reverse(nums, k, n - 1);            // 局部反转(后)
    }


    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 双重循环
     * @param nums 目标数组
     * @param k 右移个数
     */
    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] reverse = new int[]{1,2,3,4,5,6,7};
        rotate2(reverse, 3);

        System.out.println("success :)");
    }
}
