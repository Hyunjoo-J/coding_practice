import java.util.*;
import java.io.*;
public class Main {
    static Point[] p;
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int dist(Point p1, Point p2){
        return (p1.x -  p2.x) * (p1.x -  p2.x) + (p1.y -  p2.y) * (p1.y -  p2.y);
    }

    static Comparator<Point> Xcomp = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            return o1.x - o2.x;
        }
    };

    static Comparator<Point> Ycomp = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if(o1.y == o2.y) {
                return o1.x - o2.x;
            }
            return o1.y - o2.y;
        }
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        p = new Point[N];

        StringTokenizer st;
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(p, Xcomp);

        TreeSet<Point> set = new TreeSet<Point>(Ycomp);

        int min = dist(p[0], p[1]);

        set.add(p[0]);
        set.add(p[1]);

        int lowIdx = 0;
        for(int i = 2; i < N; ++i){
            Point bench = p[i];

            while(lowIdx < i){
                Point target = p[lowIdx];
                int xDist = bench.x - target.x;

                //target과 bench가 현재 mim보다 거리가 더 멀다
                if(xDist * xDist > min){
                    set.remove(target);
                    ++lowIdx;
                } else{
                    break;
                }
            }

            //기준에 만족하는 원소들로 subTree를 얻고, 이를 bench와 거리 비교하여 min 값 갱신
            int sqrtMin = (int)Math.sqrt(min) + 1;
            TreeSet<Point> ySub = (TreeSet<Point>) set.subSet(new Point(-100000, bench.y - sqrtMin), new Point(100000, bench.y + sqrtMin));
            for(Point v : ySub){
                min = Math.min(min, dist(bench, v));
            }

            set.add(bench);
        }
        System.out.println(min);
    }
}