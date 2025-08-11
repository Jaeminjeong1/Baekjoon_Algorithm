import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        PriorityQueue<Long> Q = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        
        for (int i = 0; i < K; i++) {
            
            while (idx < N && arr[idx] < M) {
                Q.offer(arr[idx]);
                idx++;
            }

            if (Q.isEmpty()) break;

            M += Q.poll();
        }

        System.out.println(M);
    }
}