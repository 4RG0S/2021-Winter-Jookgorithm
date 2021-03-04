import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class February_17_1725 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int a[] = new int[N];
    Stack<Integer> s = new Stack<>();

    for(int i=0;i<N;i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int ans = 0;
    for (int i=0; i<N; i++) {
        while(!s.empty() && a[s.peek()] > a[i]) {
            int height = a[s.peek()];
            s.pop();
            int width = i;
            if (!s.empty()) {
                width = (i - s.peek() - 1);
            }
            if (ans < width*height) {
                ans = width*height;
            }
        }
        s.push(i);
    }
    while(!s.empty()) {
        int height = a[s.peek()];
        s.pop();
        int width = N;
        if (!s.empty()) {
            width = N-s.peek()-1;
        }
        if (ans < width*height) {
            ans = width*height;
        }
    }
    System.out.println(ans);
  }
}
