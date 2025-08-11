import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            cantoMain(N);
        }


    }

    static void cantoMain(int N) {
        StringBuilder sb = new StringBuilder();
        int len = (int) Math.pow(3, N);
        String[] strings = new String[len];
        Arrays.fill(strings, "-");

        cantoSort(strings, 0, len);
        for (String string : strings) {
            sb.append(string);
        }

        System.out.println(sb);
    }
    // M = 시작점, len = 길이
    static void cantoSort (String[] A, int M ,int len) {
        if (len < 3) return;
        int third = len / 3;

        for (int i = M + third; i < M + third * 2 ; i++) {
            A[i] = " ";
        }

        cantoSort(A, M, third);
        cantoSort(A, M + 2*third, third);
    }
}