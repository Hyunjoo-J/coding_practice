import java.util.*;
import java.io.*;

class Solution
{
    static String[] arr;
    static int max,change;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T= Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr = stk.nextToken().split("");
            max = 0;
            change = Integer.parseInt(stk.nextToken());

            if (arr.length < change){
                change = arr.length;
            }
            dfs(0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }

    static void dfs(int start, int cnt){
        if(cnt == change){
            String res = "";
            for (String s : arr){
                res += s;
            }
            max = Math.max(max,Integer.parseInt(res));
            return;
        }
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j < arr.length; j++){
                String tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

                dfs(i, cnt+1);
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}