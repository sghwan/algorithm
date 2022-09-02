package chapter8.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int answer = 0;
    static int c, n;

    public static void dfs(int w, int sum) {
        if(sum > c) return;
        if (w == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(w + 1, sum + arr[w]);
            dfs(w + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
        System.out.println(answer);

        return;
    }
}
