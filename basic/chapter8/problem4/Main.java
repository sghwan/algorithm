package chapter8.problem4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] pm;

    public static void dfs(int l) {
        if (l == m) {
            StringBuilder sb = new StringBuilder();
            for (int x : pm)  sb.append(x).append(" ");
            System.out.println(sb);
        } else {
            for (int i = 1; i <= n; i++) {
                pm[l] = i;
                dfs(l + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];

        for (int i = 1; i <= n; i++) {
            dfs(0);
        }
    }
}


