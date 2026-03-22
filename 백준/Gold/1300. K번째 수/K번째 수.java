import java.io.*;

// N <= 100_000
// int[N][N] -> 메모리 초과?

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int K = Integer.parseInt(br.readLine());

        long hi = K;
        long lo = 0;

        // mid 이하인 값은 몇개인가
        // mid >= order -> hi를 줄여야함.
        while (lo + 1 < hi) {
            long mid = (hi + lo) / 2;
            if (check(mid, K, N)) {
                hi = mid;
            }
            else lo = mid;
        }

        System.out.println(hi);
    }

    private static boolean check(long mid, long order, int N) {
        long count = 0;

        for (int i = 1; i < N + 1; i++) {
            // i일떄 mid 이하인 값의 개수
            count += Math.min(N, (int) mid / i);
        }
        return count >= order;
    }

}
