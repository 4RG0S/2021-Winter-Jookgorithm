import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class February_15_18436 {
  static class RMQ {
    static int countEven[];
    public RMQ(ArrayList<Integer> list) {
      countEven = new int[list.size() * 4];
      initEven(list, 1, 0, list.size() - 1);
    }
    int initEven(ArrayList<Integer> list, int node, int left, int right) {
      if (left == right) {
        if (list.get(left) % 2 == 0)
          return countEven[node] = 1;
        else
          return 0;
      }
      int middle = (left + right) / 2;
      return countEven[node] = initEven(list, node * 2, left, middle) + initEven(list, node * 2 + 1, middle + 1, right);
    }
    int update(int node, int value, int index, int left, int right) {
      if (index < left || right < index)
        return countEven[node];
      if (left == right) {
        if (value % 2 == 0)
          return countEven[node] = 1;
        return countEven[node] = 0;
      }
      int middle = (left + right) / 2;
      return countEven[node] = update(node * 2, value, index, left, middle) + update(node * 2 + 1, value, index, middle + 1, right);
    }
    int query(int left, int right, int node, int nodeLeft, int nodeRight) {
      if (right < nodeLeft || nodeRight < left)
        return 0;
      if (left <= nodeLeft && nodeRight <= right)
        return countEven[node];
      int nodeMiddle = (nodeLeft + nodeRight) / 2;
      return query(left, right, node * 2, nodeLeft, nodeMiddle) + query(left, right, node * 2 + 1, nodeMiddle + 1, nodeRight);
    }
    void printInfo() {
      for(int i=0;i<countEven.length;i++) {
        System.out.print(countEven[i] + " ");
      }
    }
  }

  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    StringTokenizer line = new StringTokenizer(br.readLine(), " ");

    for(int i=0;i<N;i++) {
      list.add(Integer.parseInt(line.nextToken()));
    }
    RMQ rmq = new RMQ(list);
    int M = Integer.parseInt(br.readLine());
    for(int i=0;i<M;i++) {
      line = new StringTokenizer(br.readLine(), " ");
      int type = Integer.parseInt(line.nextToken());
      int A = Integer.parseInt(line.nextToken());
      int B = Integer.parseInt(line.nextToken());
      if (type == 1) {
        rmq.update(1, B, A - 1, 0, N - 1);
      } else if (type == 2) {
        System.out.println(rmq.query(A - 1, B - 1, 1, 0, N - 1));
      } else if (type == 3) {
        System.out.println((B - A + 1) - rmq.query(A - 1, B - 1, 1, 0, N - 1));
      }
    }
  }
}
