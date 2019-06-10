package leet20190610;

/**
 *给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 *
 *
 * 提示：
 *
 *     2 <= A.length <= 20000
 *     A.length % 2 == 0
 *     0 <= A[i] <= 1000
 *
 */
public class Solution {

    public static int[] sortArrayByParityII(int[] A) {

        int[] B = new int[A.length];

        for (int i = 0, e = 0, o = 1; i < A.length; i++) {
            if (A[i] % 2 == 0 && e < B.length) {
                B[e] = A[i];
                e += 2;
            } else if (o < B.length){
                B[o] = A[i];
                o += 2;
            }
        }

        return B;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {4,2,5,7};
        int[] B = sortArrayByParityII(nums);

        System.out.println("finish :)");
    }
}
