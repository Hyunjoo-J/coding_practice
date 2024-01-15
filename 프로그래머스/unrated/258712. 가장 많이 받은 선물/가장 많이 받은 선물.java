import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int flen = friends.length;
            int glen = gifts.length;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < flen; ++i)
                map.put(friends[i], i);
            int[][] arr = new int[flen][flen + 1];
            for (int i = 0; i < glen; ++i) {
                String line = gifts[i];
                String A = line.split(" ")[0];
                String B = line.split(" ")[1];
                arr[map.get(A)][map.get(B)] += 1;
                arr[map.get(A)][flen] += 1;
                arr[map.get(B)][flen] -= 1;
            }
            int[] ans = new int[flen];
            for (int i = 0; i < flen; ++i) {
                for (int j = i + 1; j < flen; ++j) {
                    if (arr[i][j] > arr[j][i]) {
                        ans[i] += 1;
                    } else if (arr[i][j] < arr[j][i]) {
                        ans[j] += 1;
                    } else if (arr[i][flen] > arr[j][flen]) {
                        ans[i] += 1;
                    } else if (arr[i][flen] < arr[j][flen]) {
                        ans[j] += 1;
                    }
                }
            }
            int max = 0;
            for (int a : ans)
                max = Math.max(max, a);
            return max;
    }
}