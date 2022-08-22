package chapter5.problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static String solution(String curriculum, String mySchedule) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for (char x: curriculum.toCharArray()) {
            queue.add(x);
        }

        for(char x : mySchedule.toCharArray()) {
            if(queue.size() == 0) break;
            if(x == queue.peek()) queue.poll();
        }

        if(queue.size() > 0) answer = "NO";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String curriculum = br.readLine();
        String mySchedule = br.readLine();
        System.out.println(solution(curriculum, mySchedule));
    }
}
