package leet20190509;


/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 *     返回的下标值（index1 和 index2）不是从零开始的。
 *     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target)  return null;

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > target) {
                    break;
                }
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return null;
    }
    /**
     * 排除法
     * 一个循环，里面做一个排除法：
     * 两个指针，一个指向最大的数字，一个指向最小的。
     * 小的指针指向可能是最小的数，如果这时候两数之和还比target大，那么大的指针往前移，一直到两数之和不大于target的时候停下（这时候大的指针可能指最大的数）。
     * 然后大的指针指向可能是最大的数，如果这时候两数之和比target还小，那小的指针往后移动，一直到两数之和不小于target的时候停下（这时候小的的指针可能指最小的数）
     * 比如：1，3，4，9，11，14，20  target：13
     * 一开始可能的最小索引指向1，那么1+20>13 排除20，1+14>13排除14,
     *  现在可能的最大索引指向11，1+11<13 排除1
     *  现在可能的最小索引指向3，那么3+11>13 排除11,
     *  然后可能的最大索引指向9，发现加上可能的最小索引指向的4刚刚好是13
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int smallIndex=0;
        int largeIndex=numbers.length-1;
        while (numbers[smallIndex] + numbers[largeIndex] != target) {
            while (numbers[smallIndex] + numbers[largeIndex] > target) {
                if (largeIndex == 0 || largeIndex <= smallIndex) return null;
                largeIndex--;
            }
            while (numbers[smallIndex] + numbers[largeIndex] < target) {
                smallIndex++;
                if (smallIndex == numbers.length || smallIndex >= largeIndex) return null;
            }
        }
        return new int[]{smallIndex+1,largeIndex+1};
    }

    /**
     * 双指针
     * @param numbers  数组
     * @param target   目标数
     * @return int[]
     */
    public static int[] twoSum3(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while(hi > lo) {
            int sum = numbers[lo] + numbers[hi];
            if(sum > target)
                hi--;
            else if(sum < target)
                lo++;
            else
                return new int[]{lo + 1, hi + 1};
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};

        int[] result = twoSum2(numbers, 16);

        System.out.println("finish :)");
    }
}