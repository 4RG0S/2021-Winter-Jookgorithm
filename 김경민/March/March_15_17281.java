import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class March_15_17281 {
  static int hitStatus[][];
  static int maxScore = Integer.MIN_VALUE;

  static void calculateScore(Object arr[]) {
    int result = 0;
    int index = 0;
    for(int inning=0;inning<hitStatus.length; inning++) {
      int out = 0;
      boolean first = false, second = false, third = false;
      while(out != 3) {
        int score = 0;
        if (hitStatus[inning][(int)arr[index]] == 0)
          out++;
        if (hitStatus[inning][(int)arr[index]] == 1) {
          if (third) {
            third = false;
            score += 1;
          }
          if (second) {
            third = true;
            second = false;
          }
          if (first) {
            second = true;
            first = false;
          }
          first = true;
        }
        if (hitStatus[inning][(int)arr[index]] == 2) {
          if (third) {
            third = false;
            score += 1;
          }
          if (second) {
            second = false;
            score += 1;
          }
          if (first) {
            third = true;
            first = false;
          }
          second = true;
        }
        if (hitStatus[inning][(int)arr[index]] == 3) {
          if (third) {
            third = false;
            score += 1;
          }
          if (second) {
            second = false;
            score += 1;
          }
          if (first) {
            first = false;
            score += 1;
          }
          third = true;
        }
        if (hitStatus[inning][(int)arr[index]] == 4) {
          if (third) {
            third = false;
            score += 1;
          }
          if (second) {
            second = false;
            score += 1;
          }
          if (first) {
            first = false;
            score += 1;
          }
          score += 1;
        }
        result += score;
        index = (index + 1) % 9;
      }
    }
    maxScore = (maxScore < result) ? result : maxScore;
  }

  static void makeOrder(Stack<Integer> stack) {
    if (stack.size() == 9) {
      calculateScore(stack.toArray());
    }
    if (stack.size() == 3) {
      stack.push(1);
      makeOrder(stack);
      stack.pop();
    }
    for(int i=2;i<=9;i++) {
      if (!stack.contains(i)) {
        stack.push(i);
        makeOrder(stack);
        stack.pop();
      }
    }
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    hitStatus = new int[N][10];

    for(int i=0;i<N;i++) {
      StringTokenizer line = new StringTokenizer(br.readLine());
      for(int j=1;j<=9;j++) {
        hitStatus[i][j] = Integer.parseInt(line.nextToken());
      }
    }
    makeOrder(new Stack<Integer>());
    System.out.println(maxScore);
  }
}
