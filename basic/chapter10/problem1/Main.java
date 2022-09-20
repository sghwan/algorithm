package chapter10.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] d = new int[n];
        d[0] = 1;
        d[1] = 2;
        for (int i = 2; i < n; i++) {
            d[i] = d[i - 2] + d[i - 1];
        }
        answer = d[n - 1];
        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }
}