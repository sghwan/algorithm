package chapter8.problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n = 0;
    static int answer = 0;

    public static void dfs(int x, int y, int[][] island) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && island[nx][ny] == 1) {
                island[nx][ny] = 0;
                dfs(nx, ny, island);
            }
        }
    }

    public static void solution(int[][] island) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 1) {
                    answer++;
                    island[i][j] = 0;
                    dfs(i, j, island);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] island = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(island);
        System.out.println(answer);
    }
}
