// 451. Sort Characters By Frequency

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_451 {
        public static String frequencySort(String s) {
        
        Map<Character, Integer> map= new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);

        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a,b)-> b.getValue()- a.getValue()
        );

        pq.addAll(map.entrySet());

        StringBuilder result = new StringBuilder();

        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry =pq.poll();
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s= "assme";

        System.out.println(frequencySort(s));
    }
}
