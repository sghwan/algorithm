package chapter8.problem10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int NUM = 7;
    static int[][] maze = new int[NUM][NUM];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void dfs(int x, int y) {
        if (x == NUM - 1 && y == NUM - 1) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > NUM - 1 || ny < 0 || ny > NUM - 1) continue;
                maze[x][y] = 1;
                if (maze[nx][ny] == 0) dfs(nx, ny);
                maze[x][y] = 0;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < NUM; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUM; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);

        return;
    }
}
