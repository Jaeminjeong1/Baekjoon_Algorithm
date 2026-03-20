import java.io.*;
import java.util.*;

public class Main {

    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(br.readLine());
            list.add(n);
        }

        Collections.sort(list);
        long hi = list.get(list.size() - 1) - list.get(0) + 1;
        long lo = 0;


        while (lo + 1 < hi) {
            long mid = (hi + lo) / 2;
            if (check(mid, C)) {
                lo = mid;
            }
            else hi = mid;
        }

        System.out.println(lo);
    }

    private static boolean check(long distance, long c) {
        long count = 1;
        long lastPicked = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - lastPicked >= distance) {
                count++;
                lastPicked = list.get(i);
            }
        }

        return count >= c;
    }

}
