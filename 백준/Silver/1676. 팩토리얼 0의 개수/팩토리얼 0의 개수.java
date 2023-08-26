import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt=0;

        for(int i=1; i <= N; i++){
            int num = i;
            while(num % 5==0){
                cnt++;
                num /= 5;
            }
        }
        System.out.println(cnt);
    }
}