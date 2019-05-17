package leet20190517;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class Solution {
    /**
     * 将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
     * @param nums 目标数组
     * @return List
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int item : nums){
            if (item < 0) {
                item = -item;
            }
            if (nums[item-1] > 0) {
                nums[item-1] = -nums[item-1];
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List list = findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
