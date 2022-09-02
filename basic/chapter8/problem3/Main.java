package chapter8.problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] score, time;
    static int answer = 0;
    static int n, m;

    public static void dfs(int w, int totalTime, int totalScore) {
        if (totalTime > m) return;
        if (w == n) {
            answer = Math.max(answer, totalScore);
        } else {
            dfs(w + 1, totalTime + time[w], totalScore + score[w]);
            dfs(w + 1, totalTime, totalScore);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        score = new int[n];
        time = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(tmp.nextToken());
            time[i] = Integer.parseInt(tmp.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);

        return;
    }
}

