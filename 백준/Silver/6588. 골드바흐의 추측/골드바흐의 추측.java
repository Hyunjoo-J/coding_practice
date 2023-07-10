import java.io.*;
import java.util.*;

public class Main{
    static int[] prime = new int[1000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < 1000001; i++){
            prime[i] = isPrime(i);
        }
        while(n != 0){
            int flag = 0;
            for (int i = 2; i <= n/2; i++){
                if (prime[i] == 1 && prime[n - i] == 1){
                    flag = 1;
                    System.out.println(n + " = " + i + " + " + (n-i));
                    break;
                }
            }
            if (flag == 0)
                System.out.println("Goldbach's conjecture is wrong.");
            n = Integer.parseInt(br.readLine());
        }
    }
    public static int isPrime(int n){
        for (int i = 2; i <= (int)Math.sqrt(n); i++){
            if (n % i == 0)
                return 0;
        }
        return 1;
    }
}