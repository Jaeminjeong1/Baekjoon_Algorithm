import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!deq.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                deq.offer(deq.poll());
            }

            sb.append(deq.poll());
            if (!deq.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb);

    }
}