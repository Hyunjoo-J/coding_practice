import java.util.*;
import java.io.*;
 
class Solution
{
    static int element, limit, res;
    static int[] good;
    static int[] cal;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            element = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());
            good = new int[element];
            cal = new int[element];
            for (int i = 0; i < element; i++){
                st = new StringTokenizer(br.readLine());
                good[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            res = 0;
            dfs(0, 0, 0);
            ans.append("#" + test_case + " " + res + "\n");
        }
        System.out.println(ans);
    }
    public static void dfs(int k, int score, int num){
        if (k > limit)
            return;
        if (num == element){
            res = Math.max(res, score);
            return ;
        }
        dfs(k+cal[num], score+good[num], num+1);
        dfs(k,score,num+1);
    }
}