package chapter8.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, total = 0;
    static int[] arr;
    static boolean flag = false;
    static String answer = "NO";

    public static void dfs(int idx, int sum) {
        if (flag) return;
        if (sum > total / 2) return;
        if (idx == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(idx + 1, sum + arr[idx]);
            dfs(idx + 1, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        dfs(0, 0);
        System.out.println(answer);
        return;
    }
}