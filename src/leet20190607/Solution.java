package leet20190607;

import java.util.Map;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 5000
 *     0 <= A[i] <= 5000
 */
public class Solution {
    public static int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0, s = 0, e = B.length - 1; i < A.length && s <= e; i++) {
            if (A[i] % 2 == 0) {
                B[s] = A[i];
                s++;
            } else {
                B[e] = A[i];
                e--;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,4};
        int[] B = sortArrayByParity(nums);

        System.out.println("finish :)");
    }
}
