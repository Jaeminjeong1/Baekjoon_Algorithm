import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp != 0) {
                pq.offer(temp);
            } else {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}