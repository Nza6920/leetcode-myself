package leet20190521;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 *
 * 注意:
 *
 *     1 <= k <= n <= 30,000。
 *     所给数据范围 [-10,000，10,000]。
 */
public class Solution {
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum+=nums[i];
        }

        int max = sum;

        for(int j = 1; (j + k - 1) < nums.length; j++){
            sum = sum - nums[j-1] + nums[j+k-1];
            max = Math.max(max, sum);
        }
        return (double)max/k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6,7};
        double maxA = findMaxAverage(nums, 2);

        System.out.println("finish :)");
    }
}
