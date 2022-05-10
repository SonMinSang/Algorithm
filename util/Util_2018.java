package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Util_2018 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int start = 1;
		int end = 1;
		int count = 1;
		int sum = 1;
		while (start + end <= n) {
			if (sum == n) {
				count++;
				end++;
				sum += end;
			} else if (sum > n) {
				sum -= start;
				start++;
			} else {
				end++;
				sum += end;
			}
		}
		System.out.println(count);
	}
}
