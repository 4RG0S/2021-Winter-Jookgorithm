import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class March_13_20057 {

  static int dx[] = {-1, 0, 1, 0};
  static int dy[] = {0, 1, 0, -1};
  static int map[][];

  static void moveSand(int x, int y, int direction) {
    int onePer = (int)Math.floor((double)map[y][x] / 100);
    int twoPer = (int)Math.floor((double)map[y][x] / 100 * 2);
    int fivePer = (int)Math.floor((double)map[y][x] / 100 * 5);
    int sevenPer = (int)Math.floor((double)map[y][x] / 100 * 7);
    int tenPer = (int)Math.floor((double)map[y][x] / 100 * 10);
    int tx, ty;

    int sumOfRest = map[y][x] - ((onePer + twoPer + sevenPer + tenPer) * 2) - fivePer;

    tx = x + dx[(direction + 2) % 4] + dx[(direction + 1) % 4];
    ty = y + dy[(direction + 2) % 4] + dy[(direction + 1) % 4];
    map[ty][tx] += onePer;
    tx = x + dx[(direction + 2) % 4] + dx[(direction + 3) % 4];
    ty = y + dy[(direction + 2) % 4] + dy[(direction + 3) % 4];
    map[ty][tx] += onePer;

    tx = x + dx[(direction + 1) % 4];
    ty = y + dy[(direction + 1) % 4];
    map[ty][tx] += sevenPer;
    tx = x + dx[(direction + 3) % 4];
    ty = y + dy[(direction + 3) % 4];
    map[ty][tx] += sevenPer;
    tx = x + (dx[(direction + 1) % 4] * 2);
    ty = y + (dy[(direction + 1) % 4] * 2);
    map[ty][tx] += twoPer;
    tx = x + (dx[(direction + 3) % 4] * 2);
    ty = y + (dy[(direction + 3) % 4] * 2);
    map[ty][tx] += twoPer;

    tx = x + dx[(direction) % 4] + dx[(direction + 1) % 4];
    ty = y + dy[(direction) % 4] + dy[(direction + 1) % 4];
    map[ty][tx] += tenPer;
    tx = x + dx[(direction) % 4] + dx[(direction + 3) % 4];
    ty = y + dy[(direction) % 4] + dy[(direction + 3) % 4];
    map[ty][tx] += tenPer;

    tx = x + dx[(direction) % 4] * 2;
    ty = y + dy[(direction) % 4] * 2;
    map[ty][tx] += fivePer;

    tx = x + dx[(direction) % 4];
    ty = y + dy[(direction) % 4];
    map[ty][tx] += sumOfRest;

    map[y][x] = 0;
  }
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    map = new int[N+4][N+4];
    for(int i=0;i<N;i++) {
      StringTokenizer line = new StringTokenizer(br.readLine());
      for (int j=0;j<N;j++) {
        map[i+2][j+2] = Integer.parseInt(line.nextToken());
      }
    }
    int x = 2 + (N / 2);
    int y = 2 + (N / 2);
    int directionChangeCount = 1;
    int fixedDirectionChangeCount = directionChangeCount;
    int tp = 0;
    int direction = 0;
    while (true) {
      x += dx[direction];
      y += dy[direction];
      moveSand(x, y, direction);
      directionChangeCount--;
      if (directionChangeCount == 0) {
        direction = (direction + 1) % 4;
        tp++;
        if (tp == 2) {
          fixedDirectionChangeCount++;
          tp = 0;
        }
        directionChangeCount = fixedDirectionChangeCount;
      }

      if (x == 2 && y == 2)
        break;
    }
    int sum = 0;
    for(int i=0;i<N+4;i++) {
      for(int j=0;j<N+4;j++) {
        sum += map[i][j];
      }
    }

    for(int i=2;i<N+2;i++) {
      for(int j=2;j<N+2;j++) {
        sum -= map[i][j];
      }
    }
    System.out.println(sum);
  }
}
