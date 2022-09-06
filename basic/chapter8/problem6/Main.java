package chapter8.problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] pa;
    static int[] ch;

    public static void dfs(int l, int[] arr, int n, int m) {
        if (l == m) {
            StringBuilder sb = new StringBuilder();
            for (int x : pa) sb.append(x).append(" ");
            System.out.println(sb);
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pa[l] = arr[i];
                    dfs(l + 1, arr, n, m);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        ch = new int[n];
        pa = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(0, arr, n, m);
    }
}
