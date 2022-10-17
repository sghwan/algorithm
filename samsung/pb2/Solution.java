package samsung.pb2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/**
 * swea [모의] 이상한 자석
 */
public class Solution {
    static int[][] magnet;

    public static void rotation(int num, int direction) {
        int[] flag = new int[4];
        flag[num] = direction;

        for (int i = num + 1; i < 4; i++) {
            if (magnet[i][6] != magnet[i - 1][2]) flag[i] = -flag[i - 1];
            else break;
        }

        for (int i = num - 1; i >= 0; i--) {
            if (magnet[i][2] != magnet[i + 1][6]) flag[i] = -flag[i + 1];
            else break;
        }

        for (int i = 0; i < 4; i++) {
            if (flag[i] == 1) {
                int tmp = magnet[i][7];
                for (int j = 7; j >= 1; j--) {
                    magnet[i][j] = magnet[i][j - 1];
                }
                magnet[i][0] = tmp;
            } else if (flag[i] == -1) {
                int tmp = magnet[i][0];
                for (int j = 0; j < 7; j++) {
                    magnet[i][j] = magnet[i][j + 1];
                }
                magnet[i][7] = tmp;
            }
        }
    }

    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int k = Integer.parseInt(br.readLine());
            magnet = new int[4][8];
            StringTokenizer st;
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < 8; l++) {
                    magnet[j][l] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int direction = Integer.parseInt(st.nextToken());
                rotation(num, direction);
            }

            for (int j = 0; j < 4; j++) {
                sum += magnet[j][0] * (Math.pow(2, j));
            }

            sb.append("#" + test_case + " ");
            sb.append(sum + "\n");
        }

        System.out.println(sb.toString());
    }
}
