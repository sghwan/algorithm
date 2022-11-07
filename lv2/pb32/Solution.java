package lv2.pb32;

/**
 * 땅 따먹기
 */
class Solution {
    static final int COLUMN_LENGTH = 4;

    private int getAnswer(int answer, int[] dynamicLandRow) {
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dynamicLandRow[i]);
        }

        return answer;
    }

    private void setRow(int[] landRow, int[][] dynamicLand, int i) {
        for (int j = 0; j < COLUMN_LENGTH; j++) {
            dynamicLand[i][j] = getMax(dynamicLand[i - 1], landRow[j], j);
        }
    }

    private int getMax(int[] previousRow, int now, int nowIndex) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < COLUMN_LENGTH; i++) {
            if (i == nowIndex) continue;
            max = Math.max(max, now + previousRow[i]);
        }

        return max;
    }

    public int solution(int[][] land) {
        int answer = 0;
        int row = land.length;
        int[][] dynamicLand = new int[row][COLUMN_LENGTH];

        for (int i = 0; i < 4; i++) {
            dynamicLand[0][i] = land[0][i];
        }

        for (int i = 1; i < row; i++) {
            setRow(land[i], dynamicLand, i);
        }

        answer = getAnswer(answer, dynamicLand[row - 1]);

        return answer;
    }
}