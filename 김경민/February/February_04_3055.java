import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class February_04_3055 {

  static int dx[] = {1, -1, 0, 0};
  static int dy[] = {0, 0, 1, -1};

  static class dot{
    int x, y, val;
    public dot(int x, int y) {
      this.x = x;
      this.y = y;
    }
    public dot(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }

  static int timeToFlood[][];
  static boolean visit[][];
  static int result = Integer.MAX_VALUE;

  static void find(dot hedgehogStart) {
    Queue<dot> q = new LinkedList<>();
    q.add(hedgehogStart);

    while(!q.isEmpty()) {
      dot temp = q.poll();
      if(timeToFlood[temp.y][temp.x] == Integer.MAX_VALUE) {
        result = temp.val;
      }
      for(int i=0;i<4;i++) {
        int x = temp.x + dx[i];
        int y = temp.y + dy[i];
        if(0 <= x && x < visit[0].length && 0 <= y && y < visit.length && !visit[y][x] && (timeToFlood[y][x] > temp.val + 1 || timeToFlood[y][x] == 0)) {
          visit[y][x] = true;
          q.add(new dot(x, y, temp.val + 1));
        }
      }
    }
  }

  static void flooding(List<dot> floodStart) {
    Queue<dot> q = new LinkedList<>();
    for(int i=0;i<floodStart.size();i++) {
      q.add(floodStart.get(i));
    }
    while(!q.isEmpty()) {
      dot temp = q.poll();
      for(int i=0;i<4;i++) {
        int x = temp.x + dx[i];
        int y = temp.y + dy[i];
        if(0 <= x && x < visit[0].length && 0 <= y && y < visit.length && !visit[y][x]) {
          visit[y][x] = true;
          timeToFlood[y][x] = temp.val + 1;
          q.add(new dot(x, y, temp.val + 1));
        }
      }
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer line = new StringTokenizer(br.readLine(), " ");
    int R = Integer.parseInt(line.nextToken());
    int C = Integer.parseInt(line.nextToken());
    List<dot> floodStart = new ArrayList<>();
    dot hedgehogStart = null;
    timeToFlood = new int[R][C];
    visit = new boolean[R][C];

    for(int i=0;i<R;i++) {
      String input = br.readLine();
      for(int j=0;j<C;j++) {
        if(input.charAt(j) == 'D') {
          visit[i][j] = true;
          timeToFlood[i][j] = Integer.MAX_VALUE;
        } else if(input.charAt(j) == 'S') {
          hedgehogStart = new dot(j, i, 0);
        } else if(input.charAt(j) == '*') {
          floodStart.add(new dot(j, i, 0));
          timeToFlood[i][j] = -1;
          visit[i][j] = true;
        } else if(input.charAt(j) == 'X') {
          timeToFlood[i][j] = -1;
          visit[i][j] = true;
        }
      }
    }
    if(floodStart.size() > 0)
      flooding(floodStart);
    visit = new boolean[R][C];
    for(int i=0;i<R;i++) {
      for(int j=0;j<C;j++) {
        if(timeToFlood[i][j] == -1)
          visit[i][j] = true;
      }
    }
    find(hedgehogStart);
    System.out.println((result == Integer.MAX_VALUE) ? "KAKTUS" : result);
  }
}
