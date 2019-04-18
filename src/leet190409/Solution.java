package leet190409;

import java.util.HashMap;
import java.util.Map;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution {
    public static long climbStairs(int n) {
        return move(0, n);
    }

    public static long move(long start, long end)
    {
        if (start > end) return 0;       // 起点大于终点, 没有路径

        if (start == end) return 1;      // 起点等于终点, 只有一条

        long sum = move(start + 1, end) + move(start + 2, end); // 递归
        return sum;
    }

    public static void main(String... args)
    {
        long start = System.currentTimeMillis();
        System.out.println("有 " + climbStairs2(4400) + " 种走法.");
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + "ms");
    }


    public static long climbStairs2(int n) {
        Map<Long, Long> cache = new HashMap<>();        // 使用哈希结构缓存(查找快速)

        return move(0, n, cache);
    }

    public static long move(long start, long end, Map<Long, Long> cache)
    {
        if (start > end) return 0;       // 起点大于终点, 没有路径

        if (start == end) return 1;      // 起点等于终点, 只有一条

        if (cache.containsKey(start)) return cache.get(start);     // 缓存中有的话就不需要递归了

        long sum = move(start + 1, end, cache) + move(start + 2, end, cache); // 递归

        cache.put(start, sum);          // 缓存起来

        return sum;
    }
}
