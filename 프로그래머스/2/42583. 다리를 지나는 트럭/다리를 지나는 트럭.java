import java.util.*;

class Solution {

    static class Truck {
        int weight;
        int distance;

        Truck(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
    }

    static LinkedList<Truck> waiting = new LinkedList<>();
    static int answer;
    static int waitingWeight;

    public int solution(int bridge_length, int max_weight, int[] truck_weights) {

        Queue<Truck> queue = new LinkedList<>();

        for (int weight : truck_weights) {
            queue.offer(new Truck(weight, 0));
        }

        answer = 0;
        waitingWeight = 0;
        waiting.clear();

        // 1초 경과 -> 다리 트럭 이동 -> 도착한 트럭 제거 -> 다음 트럭 들어올지 여부 체크 -> 새로운 트럭 들어온다.
        while (!queue.isEmpty() || !waiting.isEmpty()) {

            // 1초 경과
            // 기존 다리 위 트럭 이동 + 도착한 트럭 제거
            oneSecondLater(bridge_length);

            // 대기 중인 트럭이 없다면
            // 다리 위 트럭만 계속 이동시키면 됨
            if (queue.isEmpty()) {
                continue;
            }

            // 대기 중인 트럭 중 가장 앞
            Truck now = queue.peek();

            // 현재 트럭이 다리에 올라갈 수 있다면
            if ((waitingWeight + now.weight <= max_weight)
                    && (waiting.size() < bridge_length)) {

                waiting.offer(now);
                waitingWeight += now.weight;
                queue.poll();
            }
        }

        return answer;
    }

    // 1초 경과 -> 한 칸씩 이동 + 도착한 트럭 제거
    static void oneSecondLater(int bridge_length) {

        for (int i = 0; i < waiting.size(); i++) {
            waiting.get(i).distance++;
        }

        if (!waiting.isEmpty()
                && waiting.peek().distance >= bridge_length) {

            Truck arrived = waiting.poll();
            waitingWeight -= arrived.weight;
        }
        
        answer++;
    }
}