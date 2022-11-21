package lv2.pb35;

import java.util.Arrays;

/**
 * N개의 최소공배수
 */
class Solution {
    public int lcm(int a, int b) {
        if(b == 0) return a;
        return lcm(b, a % b);
    }

    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int gcm = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            gcm = gcm * arr[i] / lcm(gcm, arr[i]);
        }

        return answer = gcm;
    }
}
