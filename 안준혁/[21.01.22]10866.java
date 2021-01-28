import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String instruction;
		
		StringTokenizer st;
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			instruction = st.nextToken();		
			if(instruction.equals("push_front")) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
			}	
			else if(instruction.equals("push_back")) {
				deque.addLast(Integer.parseInt(st.nextToken()));
			}	
			else if(instruction.equals("pop_front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.removeFirst());
				}		
			}
			else if(instruction.equals("pop_back")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.removeLast());
				}		
			}
			else if(instruction.equals("size")) {
				System.out.println(deque.size());
			}	
			else if(instruction.equals("empty")) {
				if(deque.isEmpty()) {
					System.out.println(1);
				}else	{
					System.out.println(0);
				}
			}	
			else if(instruction.equals("front")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.peekFirst());
				}
			}	
			else if(instruction.equals("back")) {
				if(deque.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(deque.peekLast());
				}
			}
		}
	}
}

