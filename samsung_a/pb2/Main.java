package samsung_a.pb2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] origin, matrix, rcs;
    static int n, m, k;
    static int min = Integer.MAX_VALUE;
    static int[] check, p;

    public static void rotate(int r, int c, int s) {
        for (int size = 1; size <= s; size++) {
            int row = r - size;
            int col = c - size;
            int edge = matrix[row][col];

            for (int i = 0; i < size * 2; i++) {
                matrix[row][col] = matrix[row + 1][col];
                row++;
            }

            for (int i = 0; i < size * 2; i++) {
                matrix[row][col] = matrix[row][col + 1];
                col++;
            }

            for (int i = 0; i < size * 2; i++) {
                matrix[row][col] = matrix[row - 1][col];
                row--;
            }

            for (int i = 0; i < size * 2; i++) {
                matrix[row][col] = matrix[row][col - 1];
                col--;
            }

            matrix[row][col + 1] = edge;
        }
    }

    public static void permutation(int l) {
        if (l == k) {
            for (int i = 0; i < k; i++) {
                int r = rcs[p[i]][0];
                int c = rcs[p[i]][1];
                int s = rcs[p[i]][2];
                rotate(r, c, s);
            }

            for (int i = 1; i <= n; i++) {
                int sum = 0;
                for (int j = 1; j <= m; j++) {
                    sum += matrix[i][j];
                }
                min = Math.min(min, sum);
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    matrix[i][j] = origin[i][j];
                }
            }
        } else {
            for (int i = 0; i < k; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    p[l] = i;
                    permutation(l + 1);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        origin = new int[n + 1][m + 1];
        matrix = new int[n + 1][m + 1];
        rcs = new int[k][3];
        p = new int[k];
        check = new int[k];


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                origin[i][j] = matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rcs[i][0] = Integer.parseInt(st.nextToken());
            rcs[i][1] = Integer.parseInt(st.nextToken());
            rcs[i][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(min);
    }
}
