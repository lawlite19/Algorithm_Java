package leetcode.cn;

public class L006_Z字形变换 {
    public static void main(String[] args) {
        String result = convert("LEETCODEISHIRING", 3);
        System.out.println(result);  // LCIRETOESIIGEDHN
        assert(result.equals("LCIRETOESIIGEDHN"));

        result = convert("LEETCODEISHIRING", 4);
        System.out.println(result);  // LDREOEIIECIHNTSG
        assert(result.equals("LDREOEIIECIHNTSG"));

    }
    public static String convert(String s, int numRows) {
        return "";
    }
}
