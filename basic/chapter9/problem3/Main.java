package chapter9.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Time implements Comparable<Time> {
        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time t) {
            if (this.time == t.time) return this.state - t.state;
            return this.time - t.time;
        }
    }

    public static int solution(Time[] timeLine) {
        int answer = 0;
        int cnt = 0;
        Arrays.sort(timeLine);

        for (Time t : timeLine) {
            if (t.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Time[] timeLine = new Time[2 * n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            timeLine[2 * i] = new Time(s, 's');
            timeLine[2 * i + 1] = new Time(e, 'e');
        }

        System.out.println(solution(timeLine));
    }
}
