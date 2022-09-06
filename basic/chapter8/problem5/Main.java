package chapter8.problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MAX_VALUE;

    public static void dfs(int rest, int cnt, int[] type, int flag) {
        if (flag == 0) return;
        if (rest == 0) {
            answer = Math.min(answer, cnt);
        } else {
            for (int x : type) {
                dfs(rest % x, cnt + (rest / x), type, rest / x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] type = new int[n];


        for (int i = 0; i < n; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        dfs(m, 0, type, m);
        System.out.println(answer);
    }
}
