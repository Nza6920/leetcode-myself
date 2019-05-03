package leet20190503;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 10000
 *     -10000 <= A[i] <= 10000
 *     A 已按非递减顺序排序。
 */
public class Solution {
    /**
     * 双指针
     * @param A 数组
     * @return int[]
     */
    public static int[] sortedSquares2(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }

    /**
     * 排序
     * @param A 数组
     * @return int[]
     */
    public static int[] sortedSquares3(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i)
            ans[i] = A[i] * A[i];

        Arrays.sort(ans);
        return ans;
    }

    /**
     * java 8 新特性
     * @param A 数组
     * @return int[]
     */
    public static int[] sortedSquares4(int[] A) {
        return Arrays.stream(A).map(n->n*n).sorted().toArray();
    }

    /**
     * 不需要额外空间
     * @param A 数组
     * @return int[]
     */
    public static int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                break;
            }
            A[i] = -A[i];

            for (int j = i+1; j < A.length; j++) {
                if (A[j-1] < A[j]) {
                    break;
                }
                int temp = A[j];
                A[j] = A[j-1];
                A[j-1] = temp;
                i = -1;
            }
        }

        for (int k = 0; k < A.length; k++) {
            A[k] *= A[k];
        }

        return A;
    }

    public static void main(String[] args) {

        int[] a = sortedSquares(new int[]{-11,-7,-3,-3,-2});
    }
}
