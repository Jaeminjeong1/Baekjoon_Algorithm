import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());

            // 입력을 한 줄씩 읽어서 배열에 저장
            int[] nums = new int[M];
            int idx = 0;
            while (idx < M) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    nums[idx++] = Integer.parseInt(st.nextToken());
                }
            }

            // 최대 힙: 중앙값 이하
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            // 최소 힙: 중앙값 이상
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            List<Integer> medians = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                int num = nums[i];

                // 1. 값 삽입
                if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                // 2. 힙 크기 균형 맞추기
                if (maxHeap.size() < minHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                } else if (maxHeap.size() - minHeap.size() > 1) {
                    minHeap.offer(maxHeap.poll());
                }

                // 3. 홀수 번째 수일 때 중앙값 저장
                if ((i + 1) % 2 == 1) {
                    medians.add(maxHeap.peek());
                }
            }

            // 출력
            sb.append(medians.size()).append("\n");
            for (int i = 0; i < medians.size(); i++) {
                sb.append(medians.get(i)).append(" ");
                if ((i + 1) % 10 == 0) sb.append("\n");
            }
            if (medians.size() % 10 != 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
