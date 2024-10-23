package org.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class WordCanBeFormed {

    public static void main(String[] args) {

        countCharacters();
    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> mp = new HashMap();
        for (int i = 0; i < chars.length(); i++) {
            mp.put(chars.charAt(i), mp.getOrDefault(chars.charAt(i), 0) + 1);
        }
        System.out.println(mp);
        int sum = 0;
        int f = 0;
        for (int i = 0; i < words.length; i++) {
            f = 0;
            String word = words[i];
            Map<Character,Integer> temp = new HashMap<>(mp);
            for (int j = 0; j < word.length(); j++) {
                if (mp.containsKey(word.charAt(j))) {
                    if (mp.get(word.charAt(j)).equals(0)) {
                        mp.remove(word.charAt(i));
                    }
                    mp.put(word.charAt(j), mp.get(word.charAt(j) - 1));
                    continue;
                } else {
                    f = 1;
                    break;
                }
            }
            if (f == 0)
                sum += word.length();

        }
        return sum;
    }
}
