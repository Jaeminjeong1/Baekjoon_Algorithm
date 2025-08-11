import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i],'*');
        }

        star(0, 0, N);

        for (int i = 0; i < N; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.println(sb);

    }

    static void star(int x, int y, int N) {
        if (N < 3) return;
        int nextN = N / 3;

        for (int i = x + nextN; i < x + nextN * 2; i++) {
            for (int j = y + nextN; j < y + nextN * 2; j++) {
                map[i][j] = ' ';
            }
        }

        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                if (dx == 1 && dy == 1) continue;
                star(x + dx * nextN,y + dy * nextN, nextN);
            }
        }

    }

}