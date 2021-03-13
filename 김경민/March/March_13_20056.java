import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class March_13_20056 {

  static int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
  static int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};

  static class fireball {
    int m, s, d, move;
    public fireball(int m, int s, int d, int move) {
      this.m = m;
      this.s = s;
      this.d = d;
      this.move = move;
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());
    int K = Integer.parseInt(line.nextToken());
    HashSet<fireball> as[][] = new HashSet[N][N];
    for (int i=0;i<N;i++) {
      for (int j=0;j<N;j++) {
        as[i][j] = new HashSet<fireball>();
      }
    }

    for (int i=0;i<M;i++) {
      line = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(line.nextToken());
      int x = Integer.parseInt(line.nextToken());
      int m = Integer.parseInt(line.nextToken());
      int s = Integer.parseInt(line.nextToken());
      int d = Integer.parseInt(line.nextToken());
      as[y - 1][x - 1].add(new fireball(m, s, d, 0));
    }
    for(int move = 0;move<K;move++) {
      // Move
      for (int i=0;i<N;i++) {
        for(int j=0;j<N;j++) {
          for(Object target : as[i][j].toArray()) {
            fireball here = (fireball)target;
            if (here.move == move) {
              int moveX = N * 1000 + j + dx[here.d] * here.s;
              int moveY = N * 1000 + i + dy[here.d] * here.s;
              as[moveY % N][moveX % N].add(new fireball(here.m, here.s, here.d, move + 1));
              as[i][j].remove(here);
            }
          }
        }
      }
      // Check duplicate and divide
      for (int i=0;i<N;i++) {
        for(int j=0;j<N;j++) {
          if (as[i][j].size() > 1) {
            int asSize = as[i][j].size();
            int sumOfM = 0;
            int sumOfS = 0;
            boolean allOdd = true;
            boolean allEven = true;
            for (fireball target : as[i][j]) {
              sumOfM += target.m;
              sumOfS += target.s;
              allOdd = (target.d % 2 == 1) ? allOdd : false;
              allEven = (target.d % 2 == 0) ? allEven : false;
            }
            as[i][j] = new HashSet<fireball>();
            int direction = (allOdd || allEven) ? 0 : 1;
            if (sumOfM >= 5) {
              for (int z=0;z<4;z++) {
                as[i][j].add(new fireball(sumOfM / 5, sumOfS / asSize, direction, move + 1));
                direction += 2;
              }
            }

          }
        }
      }
    }
    int result = 0;
    for(int i=0;i<N;i++) {
      for(int j=0;j<N;j++) {
        for (fireball target : as[i][j]) {
          result += target.m;
        }
      }
    }
    System.out.println(result);
  }
}
