import java.util.*;
import java.io.*;
public class Main {
    static int D, P, Q, L, R, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        if(D % P == 0 || D % Q == 0) {
            System.out.println(D);
            return;
        }
        if (P < Q) { //P > Q를 만든다
            int tmp = P;
            P = Q;
            Q = tmp;
        }
        //ax + by = c꼴 생각
        int mP = D / P + 1;
        int ans = P * mP;
        for(int i = mP - 1; i >= 0; --i){
            int div = (D - (P * i)) / Q;
            int mod = (D - (P * i)) % Q;
            if(mod == 0){
                System.out.println(D);
                return;
            }
            int tmp = P * i + Q * (div + 1);
            if(ans == tmp)
                break;
            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);
    }
}