import java.util.*;

class Solution {
    static class Song {
        int id, plays;
        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, List<Song>> songsMap = new HashMap<>();
        
        
        
        for(int i = 0; i < genres.length; i++){
            String g = genres[i];
            int p = plays[i];
            
            totalMap.put(g, totalMap.getOrDefault(g, 0) + p);
            songsMap.computeIfAbsent(g, k -> new ArrayList<>())
                    .add(new Song(i, p));
        }
        
        //장르 정렬
        List<String> genreList = new ArrayList<>(totalMap.keySet());
        genreList.sort((a, b) -> totalMap.get(b) - totalMap.get(a));
        
        // 3) 각 장르 내 곡 정렬: 재생수 내림차순, 같으면 id 오름차순 ⇒ 상위 2곡 선택
        List<Integer> ans = new ArrayList<>();
        for (String g : genreList) {
            List<Song> list = songsMap.get(g);
            list.sort((s1, s2) -> {
                if (s1.plays != s2.plays) return s2.plays - s1.plays; // plays desc
                return s1.id - s2.id;                                  // id asc
            });
            for (int i = 0; i < Math.min(2, list.size()); i++) {
                ans.add(list.get(i).id);
            }
        }

        // 4) 결과 변환
        return ans.stream().mapToInt(Integer::intValue).toArray();
    
    }
}