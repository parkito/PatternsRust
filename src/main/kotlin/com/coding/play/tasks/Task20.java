package com.coding.play.tasks;

import java.util.Iterator;
import java.util.NavigableMap;

public class Task20 {
    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map) {
        if (map.firstEntry().getKey() % 2 != 0) {
            return map.subMap(map.firstKey(), true, getNKey(4, map), true)
                    .descendingMap();
        } else {
            return map.subMap(getNKey(map.size() - 4, map), true, map.lastKey(), true)
                    .descendingMap();
        }
    }

    private static Integer getNKey(int n, NavigableMap<Integer, String> map) {
        Iterator<Integer> iterator = map.keySet().iterator();
        Integer nElem = null;
        for (int i = 0; i < n; i++) {
            nElem = iterator.next();
        }
        return nElem;
    }

    public static NavigableMap<Integer, String> getSubMap1(NavigableMap<Integer, String> map) {
        int first = map.firstKey() % 2 != 0 ? map.firstKey() : map.lastKey() - 4;
        return map.subMap(first, true, first + 4, true).descendingMap();
    }
}
