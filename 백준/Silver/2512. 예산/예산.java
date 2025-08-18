import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 지방 수
        int[] requests = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine()); // 총 예산

        int low = 0;
        int high = Arrays.stream(requests).max().getAsInt(); // 요청 중 최댓값
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2; // 상한액 후보
            long total = 0;

            for (int r : requests) {
                total += Math.min(r, mid);
            }

            if (total <= M) { 
                // 예산 안 넘음 → 상한액 올려도 됨
                result = mid;
                low = mid + 1;
            } else {
                // 예산 초과 → 상한액 줄여야 함
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
