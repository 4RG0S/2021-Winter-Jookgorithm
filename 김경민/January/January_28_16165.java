package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class January_28_16165 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		HashMap<String, String> member = new HashMap<>();
		HashMap<String, String> group = new HashMap<>();

		int N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());

		for (int i = 0; i < N; i++) {
			String groupName = br.readLine();
			int memberCount = Integer.parseInt(br.readLine());

			for (int j = 0; j < memberCount; j++) {
				String memberName = br.readLine();
				group.put(memberName, groupName);
				if (member.get(groupName) == null)
					member.put(groupName, memberName);
				else
					member.put(groupName, member.get(groupName) + "," + memberName);
			}
		}

		for (int i = 0; i < M; i++) {
			String query = br.readLine();
			int type = Integer.parseInt(br.readLine());
			if (type == 0) {
				StringTokenizer tp = new StringTokenizer(member.get(query), ",");
				ArrayList<String> array = new ArrayList<>();
				while (tp.hasMoreTokens()) {
					array.add(tp.nextToken());
				}
				Collections.sort(array);
				for (int j = 0; j < array.size(); j++)
					System.out.println(array.get(j));
			} else if (type == 1) {
				System.out.println(group.get(query));
			}
		}
	}

}
