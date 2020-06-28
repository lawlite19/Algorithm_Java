package leetcode.cn;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L008_字符串转换整数 {
    public static void main(String[] args) {
        L008_字符串转换整数 p = new L008_字符串转换整数();
        assert p.myAtoi(" -1010023630o4") == -1010023630;
        assert p.myAtoi("-41") == -41;
        assert p.myAtoi("42") == 42;
        assert p.myAtoi("   -42") == -42;
        assert p.myAtoi("4193 with words") == 4193;
        assert p.myAtoi("words and 987") == 0;
        assert p.myAtoi("-91283472332") == -2147483648;
        assert p.myAtoi(" ") == 0;
    }

    public int myAtoi(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (str.length() == i) {
            return 0;
        }
        boolean isNegative = false;
        if (str.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        int result = 0;
        for (; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num <0 || num > 9) {
                break;
            }
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) {
                return isNegative ?  Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result  = result * 10 + num;
        }
        return isNegative ? -result : result;
    }
}
