package chapter8.problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo;
    static int[] ch, b, p;
    static boolean flag = false;

    public static int combination(int n, int r) {
        if (memo[n][r] != 0) return memo[n][r];
        if (n == r || r == 0) return 1;
        else return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public static void dfs(int l, int sum, int n, int f) {
        if (flag) return;
        if (l == n) {
            if (sum == f) {
                for (int x : p) System.out.print(x + " ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[l] = i;
                    dfs(l + 1, sum + (b[l] * p[l]), n, f);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        memo = new int[n + 1][n + 1];
        ch = new int[n + 1];
        b = new int[n];
        p = new int[n];

        for (int i = 0; i < n; i++) {
            b[i] = combination(n - 1, i);
        }

        dfs(0, 0, n, f);

    }

}
