package com.coding.play.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task24 {

    private static final List<String> ZEROS = Arrays.asList("", "0", "00", "000", "0000", "00000", "000000", "0000000");

    public static void main(String[] args) {
        System.out.println(findSchedules(56, 8, "???8???"));
        System.out.println(findSchedules(3, 2, "??2??00"));
    }

    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
        List<String> result = new ArrayList<>();
        int vacantPositions = 0;
        int vacantHours = workHours;

        for (int i = 0; i < pattern.length(); i++) {
            char curChar = pattern.charAt(i);
            if (curChar == '?') {
                vacantPositions++;
            } else {
                vacantHours -= Character.getNumericValue(curChar);
            }
        }

        StringBuilder maxBustValue = new StringBuilder();
        for (int i = 0; i < vacantPositions; i++) {
            maxBustValue.append(9);
        }

        int bustMax = Integer.parseInt(maxBustValue.toString());

        for (int i = 0; i < bustMax; i++) {
            String curNum = String.valueOf(i);
            if (curNum.length() < vacantPositions) {
                curNum = ZEROS.get(vacantPositions - curNum.length()) + curNum;
            }

            int locSum = 0;
            for (int j = 0; j < curNum.length(); j++) {
                int numericValue = Character.getNumericValue(curNum.charAt(j));
                if (numericValue > dayHours) {
                    locSum = -1;
                    break;
                }
                locSum += numericValue;
                if (locSum > vacantHours) {
                    locSum = -1;
                    break;
                }
            }

            if (locSum == vacantHours) {
                StringBuilder localResult = new StringBuilder();
                for (int j = 0, k = 0; j < pattern.length(); j++) {
                    char currChar = pattern.charAt(j);
                    if (currChar == '?') {
                        if (curNum.length() <= k) {
                            localResult.append(0);
                        } else {
                            localResult.append(curNum.charAt(k));
                        }
                        k++;
                    } else {
                        localResult.append(currChar);
                    }
                }
                result.add(localResult.toString());
            }
        }

        result.sort(Comparator.naturalOrder());
        return result;
    }
}
