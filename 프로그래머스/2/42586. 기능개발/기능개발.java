import java.util.*;

class Solution {

    static class Task{
        int progress;
        int speed;
        
        Task(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Task> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Task(progresses[i], speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {

            for (Task task : queue) {
                task.progress += task.speed;
            }

            if (queue.peek().progress >= 100) {
                int count = 0;

                while (!queue.isEmpty() && queue.peek().progress >= 100) {
                    queue.poll();
                    count++;
                }

                answer.add(count);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}