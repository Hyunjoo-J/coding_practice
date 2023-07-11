import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                que.add(Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            ans = que.poll();
        }
        System.out.println(ans);
    }
}