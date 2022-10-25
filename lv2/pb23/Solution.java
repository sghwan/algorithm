package lv2.pb23;

import java.util.*;

/**
 * [1차] 뉴스 클러스터링
 */
class Solution {
    public boolean validateString(String str) {
        return str.matches("[a-z]+");
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> strMap1 = new HashMap<>();
        Map<String, Integer> strMap2 = new HashMap<>();
        Set<String> strSet = new HashSet<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2);
            if(validateString(tmp)) {
                strMap1.put(tmp, strMap1.getOrDefault(tmp, 0) + 1);
                strSet.add(tmp);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2);
            if(validateString(tmp)) {
                strMap2.put(tmp, strMap2.getOrDefault(tmp, 0) + 1);
                strSet.add(tmp);
            }
        }

        double intersection = 0.0;
        double union = 0.0;

        for(String s : strSet)
            union += Math.max(strMap1.getOrDefault(s, 0) , strMap2.getOrDefault(s, 0));

        for(String s : strMap2.keySet())
            if(strMap1.containsKey(s))
                intersection += Math.min(strMap1.get(s), strMap2.get(s));

        if(strSet.size() == 0) return 65536;

        return answer = (int) (intersection / union * 65536);
    }
}
