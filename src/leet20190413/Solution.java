package leet20190413;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 *
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 */
public class Solution {
    /**
     * 最后一个字母，就是26的0次方乘以他代表的数字，倒数第二个字母就是26的一次方乘以他代表的数字，以此类推加起来
     * @param s 字符串
     * @return int
     */
    public static int titleToNumber(String s) {
        int res = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            int cur = s.charAt(len-i-1) - 'A' + 1;
            res += cur * Math.pow(26, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int res = titleToNumber("AAB");

        System.out.println("finish :)");
    }
}
