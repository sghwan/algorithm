package lv2.pb1;

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        String answer = new StringBuilder().append(arr[0]).append(" ").append(arr[arr.length - 1]).toString();
        return answer;
    }
}

