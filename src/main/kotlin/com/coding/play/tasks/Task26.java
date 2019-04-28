package com.coding.play.tasks;

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
                        System.out.print(pString + " " + cString);
                        System.out.println("{" + j + ";" + (j + i) + "}{" + k + ";" + (k + pLength) + "}");
                        anagrams++;
                    }
                }
            }
        }
        return anagrams;
    }

    // TODO: 2019-04-29 change anagrams defentions
    private static boolean isAnagram(String a, String b) {
        for (int i = 0, j = a.length() - 1; i < a.length(); i++, j--) {
            if (a.charAt(i) != b.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("cdcd"));
        System.out.println(sherlockAndAnagrams("kkkk"));

        String s = "cdcd";
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                System.out.println(s.substring(j, j + i));
            }
        }
    }

}









