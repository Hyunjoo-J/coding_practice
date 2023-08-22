import java.util.*;
import java.io.*;

public class Main {
    public static class Shark {
        int speed;
        int dir;
        int size;
        int move;

        public Shark(int speed, int dir, int size, int move) {
            this.speed = speed;
            this.dir = dir;
            this.size = size;
            this.move = move;
        }
    }

    static int R, C, M, ans;
    static int rsize, csize;
    static Shark[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rsize = (R - 1) * 2;
        csize = (C - 1) * 2;
        map = new Shark[R][C];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(s, d, z, 0);
        }
        for (int i = 0; i < C; ++i) {
            fishing(i);
            for (int j = 0; j < R; ++j) {
                for(int k = 0; k < C; ++k) {
                    if (map[j][k] != null && map[j][k].move == i)
                        move(j, k);
                }
            }
        }
        System.out.println(ans);
    }

    private static void fishing(int now) {
        for (int i = 0; i < R; ++i) {
            if (map[i][now] != null) {
                ans += map[i][now].size;
                map[i][now] = null;
                break;
            }
        }
    }

    private static void move(int x, int y) {
        Shark a = map[x][y];
        map[x][y] = null;
        int mod;
        int nx = x, ny = y;
        ++a.move;
        if(a.dir == 1){
            mod = (R - 1 - x + a.speed) % rsize;
            if (mod > R - 1) {
                nx = mod - R + 1;
                a.dir = 2;
            }else{
                nx = R - 1 - mod;
            }
        }else if(a.dir == 2){
            mod = (x + a.speed) % rsize;
            if(mod > R - 1) {
                nx = rsize - mod;
                a.dir = 1;
            }else{
                nx = mod;
            }
        }else if(a.dir == 3){
            mod = (y + a.speed) % csize;
            if(mod > C - 1) {
                ny = csize - mod;
                a.dir = 4;
            }else{
                ny = mod;
            }
        }else{
            mod = (C - 1 - y + a.speed) % csize;
            if (mod > C - 1) {
                ny = mod - C + 1;
                a.dir = 3;
            }else{
                ny = C - 1 - mod;
            }
        }
        if(map[nx][ny] == null) {
            map[nx][ny] = a;
            return;
        }
        Shark b = map[nx][ny];
        if(b.move < a.move) {
            move(nx, ny);
            if(map[nx][ny] == null) {
                map[nx][ny] = a;
            }else {
                b = map[nx][ny];
                if(a.size > b.size) {
                    map[nx][ny] = a;
                }
            }
        }else if(a.size > b.size) {
            map[nx][ny] = a;
        }
    }
}