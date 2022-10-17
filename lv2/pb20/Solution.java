package lv2.pb20;

/**
 * n^2 배열 자르기
 */
public class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left) + 1;
        int[] answer = new int[len];
        int idx = 0;

        for (long i = left; i <= right; i++) {
            int x = (int) (i / n) + 1;
            int y = (int) (i % n) + 1;
            if (x <= y) answer[idx++] = y;
            else answer[idx++] = x;
        }

        return answer;
    }
}
