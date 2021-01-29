import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class January_29_17479 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(line.nextToken());
        int B = Integer.parseInt(line.nextToken());
        int C = Integer.parseInt(line.nextToken());

        HashSet<String> normal = new HashSet<>();
        HashSet<String> abnormal = new HashSet<>();
        HashSet<String> special = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<A;i++) {
            line = new StringTokenizer(br.readLine(), " ");
            String menu = line.nextToken();
            int price = Integer.parseInt(line.nextToken());

            normal.add(menu);
            map.put(menu, price);
        }

        for(int i=0;i<B;i++) {
            line = new StringTokenizer(br.readLine(), " ");
            String menu = line.nextToken();
            int price = Integer.parseInt(line.nextToken());

            abnormal.add(menu);
            map.put(menu, price);
        }

        for(int i=0;i<C;i++) {
            line = new StringTokenizer(br.readLine(), " ");
            String menu = line.nextToken();

            special.add(menu);
        }

        int N = Integer.parseInt(br.readLine());
        String order[] = new String[N];
        for(int i=0;i<N;i++) {
            order[i] = br.readLine();
        }

        boolean result = true;
        long sum = 0;
        for(int i=0;i<N;i++) {
            if(normal.contains(order[i])) {
                sum += map.get(order[i]);
            }
        }
        for(int i=0;i<N;i++) {
            if(abnormal.contains(order[i])) {
                if(sum < 20000)
                    result = false;
                sum += map.get(order[i]);
            }
        }
        boolean spe = false;
        for(int i=0;i<N;i++) {
            if(special.contains(order[i])) {
                if(sum < 50000 || spe)
                    result = false;
                spe = true;
            }
        }
        System.out.println(result ? "Okay" : "No");
    }
}