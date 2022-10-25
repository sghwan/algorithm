package lv2.pb21;

import java.util.*;

/**
 * 위장
 */
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];
            hashMap.put(category, hashMap.getOrDefault(category, 1) + 1);
        }

        Collection<Integer> test = hashMap.values();
        answer = test.stream().reduce(1, (a, b) -> a * b) - 1;

        return answer;
    }
}
