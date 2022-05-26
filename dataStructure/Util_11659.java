package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Util_11659 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, start, end;
    static long[] S;
    public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
	
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		S = new long[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			sb.append(S[end] - S[start - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
