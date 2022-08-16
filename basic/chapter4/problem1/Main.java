package chapter4.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static char solution(int n, String str) {
        char answer = 0;
        char[] strArr = str.toCharArray();
        int[] result = new int[5];
        int max = 0;
        int tmp = 0;

        for (int i = 0; i < n; i++) {
            result[strArr[i] - 65]++;
        }

        for (int i = 0; i < 4; i++) {
            if (max < result[i]) {
                max = result[i];
                tmp = i;
            }
        }

        answer = (char) (tmp + 65);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        System.out.println(solution(n, str));
        return;
    }
}