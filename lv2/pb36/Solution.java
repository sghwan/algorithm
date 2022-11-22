package lv2.pb36;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * 키카오 주차 요금 계산
 */
class Solution {
    private static final Map<String, Integer> parkingMap = new HashMap<>();
    private static final Map<String, Integer> timeMap = new HashMap<>();

    private int convertToMinutes(String timeInfo) {
        String[] time = timeInfo.split(":");
        int hour = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);

        return minutes + hour * 60;
    }

    private void recordTotalTime(String number, int time) {
        int entranceTime = parkingMap.get(number);
        int stayTime = time - entranceTime;
        int totalTime = timeMap.getOrDefault(number, 0);
        timeMap.put(number, stayTime + totalTime);
        parkingMap.remove(number);
    }

    private void recordTime(String status, String number, int time) {
        if (status.equals("IN")) {
            parkingMap.put(number, time);
        } else {
            recordTotalTime(number, time);
        }
    }

    private void clearParkingLot() {
        // keySet()을 그대로 향상된 for문에 대입하면 parkingMap.remove() 와 같이 작용을 하기 때문에 런타임 에러 발생
        String[] numberSet = parkingMap.keySet().toArray(new String[0]);
        for (String number : numberSet) {
            recordTotalTime(number, 23 * 60 + 59);
        }
    }

    private int[] calculateFees(int[] fees) {
        String[] numberSet = timeMap.keySet().toArray(new String[0]);
        int[] answer = new int[numberSet.length];
        int idx = 0;
        int basicTime = fees[0];
        int basicFee = fees[1];
        double unitTime = fees[2];
        int unitFee = fees[3];
        Arrays.sort(numberSet);

        for (String number : numberSet) {
            int totalTime = timeMap.get(number);
            int overTime = Math.max(totalTime - basicTime, 0);
            answer[idx++] = (int) (basicFee + (Math.ceil(overTime / unitTime)) * unitFee);
        }

        return answer;
    }

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] info = record.split(" ");
            int time = convertToMinutes(info[0]);
            String number = info[1];
            String status = info[2];
            recordTime(status, number, time);
        }

        clearParkingLot();

        return calculateFees(fees);
    }
}
