import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int  m;
    static int[][] arr;
    static int[] visited;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        int c1, c2;
        StringTokenizer st;
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            c1 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            arr[c1][c2] = 1;
            arr[c2][c1] = 1;
        }
        bfs(1);
        System.out.println(ans);

    }
    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = 1;
        while(!q.isEmpty()){
            v = q.poll();
            for(int i = 1; i <= n; i++){
                if (visited[i] == 0 && arr[v][i] == 1){
                    q.add(i);
                    ans++;
                    visited[i] = 1;
                }
            }
        }

    }

}