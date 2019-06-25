package leet20190625;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 说明：
 *
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());    // java内部最小堆实现
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        List<Integer> list = new ArrayList<>();
        while (! pq.isEmpty()) {
            list.add(pq.remove().e);
        }

        return list;
    }

    // 比较器
    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq a, Freq b)  {
            return a.freq - b.freq;
        }
    }

    private class Freq {
        int e;       // 元素
        int freq;    // 频次

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        List list = new Solution().topKFrequent(nums, 2);
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println("finish :)");
    }
}
