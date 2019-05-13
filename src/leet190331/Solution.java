package leet190331;

import java.util.Arrays;

/**
 * 给定一个排序数组和一个目标值，如果找到目标，返回索引。如果没有，返回按顺序插入的索引所在的位置。您可以假定数组中没有重复项。
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int result = 0;

        if (target > nums[nums.length - 1]) {
            int[] numsPlus = Arrays.copyOf(nums, nums.length+1);
            numsPlus[nums.length - 1] = target;
            return numsPlus.length - 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (target < nums[i]) {
                int[] numsPlus = Arrays.copyOf(nums, nums.length+1);

                for (int j = numsPlus.length - 1; j > i; j--) {
                    numsPlus[j] = numsPlus[j-1];
                }

                numsPlus[i] = target;

                return i;
            }
        }


        return result;
    }

    // 二分法
    public static int searchInsert2(int[] nums, int target) {
        int begin = 0,tail = nums.length-1,mid;
        while(begin<tail){
            mid = (begin+tail)/2;
            if(nums[mid]<target)
                begin = mid+1;
            else
                tail = mid;
        }
        return begin+1;
    }

    public static void main(String... args)
    {
        int[] nums = new int[]{1,3,5,6};

        System.out.println(searchInsert2(nums, 7));

    }

}

