package leet20190524;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 说明 :
 *
 *     输入的数组长度范围在 [1, 10,000]。
 *     输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class Solution {
    public static int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int min = nums[nums.length -1];
        int end = -1;
        int max = nums[0];
        for (int i = 1, j =  nums.length-2; i < nums.length && j > -1; i++,j--) {
            if (nums[i] < max) {
                end = i;
            }else {
                max = nums[i];
            }

            if (nums[j] > min) {
                start = j;
            }else {
                min = nums[j];
            }
        }
        return start == -1 ? 0 : end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,2,4};
        int result = findUnsortedSubarray(nums);

        System.out.println("finish :)");
    }
}
