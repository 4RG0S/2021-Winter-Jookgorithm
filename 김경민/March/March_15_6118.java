import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class March_15_6118 {
  static class Hay {
    int here, distance;
    public Hay(int here, int distance) {
      this.here = here;
      this.distance = distance;
    }
  }
  static boolean visit[];
  static List<List<Integer>> list = new ArrayList<>();
  static List<List<Integer>> distance = new ArrayList<>();

  static void bfs(int here) {
    Queue<Hay> q = new LinkedList<>();
    int result = Integer.MIN_VALUE;
    visit[here] = true;

    q.add(new Hay(here, 0));
    while(!q.isEmpty()) {
      Hay temp = q.poll();
      result = (result < temp.distance) ? temp.distance : result;
      for(int there : list.get(temp.here)) {
        if (visit[there])
          continue;
        visit[there] = true;
        distance.get(temp.distance + 1).add(there);
        q.add(new Hay(there, temp.distance + 1));
      }
    }
    Object arr[] = distance.get(result).toArray();
    Arrays.sort(arr);
    System.out.println(arr[0] + " " + result + " " + arr.length);
    // System.out.println(result);
    // System.out.println(arr.length);
    // System.out.println(distance.get(result));
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());

    visit = new boolean[N+1];
    for(int i=0;i<N+1;i++) {
      list.add(new ArrayList<>());
      distance.add(new ArrayList<>());
    }
    for(int i=0;i<M;i++) {
      line = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(line.nextToken());
      int to = Integer.parseInt(line.nextToken());
      list.get(from).add(to);
      list.get(to).add(from);
    }
    bfs(1);
  }
}
