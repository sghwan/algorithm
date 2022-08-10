package chapter2.problem11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int n, int[][] studentInfo) {
        int max = Integer.MIN_VALUE;
        int answer = Integer.MAX_VALUE;

        for (int j = 1; j < n + 1; j++) {
            int[] studentNum = new int[n + 1];
            for (int i = 1; i < 6; i++) {
                int tmp = studentInfo[j][i];
                for (int k = 1; k < n + 1; k++) {
                    if (j == k) continue;
                    if (studentInfo[k][i] == 1) continue;
                    if (tmp == studentInfo[k][i]) studentNum[k] = 1;
                }
            }
            int cnt = 0;
            for (int m = 1; m < n + 1; m++) {
                if (studentNum[m] > 0) cnt++;
            }
            if (cnt > max) {
                max = cnt;
                answer = j;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] studentInfo = new int[n + 1][6];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 6; j++) {
                studentInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(n, studentInfo));

        return;
    }
}
