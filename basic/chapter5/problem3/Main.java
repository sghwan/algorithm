package chapter5.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int n, int m, int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            int k = moves[i] - 1;
            for (int j = 0; j < n; j++) {
                if (board[j][k] > 0) {
                    if (!stack.isEmpty() && stack.peek() == board[j][k]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][k]);
                    }
                    board[j][k] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, board, moves));
        return;
    }
}

