package lv2.pb19;

import java.util.*;

/**
 * 튜플
 */
public class Solution {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        s = s.substring(2, s.length() - 2);
        String[] set = s.split("\\},\\{");

        Arrays.sort(set, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (String x : set) {
            String[] tmp = x.split(",");
            for (String y : tmp) {
                int element = Integer.parseInt(y);
                if (!answer.contains(element))
                    answer.add(element);
            }
        }

        return answer;
    }
}
