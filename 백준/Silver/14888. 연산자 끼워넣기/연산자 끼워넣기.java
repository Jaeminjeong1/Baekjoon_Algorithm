import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] numbers;
    static int[] operators = new int[4];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);

        
    }

    static void backtracking(int result, int depth) {
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int next = result;
                int current = numbers[depth];

                if (i == 0) next += current;
                else if (i == 1) next -= current;
                else if (i == 2) next *= current;
                else if (i == 3) {
                    if (result < 0) next = -(-(next) / current);
                    else next = next / current;
                }

                backtracking(next, depth + 1);
                operators[i]++;
            }

        }

    }
}