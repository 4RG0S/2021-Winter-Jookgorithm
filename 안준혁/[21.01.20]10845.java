import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count;
		String instruction;
		
		StringTokenizer st;
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			instruction = st.nextToken();		
			if(instruction.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
			}	else if(instruction.equals("pop")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
				}		
			}	else if(instruction.equals("size")) {
				System.out.println(queue.size());
			}	else if(instruction.equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println(1);
				}else	{
					System.out.println(0);
				}
			}	else if(instruction.equals("front")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(queue.peek());
				}
			}	else if(instruction.equals("back")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}
				else {
					count = 0;
					for(Integer a : queue) {
						count++;
						if(count == queue.size()) {
							System.out.println(a);
						}
					}
				}
			}
		}
	}
}

