package chapter8.problem9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] p;

    public static void dfs(int l, int s, int n, int m) {
        if (l == m) {
            for (int x : p) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                p[l] = i;
                dfs(l + 1, i + 1, n, m);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[m];

        dfs(0, 1, n, m);

    }
}
