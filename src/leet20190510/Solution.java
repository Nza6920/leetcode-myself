package leet20190510;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Solution {
    /**
     * 摩尔投票法
     * @param nums 数组
     * @return int
     */
    public static int majorityElement(int[] nums)
    {
        int count=0;//计算当前的数字出现的次数
        int mj=0;//当前判断的元素
        for (int i = 0; i < nums.length; i++)
        {
            //当次数为0时，则换下一判断元素
            if(count==0){
                mj=nums[i];
                count=1;
            } else if (nums[i]==mj) {
                count++;//当前元素等于判断元素，次数加一
            } else {
                count--;//不等于则次数减一
            }
        }
        return mj;
    }
    public static void main(String[] args) {
        int[] test = new int[]{2,2};
        int result = majorityElement(test);
        System.out.println(result);
    }
}
