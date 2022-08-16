package chapter3.problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int p1 = 0;
        int cnt = 0;

        for (int p2 = 0; p2 < n; p2++) {
            if (arr[p2] == 0) cnt++;
            while (cnt > k) {
                if (arr[p1] == 0) cnt--;
                p1++;
            }
            answer = Math.max(answer, p2 - p1 + 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }

}



