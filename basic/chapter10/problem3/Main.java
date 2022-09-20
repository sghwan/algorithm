package chapter10.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public int solution(int[] arr, int n) {
        int answer = 0;
        int[] d = new int[n];

        d[0] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && d[j] > max) max = d[j];
            }
            d[i] = max + 1;
            answer = Math.max(answer, d[i]);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Solution s = new Solution();
        System.out.println(s.solution(arr, n));
    }
}