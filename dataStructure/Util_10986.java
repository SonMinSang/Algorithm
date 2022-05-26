package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Util_10986 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] sum = new long[n + 1];
		long[] remainder = new long[m];
		long result = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
			remainder[(int)(sum[i] % m)]++;
		}
		while (m-- > 0)
		{
			result += ((remainder[m] * (remainder[m] - 1)) / 2); 
		}
		System.out.println(result + remainder[0]);
	}
}
