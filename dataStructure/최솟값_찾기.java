package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최솟값_찾기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> deque = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.getLast().value > now) {
				deque.removeLast();
			}
			deque.addLast(new Node(now, i));
			if (deque.getFirst().index <= i - L) {
				deque.removeFirst();
			}
			sb.append(String.valueOf(deque.getFirst().value));
			sb.append(" ");
		}
		System.out.println(sb);
	}
}

class Node{
	public int value;
	public int index;
	Node(int value, int index){
		this.value = value;
		this.index = index;
	}
}
