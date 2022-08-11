package chapter3.problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int solution(int n) {
        int answer = 0;
        int p1 = 1, p2 = 2;
        int range = 0;
        int sum = p1 + p2;

        if (n % 2 == 0) {
            range = n / 2;
        } else {
            range = n / 2 + 1;
        }

        for(p2 = 3; p2 <= range; p2++) {
            if(sum < n) sum += p2;
            if(sum == n) answer++;
            while(sum >= n) {
                sum -= p1;
                if(sum == n) answer++;
                p1++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }


}
