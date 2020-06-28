package leetcode.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L006_Z字形变换 {
    public static void main(String[] args) {
        String result = convert("LEETCODEISHIRING", 3);
        System.out.println(result);  // LCIRETOESIIGEDHN
        assert (result.equals("LCIRETOESIIGEDHN"));

        result = convert("LEETCODEISHIRING", 4);
        System.out.println(result);  // LDREOEIIECIHNTSG
        assert (result.equals("LDREOEIIECIHNTSG"));

    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return s;
        }

        List<StringBuilder> sBuilders = new ArrayList<>();
        for (int i=0; i< Math.max(numRows, s.length()); i++) {
            sBuilders.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goDown = false;
        for (int i = 0; i < s.length(); i++) {
            sBuilders.get(curRow).append(s.charAt(i));
            if (curRow == numRows - 1 || curRow == 0) {
                goDown = !goDown;
            }
            curRow += goDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        sBuilders.forEach(sBuilder -> {
            result.append(sBuilder.toString());
        });
        return result.toString();
    }
}
