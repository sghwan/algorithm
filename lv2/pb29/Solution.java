package lv2.pb29;

/**
 * N 진수 게임
 * 정답은 맞으나 효율 개선 필요
 */
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String store = "";
        int cnt = 0, i = 0;

        while (cnt < t) {
            store += Long.toString(i, n).toUpperCase();

            if(m * cnt + p < store.length()) {
                answer += store.charAt(m * cnt + p - 1);
                cnt++;
            }

            i++;
        }

        return answer;
    }
}