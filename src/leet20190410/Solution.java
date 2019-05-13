package leet20190410;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
class Solution {

    public static String addBinary(String a, String b) {

        char[] outChars = a.length() >= b.length() ? a.toCharArray() : b.toCharArray();
        char[] inChars = a.length() < b.length() ? a.toCharArray() : b.toCharArray();

        int aDecimal = 0;
        int bDecimal = 0;

        for (int out = outChars.length-1, in = inChars.length-1; out >=0; out--, in--) {
            if (in >= 0) {
                if (inChars[in] == '1') {
                    aDecimal +=  Math.pow(2, inChars.length - (in+1));
                }
            }
            if (outChars[out] == '1')
                bDecimal += Math.pow(2, outChars.length - (out+1));
        }

        int sum = aDecimal + bDecimal;

        StringBuffer sbf = new StringBuffer();

        if (sum == 0) sbf.append(0);

        while (sum != 0) {
            sbf.append(sum%2);
            sum/=2;
        }

        return sbf.reverse().toString();
    }

    public static void main(String... args)
    {
        System.out.println(addBinary("1101",
                "1011"));
    }
}
