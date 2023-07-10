public class Main{
    static int[] selfnum = new int[10001];
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++){
            if (selfnum[i] == 0){
                sb.append(i + "\n");
                self(i);
            }
        }
        System.out.println(sb);
    }
    static int self(int n){
        int sum = n;
        while (n > 0){
            sum += n%10;
            n /= 10;
        }
        if (sum < 10001){
            selfnum[sum] = 1;
            self(sum);
        }
        return sum;
    }
}