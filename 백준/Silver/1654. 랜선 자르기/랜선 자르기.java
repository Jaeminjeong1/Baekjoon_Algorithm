import java.io.*;
import java.util.*;

public class Main {

    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        Collections.sort(list);

        long hi = list.get(list.size() - 1) + 1;
        long lo = 0;

        while (lo + 1 < hi) {
            long mid = (hi + lo) / 2;
            if (check(mid, N)) {
                lo = mid;
            }
            else hi = mid;
        }

        System.out.println(lo);
    }

    private static boolean check(long mid, int N) {
        long sum = 0;
        for (Long i : list) {
            sum += (i / mid);
        }
        return N <= sum;
    }
}
