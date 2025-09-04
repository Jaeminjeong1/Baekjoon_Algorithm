import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] result = new int[N + 1][3];
        int[][] cost = new int[N + 1][3];



        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        result[1][0] = cost[1][0];
        result[1][1] = cost[1][1];
        result[1][2] = cost[1][2];

        for (int i = 2; i <= N; i++) {
            result[i][0] = cost[i][0] + Math.min(result[i - 1][1], result[i - 1][2]);
            result[i][1] = cost[i][1] + Math.min(result[i - 1][0], result[i - 1][2]);
            result[i][2] = cost[i][2] + Math.min(result[i - 1][1], result[i - 1][0]);
        }

        int answer = Math.min(result[N][0], Math.min(result[N][1], result[N][2]));
        System.out.println(answer);

    }
}