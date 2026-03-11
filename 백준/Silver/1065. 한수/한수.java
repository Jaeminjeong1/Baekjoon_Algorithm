import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 1; i <= input; i++) {
            if (d(i)) count++;
        }

        System.out.println(count);
    }

    private static boolean d(int n) {
        int digit = String.valueOf(n).length();
        if (digit == 1 || digit == 2) return true;
        if (n == 1000) return false;

        int d1 = n % 10;
        n = (n - d1) / 10;
        int d2 = n % 10;
        n = (n - d2) / 10;
        int d3 = n % 10;

        return (d1 - d2) == (d2 - d3);
    }
}