package com.coding.play.tasks;

import java.util.HashMap;

public class Task26 {

    static int sherlockAndAnagrams(String s) {
        int anagrams = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String pString = s.substring(j, j + i);
                int pLength = pString.length();
                for (int k = j + 1; k <= s.length() - pLength; k++) {
                    String cString = s.substring(k, k + pLength);
                    if (isAnagram(pString, cString)) {
                        anagrams++;
                    }
                }
            }
        }
        return anagrams;
    }

    private static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);
            int aOrDefault = aMap.getOrDefault(aChar, 0);
            int bOrDefault = bMap.getOrDefault(bChar, 0);
            aMap.put(aChar, aOrDefault + 1);
            bMap.put(bChar, bOrDefault + 1);
        }
        if (aMap.size() != bMap.size()) {
            return false;
        }
        return aMap.equals(bMap);
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("cdcd"));
        System.out.println(sherlockAndAnagrams("kkkk"));

//        String s = "cdcd";
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 0; j <= s.length() - i; j++) {
//                System.out.println(s.substring(j, j + i));
//            }
//        }
    }

}









