package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> {

			if (Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			} else {
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(br.readLine());
			if (x != 0) {
                pq.add(x);
			} else{
                if (pq.isEmpty())
                    sb.append("0\n");
                else
                    sb.append(pq.poll() + "\n");
            } 	
		}
		System.out.println(sb);
	}

}
