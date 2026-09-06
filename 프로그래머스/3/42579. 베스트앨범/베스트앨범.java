import java.util.*;

class Solution {

    static class Song {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        // 장르별 총 재생 횟수
        Map<String, Integer> totalMap = new HashMap<>();

        // 장르별 노래 목록
        Map<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            String genre = genres[i];
            int play = plays[i];

            // 1. 장르별 총 재생 횟수
            totalMap.put(
                genre,
                totalMap.getOrDefault(genre, 0) + play
            );

            // **2. 장르별 노래 목록 생성 **
            songMap.putIfAbsent(genre, new ArrayList<>());

            // **노래 추가**
            songMap.get(genre).add(new Song(i, play));
        }


        // **장르 목록**
        List<String> genreList = new ArrayList<>(totalMap.keySet());

        // **총 재생 횟수 기준 내림차순**
        genreList.sort(
            (g1, g2) -> totalMap.get(g2) - totalMap.get(g1)
        );


        List<Integer> answer = new ArrayList<>();

        for (String genre : genreList) {

            List<Song> songs = songMap.get(genre);

            // **장르 안에서 노래 정렬**
            songs.sort((s1, s2) -> {

                // 재생 횟수가 같으면 고유 번호 작은 순
                if (s1.play == s2.play) {
                    return s1.index - s2.index;
                }

                // 재생 횟수 많은 순
                return s2.play - s1.play;
            });


            // **최대 2곡 선택**
            answer.add(songs.get(0).index);

            if (songs.size() >= 2) {
                answer.add(songs.get(1).index);
            }
        }


        // **List<Integer> → int[]**
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}