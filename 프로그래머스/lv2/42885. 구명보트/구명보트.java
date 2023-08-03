import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int first = 0;
        int second = people.length - 1;
        
        Arrays.sort(people);
        while (first <= second){
            answer++;
            if (people[first] + people[second] <= limit)
                first++;
            second--;
        }
        return answer;
    }
}