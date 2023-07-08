import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();

        test:
		for(int test_case = 1; test_case <= T; test_case++)
		{
            ans.append("#"+test_case+" ");
            int[][] arr = new int[9][9];
            for (int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < 9; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int res = 1;
            for (int i = 0; i < 9 && res == 1; i++){
            	int[] row = new int[10];
                int[] col = new int[10];
                for (int j = 0; j < 9; j++){
                	int r = arr[i][j];
                    int c = arr[j][i];
                    if (row[r] != 0 || col[c] != 0){
                    	res = 0;
                        ans.append("0\n");
                        continue test;
                    }
                    else{
                    	row[r]++;
                        col[c]++;
                    }
                }
            }
			for (int i = 0; i < 9 && res == 1; i += 3){
            	for (int j = 0; j < 9; j += 3){
                	int sum = 0;
                    //3x3 크기의 정사각형 훑어보기
                    for (int a = 0; a < 3; a++){
                    	for (int b = 0; b < 3; b++){
                        	sum += arr[i + a][j + b];
                        }
                    }
                    if (sum != 45){
                        res = 0;
                    }
                }
            }
            if (res == 0)
                ans.append("0\n");
            else
                ans.append("1\n");
        }
        System.out.println(ans);
	}
}