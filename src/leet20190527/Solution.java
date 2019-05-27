package leet20190527;

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 *
 *     给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 *     输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class Solution {
    /**
     * 排序法
     * @param nums 目标数组
     * @return int
     */
    public static int maximumProduct(int[] nums) {
        if (nums.length < 3) return nums[nums.length - 1] * nums[nums.length - 2];
        Arrays.sort(nums);

        // 只有下面两种情况
        int r1 = nums[nums.length - 1] * nums[nums.length - 2] *  nums[nums.length - 3];
        int r2 = nums[0] * nums[1] *  nums[nums.length - 1];

        return r1 > r2 ? r1 : r2;
    }

    /**
     * 标记法
     * @param nums 目标数组
     * @return int
     */
    public static int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int t : nums) {
            if (t > max1) {
                max3 = max2;
                max2 = max1;
                max1 = t;
            } else if(t > max2) {
                max3 = max2;
                max2 = t;
            } else if(t > max3) {
                max3 = t;
            }
            if (t < min1) {
                min2 = min1;
                min1 = t;
            }else if (t < min2){
                min2 = t;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,4};
        int max1 = maximumProduct(nums);
        int max2 = maximumProduct2(nums);

        System.out.println("finish :)");
    }
}
