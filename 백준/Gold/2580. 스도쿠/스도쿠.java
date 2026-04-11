import java.io.*;
import java.util.*;

public class Main {

    static int[][] place = new int[9][9];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] box = new boolean[9][10];
    static List<int[]> blank = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 0; r < 9; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 9; c++) {
                int value = Integer.parseInt(st.nextToken());
                place[r][c] = value;

                if (place[r][c] == 0) {
                    blank.add(new int[]{r, c});
                } else {
                    row[r][value] = true;
                    col[c][value] = true;
                    box[(r / 3) * 3 + (c / 3)][value] = true;
                }
            }
        }

        backtracking(0);
    }

    static void backtracking(int depth) {
        if (depth == blank.size()) {
            printResult();
            System.exit(0);
        }

        int[] temp = blank.get(depth);

        int r = temp[0];
        int c = temp[1];
        int b = (r / 3)*3 + (c/3);

        for (int i = 1; i <= 9; i++) {
            if (!row[r][i] && !col[c][i] && !box[b][i]) {
                place[r][c] = i;
                row[r][i] = true;
                col[c][i] = true;
                box[b][i] = true;

                backtracking(depth + 1);

                place[r][c] = 0;
                row[r][i] = false;
                col[c][i] = false;
                box[b][i] = false;
            }
        }
    }

    static void printResult (){
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(place[r][c]);
                if(c < 8) sb.append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
