package leet190331;

import java.util.Arrays;

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

