import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int r, c, ans;
    static int[][] board;
    static boolean[] alpha = new boolean[26];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        alpha = new boolean[26];
        for(int i=0; i<r; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<line.length; j++) {
                String alpha = line[j];
                board[i][j] = alpha.charAt(0)-'A';
            }
        }
        dfs(0,0,0);
        System.out.println(ans);
    }
    private static void dfs(int x, int y, int sum){
        if(alpha[board[x][y]]) {
            ans = Math.max(ans, sum);
            return;
        }
        else {
            alpha[board[x][y]] = true;
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || ny <0 || nx >r-1 || ny > c-1) continue;
                dfs(nx, ny, sum+1);
            }
            alpha[board[x][y]] = false;
        }
    }
}