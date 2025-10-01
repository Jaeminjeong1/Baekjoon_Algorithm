import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken().trim();
        int B = Integer.parseInt(st.nextToken());

        long ans = 0;
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int digit = charToVal(c);
            ans = ans * B + digit;
        }
        System.out.println(ans);
    }

    private static int charToVal(char c) {
        if ('0' <= c && c <= '9') return c - '0';
        // 문제에서 대문자 사용이 명시되어 있음 (A~Z -> 10~35)
        return c - 'A' + 10;
    }
}
