import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String S = br.readLine();

        HashSet<String> substrings = new HashSet<>();

        // 모든 부분 문자열을 생성하여 Set에 추가
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                substrings.add(S.substring(i, j));
            }
        }

        // 서로 다른 부분 문자열 개수 출력
        System.out.println(substrings.size());
    }
}