import java.io.*;
import java.util.*;

public class Main {
    static List<List<Long>> room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long attack = Long.parseLong(st.nextToken());

        room = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Long> list = new ArrayList<>();
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            list.add(a);
            list.add(b);
            list.add(c);
            room.add(list);
        }

        long hi = 1;
        for (List<Long> room : room) {
            long num = room.get(0);
            long monsterAttack = room.get(1);
            long monsterHeart = room.get(2);
            if (num == 1) {
                long hitCount = (monsterHeart - 1) / attack;
                hi += hitCount * monsterAttack;
            }
        }

        long lo = 0;

        while (lo + 1 < hi) {
            long mid = (hi + lo) / 2;
            if (check(mid, attack)) {
                hi = mid;
            }
            else lo = mid;
        }

        System.out.println(hi);
    }

    private static boolean check(long maxHeart, long attack) {
        long currentHeart = maxHeart;

        for (List<Long> longs : room) {
            if (currentHeart <= 0) {
                return false;
            }
            long num = longs.get(0);
            long b = longs.get(1);
            long c = longs.get(2);
            
            //포션룸
            if (num == 2) {
                attack += b;
                currentHeart += c;
                if (currentHeart > maxHeart) {
                    currentHeart = maxHeart;
                }
                continue;
            }

            // 몬스터와 싸움
            long hitCount = (c - 1) / attack;
            currentHeart -= hitCount * b;

            if (currentHeart <= 0) {
                return false;
            }
        }
        return currentHeart > 0;
    }
}