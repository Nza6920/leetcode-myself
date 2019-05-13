package leet190329;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
// 思路: 双指针(两条指针互相等待)
public class Solution {
    // my
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int flag = nums.length -1 ;    // 标志位

        for (int i = 0; i <= flag; i++) {
            if (nums[i] == val) {
                while (nums[i] == nums[flag]) {
                    if(--flag < i) {
                        return ++flag;
                    }
                }
                nums[i] = nums[flag];
                nums[flag] = val;
            }
        }
        return flag+1;
    }

    // answer1(删除量少时效率高)
    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    // answer2(删除量多时效率高)
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String... args)
    {
        int[] nums = new int[]{1,2,2,2,3};
        int length = removeElement(nums, 2);

        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
         }
    }
}
