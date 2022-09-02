package chapter8.problem4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void dfs(int count, StringBuilder comb) {
        if (count == m) {
            System.out.println(comb);
        } else {
            for (int i = 1; i <= n; i++) {
                dfs(count + 1, comb.append(i).append(" "));
                comb.delete(comb.length() - 3, comb.length() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            dfs(1, new StringBuilder().append(i).append(" "));
        }
    }
}


