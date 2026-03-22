import java.io.*;
import java.util.*;

public class Main {
    static int[][] rules;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int ruleCount = Integer.parseInt(st.nextToken());
        long dotoriCount = Long.parseLong(st.nextToken());

        rules = new int[ruleCount][3];

        for (int i = 0; i < ruleCount; i++) {
            st = new StringTokenizer(br.readLine());
            rules[i][0] = Integer.parseInt(st.nextToken());
            rules[i][1] = Integer.parseInt(st.nextToken());
            rules[i][2] = Integer.parseInt(st.nextToken());
        }

        long lo = 0;
        long hi = size;

        while (lo + 1 < hi) {
            long mid = (hi + lo) / 2;
            if (check(mid, dotoriCount)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        System.out.println(hi);
    }

    private static boolean check(long boxNum, long dotoriCount) {
        long count = 0;

        for (int[] rule : rules) {
            int startBox = rule[0];
            int endBox = rule[1];
            int interval = rule[2];

            if (startBox > boxNum) continue;

            long last = Math.min(endBox, boxNum);

            count += (last - startBox) / interval + 1;
            if (count >= dotoriCount) {
                return true;
            }
        }
        return count >= dotoriCount;
    }
}
