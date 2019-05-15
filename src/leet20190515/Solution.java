package leet20190515;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 *     必须在原数组上操作，不能拷贝额外的数组。
 *     尽量减少操作次数。
 */
public class Solution {
    /**
     * 利用额外的空间
     * @param nums 目标数组
     */
    public static void moveZeroes(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        int flag = 0;

        for (int i = 0; i < nums.length; i++) {
            if (numsCopy[i] != 0) {
                nums[flag++] = numsCopy[i];
            }
        }

        for (int j = flag; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }
}
