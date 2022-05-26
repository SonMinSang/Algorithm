package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Util_1253 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int start, end, find, sum, count = 0;
		for (int i = 0; i < n; i++) {
			find = num[i];
			start = 0;
			end = n - 1;
			while (start < end) {
				sum = num[start] + num[end];
				if (sum == find) {
					if (start != i && end != i) {
						count++;
						break;
					} else if (start == i) {
						start++;
					} else {
						end--;
					}
				} else if (sum > find) {
					end--;
				} else {
					start++;
				}
			}
		}
		System.out.println(count);
	}
}