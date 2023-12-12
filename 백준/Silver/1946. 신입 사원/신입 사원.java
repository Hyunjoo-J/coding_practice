import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            int[][] score = new int[N][2];

            for(int i = 0; i < N; ++i){
                st = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score, 0, N, (o1, o2) -> {
                if(o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            });
            int ans = N;
            int min = score[0][1];
            for(int i = 1; i < N; ++i){
                if(score[i][1] > min){
                    --ans;
                }
                min = Math.min(min, score[i][1]);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}