import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class February_01_17264 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Boolean> win = new HashMap<>();
        StringTokenizer line = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(line.nextToken());
        int P = Integer.parseInt(line.nextToken());
        line = new StringTokenizer(br.readLine(), " ");
        int W = Integer.parseInt(line.nextToken());
        int L = Integer.parseInt(line.nextToken());
        int G = Integer.parseInt(line.nextToken());

        for(int i=0;i<P;i++) {
            line = new StringTokenizer(br.readLine(), " ");
            String player = line.nextToken();
            boolean status = (line.nextToken().equals("W")) ? true : false;

            win.put(player, status);
        }
        int score = 0;
        boolean result = false;
        for(int i=0;i<N;i++) {
            String player = br.readLine();
            if(win.containsKey(player) && win.get(player)) {
                score += W;
            } else {
                score = Integer.max(0, score - L);
            }
            if(score >= G)
                result = true;
        }
        System.out.println(result ? "I AM NOT IRONMAN!!" : "I AM IRONMAN!!");
    }
}
