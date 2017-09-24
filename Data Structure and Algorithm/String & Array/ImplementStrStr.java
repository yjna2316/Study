/*
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/#/description
 */

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int L = needle.length();
        for (int i = 0; i <= haystack.length() - L; i ++) {
            if (haystack.substring(i, i + L).equals(needle)) return i;
        }
        return -1;
    }
}

/* solution2 - time complexity O(mn) */
public class Solution {
    public int strStr(String haystack, String needle) {
        int L = needle.length();
        if (L == 0) return 0;
        for (int i = 0; i <= haystack.length() - L; i ++) {
            for (int j = 0; j < L && haystack.charAt(i + j) == needle.charAt(j); j ++) {
                if (j == L - 1) return i;
            }
        }
        return -1;
    }
}

/* solution3 - time complexity O(mn) */
public class Solution {
  public int strStr(String haystack, String needle) {
    for (int i = 0; ; i++) {
      for (int j = 0; ; j++) {
        if (j == needle.length()) return i;
        if (i + j == haystack.length()) return -1;
        if (needle.charAt(j) != haystack.charAt(i + j)) break;
      }
    }
  }
}