package lv2.pb14;

class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dy = new long[n];

        for (int i = 0; i < n; i++) {
            dy[i] = i + 1;
        }

        for (int i = 2; i < n; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2]) % 1234567;
        }

        return answer = dy[n - 1];
    }
}
