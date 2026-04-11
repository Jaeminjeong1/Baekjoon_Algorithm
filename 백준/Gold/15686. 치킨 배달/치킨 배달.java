import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickenShop = new ArrayList<>();
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new int[]{r, c});
                } else if (value == 2) {
                    chickenShop.add(new int[]{r, c});
                }
            }
        }

        visited = new boolean[chickenShop.size()];
        backtracking(0, 0);

        System.out.println(answer);
    }

    private static void backtracking(int start, int depth) {
        if (depth == M) {
            answer = Math.min(answer, getCityChickenDistance());
            return;
        }

        for (int i = start; i < chickenShop.size(); i++) {
            visited[i] = true;
            backtracking(i + 1, depth + 1);
            visited[i] = false;
        }
    }

    private static int getCityChickenDistance() {
        int sum = 0;

        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < chickenShop.size(); i++) {
                if (!visited[i]) {
                    continue;
                }

                int[] chicken = chickenShop.get(i);
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }

            sum += minDistance;
        }

        return sum;
    }
}