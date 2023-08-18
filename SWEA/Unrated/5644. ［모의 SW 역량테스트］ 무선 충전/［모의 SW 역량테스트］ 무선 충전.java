import java.io.*;
import java.util.*;


public class Solution {
    public static class Charger{
        int x;
        int y;
        int c;
        int p;
        public Charger(int x, int y, int c, int p){
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }


    }
    public static int[] dx = {0, -1, 0, 1, 0};
    public static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case=1;test_case <= T;test_case++){
            String[] data = br.readLine().split(" ");
            int m = Integer.parseInt(data[0]);
            int a = Integer.parseInt(data[1]);

            int[] usera = new int[m];
            int[] userb = new int[m];
            String[] data2 = br.readLine().split(" ");
            String[] data3 = br.readLine().split(" ");
            for(int i=0;i<m;i++){
                usera[i] = Integer.parseInt(data2[i]);
                userb[i] = Integer.parseInt(data3[i]);
            }



            ArrayList<Charger> list = new ArrayList<>();
            int x1 = 1;
            int y1 = 1;
            int x2 = 10;
            int y2 = 10;
            int ans = 0;

            for(int i=0;i<a;i++){
                String[] input = br.readLine().split(" ");
                int y = Integer.parseInt(input[0]);
                int x = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);
                int p = Integer.parseInt(input[3]);

                list.add(new Charger(x, y, c, p));
            }

            for(int i=-1;i<m;i++){
                if(i != -1) {
                    x1 += dx[usera[i]];
                    y1 += dy[usera[i]];
                    x2 += dx[userb[i]];
                    y2 += dy[userb[i]];
                }
                int[][] use = new int[2][a];
                for(int j=0;j<a;j++){
                    Charger cr = list.get(j);
                    if((Math.abs(cr.x-x1)+ Math.abs(cr.y-y1)) <= cr.c){
                        use[0][j] += 1;
                    }

                    if((Math.abs(cr.x-x2)+ Math.abs(cr.y-y2)) <= cr.c){
                        use[1][j] += 1;
                    }
                }
                int sum = 0;
                for(int p=0;p<a;p++){
                    for(int q=0;q<a;q++){
                        int tmp = 0;
                        if(use[0][p] == 1){
                            if(use[1][q] == 1){
                                if(p == q){
                                    tmp = list.get(p).p;
                                } else {
                                    tmp = (list.get(p).p + list.get(q).p);
                                }
                            } else {
                                tmp = list.get(p).p;
                            }
                        } else {
                            if(use[1][q] == 1){
                                tmp = list.get(q).p;
                            }
                        }

                        sum = Math.max(tmp, sum);
                    }


                }
                ans += sum;
            }
            sb.append("#"+test_case+" "+ans+"\n");
        }
        System.out.println(sb.toString());
    }
}