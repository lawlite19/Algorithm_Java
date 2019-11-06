package leetcode.cn;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class L005_最长回文子串 {
    public static void main(String[] args) {
        String result = longestPalindrome("babad");
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        int i, j, max = 0, len = s.length(), temp;
        String result = "";
        if (len < 1)
            return result;
        for (i = 0; i < len; ++i) {//遍历字符
            for (j = 0; (i - j >= 0) && (i + j < len); ++j) {//奇数个字符，以当前i为中心扩展
                if (s.charAt(i - j) != s.charAt(i + j))//过程中不相等则break
                    break;
                temp = j * 2 + 1;//得到长度
                if (temp > max) {
                    result = s.substring(i - j, i + j + 1);
                    max = temp;//更改最大值
                }
            }

            for (j = 0; (i - j >= 0) && (i + j + 1 < len); ++j) {//偶数个字符，往右多扩展一个
                if (s.charAt(i - j) != s.charAt(i + j + 1))//不相等则退出
                    break;
                temp = j * 2 + 2;//得到长度
                if (temp > max) {
                    result = s.substring(i - j, i + j + 2);
                    max = temp;//更改最大值
                }

            }
        }
        return result;
    }
}