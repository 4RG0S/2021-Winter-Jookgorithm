import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class March_14_15688 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());

    int count[] = new int[2000001];
    for(int i=0;i<N;i++) {
      count[Integer.parseInt(br.readLine()) + 1000000]++;
    }
    for(int i=0;i<count.length; i++) {
      for(int j=0;j<count[i];j++) {
        bw.append(Integer.toString(i - 1000000));
        bw.append('\n');
      }
    }
    bw.flush();
    bw.close();
  }
}
