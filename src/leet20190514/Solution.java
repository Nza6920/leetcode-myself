package leet20190514;

import java.util.Arrays;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class Solution {
    /**
     * 先排序再比较
     * @param nums 目标数组
     * @return int
     */
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 异或
     * @param nums 目标数组
     * @return int
     */
    public static int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    /**
     * 求和相减
     * @param nums 目标数组
     * @return int
     */
    public static int missingNumber3(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result+=nums[i];
        }
        return (nums.length*(nums.length+1))/2-result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1};
        System.out.println(missingNumber(nums));
    }
}
