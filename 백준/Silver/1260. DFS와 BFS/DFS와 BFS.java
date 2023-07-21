import java.util.*;
import java.io.*;

public class Main {
    static int[][] treeArray;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        
        treeArray = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            treeArray[a][b] = 1;
            treeArray[b][a] = 1;
        }
        
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        
        visited = new boolean[N+1];
        bfs(V);
        System.out.println();
    }
    private static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
        if (v == treeArray.length)
            return;
        for (int i = 1; i < treeArray.length; i++){
            if (treeArray[v][i] == 1 && visited[i] == false)
                dfs(i);
        }
    }

    private static void bfs(int v){
        visited[v] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        System.out.print(v + " ");
        while (!q.isEmpty()){
            int n = q.poll();
            for(int i = 1; i < treeArray.length; i++) {
                if(treeArray[n][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    q.offer(i);
                }
            }
        }
    }
}