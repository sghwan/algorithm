package chapter7.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void solution(int n) {
        if(n == 0) {
            return;
        }
        solution(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }
}
