import java.util.*;
import java.io.*;

class Solution
{
    private static int[] fac =new int[10];
    private static int[] kyu = new int[9];
    private static int[] in = new int[9];
    private static boolean[] used = new boolean[19];
    private static boolean[] visited = new boolean[10];
    private static int winCnt;
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
        fac[0] = 1;
        for(int i = 1; i < 10; i++){
        	fac[i] = fac[i - 1] * i;
        }

		for(int test_case = 1; test_case <= T; test_case++)
		{
            init();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 9;  ++i){
                kyu[i] = Integer.parseInt(st.nextToken());
                used[kyu[i]] = true;
            }
            for(int i = 1, idx = 0; i < 19; ++i){
            	if(!used[i])
                    in[idx++] = i;
            }
            cardGame(0,0,0,0);
            sb.append("#").append(test_case).append(" ").append(winCnt).append(" ").append(fac[9]-winCnt).append("\n");
		}
        System.out.println(sb.toString());
	}
    
    private static void init(){
    	winCnt=0;
        Arrays.fill(used, false);
        Arrays.fill(visited, false);
    }
    
    private static void cardGame(int scoreK, int scoreI, int dep, int flag){
        if(scoreI > 85){
            return;
        } else if(scoreK > 85){
        	winCnt += fac[9 - dep];
            return;
        }
        for(int i = 0; i < 9; ++i){
        	if((flag & (1<<i)) != 0)
                continue;
            int sum = kyu[dep] + in[i];
            if(kyu[dep] > in[i])
                cardGame(scoreK + sum, scoreI, dep + 1, flag | (1 << i));
            else
                cardGame(scoreK, scoreI + sum, dep + 1, flag | (1 << i));
        }
    }
}