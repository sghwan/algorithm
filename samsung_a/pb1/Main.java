package samsung_a.pb1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 삼성 a형 파이프 연결
 */
public class Main {
    static int[][] home;
    static int n;
    static int count = 0;

    public static void dfs(int x, int y, int degree) {
        if (x == n - 1 && y == n - 1) {
            count++;
            return;
        }
        if (degree == 0) {
            if (y + 1 < n && home[x][y + 1] == 0)
                dfs(x, y + 1, 0);
        } else if (degree == 90) {
            if (x + 1 < n && home[x + 1][y] == 0)
                dfs(x + 1, y, 90);
        } else {
            if (y + 1 < n && home[x][y + 1] == 0)
                dfs(x, y + 1, 0);
            if (x + 1 < n && home[x + 1][y] == 0)
                dfs(x + 1, y, 90);
        }
        if (x + 1 < n && y + 1 < n && home[x + 1][y] == 0 && home[x][y + 1] == 0 && home[x + 1][y + 1] == 0)
            dfs(x + 1, y + 1, 45);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        home = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);

        System.out.println(count);
    }
}

