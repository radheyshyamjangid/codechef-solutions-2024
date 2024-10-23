package org.problems.strings;

class Solution {
    public int longestPalindrome(String s) {
        int[] mp = new int[250];
        for (char c : s.toCharArray()) {
            mp[c - 'A']++;
        }
        int sum = 0;
        for (int i = 0; i < 250; i++) {
            if (mp[i] % 2 == 0) {
                sum += mp[i];
            } else {
                sum = sum + mp[i] - 1;
            }
        }
        if (sum < s.length())
            return sum + 1;
        else
            return sum;
    }
}
