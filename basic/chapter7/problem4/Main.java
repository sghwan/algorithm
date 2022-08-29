package chapter7.problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] fibo;
    public static int solution(int n) {
        if(fibo[n] > 0) return fibo[n];
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        else return fibo[n] = solution(n - 2) + solution(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n + 1];
        solution(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}

