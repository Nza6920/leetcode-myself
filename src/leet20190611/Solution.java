package leet20190611;

import com.sun.deploy.util.ArrayUtil;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 *
 *     输出结果中的每个元素一定是唯一的。
 *     我们可以不考虑输出结果的顺序。
 *
 */
public class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j])) {
                set.add(nums2[j]);
            }
        }

        int[] res = new int[set.size()];
        Iterator iterator = set.iterator();
        int k = 0;
        while (iterator.hasNext()) {
            res[k] = (int) iterator.next();
            k++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] res = intersection(nums1, nums2);

        System.out.println("finish :)");
    }
}
