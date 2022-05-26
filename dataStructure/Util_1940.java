package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Util_1940 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
		{
			num[i] = Integer.parseInt(st.nextToken());	
		}
		Arrays.sort(num);
		int start = 0;
		int end = n - 1;
		int sum;
		int count = 0;
		while(start < end)
		{
			sum = num[start] + num[end];
			if (sum == m) {
				start++;
				end--;
				count++;
			} else if (sum > m) {
				end--;
			} else {
				start++;
			}
		}
		System.out.println(count);
	}
}
