package leetcode.cn;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L003_最长子串 {
    public static void main(String[] args) {
        int len = L003_最长子串.lengthOfLongestSubstring("pwwkew");
        System.out.println(len);
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        int i=0, j=0;
        Set<Character> set = new HashSet<>();
        while(i<n && j<n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j-i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
