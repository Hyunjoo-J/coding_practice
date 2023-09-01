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
        //ax + by = c꼴 생각 실제는 ax + by >= c를 찾아야 함 a = P, b = Q
        int mP = D / P + 1;
        int ans = P * mP;
        for(int i = mP - 1; i >= 0; --i){
            int div = (D - (P * i)) / Q; // c - ax 진행 후 남은 부분에서 Q로 나눠지는 몫을 찾음
            int mod = (D - (P * i)) % Q;
            if(mod == 0){//ax + by = c 성립
                System.out.println(D);
                return;
            }
            int tmp = P * i + Q * (div + 1); //Q * div < D - P * i, 그러나 Q * div >= D - P * i를 찾아야 하기에 div + 1을 곱함
            if(ans == tmp) //우연히 i, div + 1은 다르지만 계산한 결과가 같은 것이 나올 수 있음
                break;
            ans = Math.min(ans, tmp);
        }
        System.out.println(ans);
    }
}
