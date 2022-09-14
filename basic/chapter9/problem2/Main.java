package chapter9.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class ConfTime implements Comparable<ConfTime> {
        int start;
        int end;

        public ConfTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ConfTime c) {
            if (this.end == c.end) return this.start - c.start;
            else return this.end - c.end;
        }
    }

    public static int solution(ConfTime[] info) {
        int answer = 0;
        int endTime = 0;
        Arrays.sort(info);

        for (ConfTime c : info) {
            if (c.start >= endTime) {
                endTime = c.end;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ConfTime[] info = new ConfTime[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            info[i] = new ConfTime(start, end);
        }

        System.out.println(solution(info));
    }
}
