import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 크기 N의 최소힙: 지금까지 본 수 중 큰 N개만 유지
        PriorityQueue<Integer> pq = new PriorityQueue<>(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (pq.size() < N) {
                    pq.offer(x);
                } else if (x > pq.peek()) {
                    pq.poll();
                    pq.offer(x);
                }
            }
        }
        System.out.println(pq.peek()); // N번째 큰 수
    }
}
