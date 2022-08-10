package chapter3.problem4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int n, int m, int[] a) {
        int answer = 0;
        int p1 = 0;
        int p2 = 1;

        int tmp = a[p1] + a[p2];

        while (p1 < n && p2 < n) {
            if (tmp < m) {
                p2++;
                if (p2 == n) break;
                tmp = tmp + a[p2];
            } else if (tmp > m) {
                tmp = tmp - a[p1++];
            } else {
                answer++;
                tmp = tmp - a[p1++];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.print(solution(n, m, a));

        return;
    }
}