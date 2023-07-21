import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        boolean[] Prime = new boolean[N + 1];
        for (int i = 2; i <= N; i++)
            Prime[i] = true;

        int cnt = 0;
        for (int i = 2; i <= N; i++){
            for(int j = 1;i * j <= N; j++){
                if (!Prime[i * j]) continue;
                Prime[i * j] = false;
                cnt++;
                if (cnt == K){
                    System.out.println(i * j);
                    break;
                }
            }
        }
    }
}