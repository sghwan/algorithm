package lv2.pb10;

import java.util.Map;
import java.util.HashMap;

/**
 * 영어 끝말잇기
 */
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = { 0, 0 };
        int num = 2;
        Map<String, Integer> hash = new HashMap<>();

        hash.put(words[0], 1);

        for (int i = 1; i < words.length; i++) {
            if(words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) || hash.containsKey(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            hash.put(words[i], 1);
        }

        return answer;
    }
}
