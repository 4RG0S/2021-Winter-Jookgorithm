import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class February_12_12837 {
  static class RMQ {
    long sum[];
    public RMQ(int size) {
      sum = new long[size*4];
    }
    long query(int left, int right, int node, int nodeLeft, int nodeRight) {
      if (right < nodeLeft || nodeRight < left)
        return 0;
      if (left <= nodeLeft && nodeRight <= right)
        return sum[node];
      int nodeMiddle = (nodeLeft + nodeRight) / 2;
      return query(left, right, node*2, nodeLeft, nodeMiddle) + query(left, right, node*2+1, nodeMiddle+1, nodeRight);
    }
    long update(long value, int node, int left, int right, int index) {
      if (index < left || right < index)
        return sum[node];
      if (left == right)
        return sum[node] += value;
      int middle = (left + right) / 2;
      return sum[node] = update(value, node*2, left, middle, index) + update(value, node*2+1, middle+1, right, index);
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(line.nextToken());
    int Q = Integer.parseInt(line.nextToken());
    RMQ rmq = new RMQ(N);

    for(int i=0;i<Q;i++) {
      line = new StringTokenizer(br.readLine(), " ");
      int type = Integer.parseInt(line.nextToken());
      int p = Integer.parseInt(line.nextToken());
      int value = Integer.parseInt(line.nextToken());

      if (type == 1) {
        rmq.update(value, 1, 1, N, p);
      } else if(type == 2) {
        System.out.println(rmq.query(p, value, 1, 1, N));
      }
    }
  }
}
