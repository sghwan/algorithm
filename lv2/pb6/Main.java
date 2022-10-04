package lv2.pb6;

class Solution {
    static long[] fibo;

    public long dfs(int n) {
        if(n == 0) return 0L;
        if(n == 1) return 1L;
        if(fibo[n] != 0) return fibo[n];
        return fibo[n] = dfs(n - 1) + dfs(n - 2);
    }

    public long solution(int n) {
        long answer = 0L;
        fibo = new long[n + 1];
        dfs(n);
        answer = fibo[n] % 1234567L;
        return answer;
    }
}
