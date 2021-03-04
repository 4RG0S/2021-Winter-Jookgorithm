import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class February_13_16562 {

  static class inq implements Comparable<inq>{
    int index, cost;
    public inq(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
	@Override
	public int compareTo(inq comp) {
		return this.cost - comp.cost;
	}

  }

  static List<List<Integer>> list = new ArrayList<>();
  static boolean used[];

  static void dfs(int here) {
    used[here] = true;
    for(int there:list.get(here)) {
      if(used[there])
        continue;
      dfs(there);
    }
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer line = new StringTokenizer(br.readLine(), " ");
    PriorityQueue<inq> q = new PriorityQueue<>();
    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());
    int k = Integer.parseInt(line.nextToken());
    line = new StringTokenizer(br.readLine(), " ");
    used = new boolean[N];

    for(int i=0;i<N;i++) {
      q.add(new inq(i, Integer.parseInt(line.nextToken())));
      list.add(new ArrayList<>());
    }

    for(int i=0;i<M;i++) {
      line = new StringTokenizer(br.readLine(), " ");
      int from = Integer.parseInt(line.nextToken()) - 1;
      int to = Integer.parseInt(line.nextToken()) - 1;

      list.get(from).add(to);
      list.get(to).add(from);
    }
    int result = 0;
    while(!q.isEmpty()) {
      inq temp = q.poll();
      //System.out.println(temp.cost);
      if(used[temp.index])
        continue;
      result += temp.cost;
      dfs(temp.index);
    }
    System.out.println((result > k) ? "Oh no" : result);
  }
}
