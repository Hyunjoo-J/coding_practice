import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> prime = new ArrayList<>();
        int ans = 0;
        prime.add(2);
        next : for(int i = 3; i <= N; i += 2){
            double end = Math.sqrt(i);
            for(int j = 3; j <= end; j += 2){
                if(i % j == 0)
                    continue next;
            }
            prime.add(i);
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        while(true){
            if(sum >= N){
                sum -= prime.get(start++);
            }else if(end == prime.size()){
                break;
            }else{
                sum += prime.get(end++);
            }
            if(sum == N)
                ++ans;
        }
        System.out.println(ans);
    }
}