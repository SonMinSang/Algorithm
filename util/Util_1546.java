package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Util_1546 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sum = 0.0;
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(st.nextToken());
			if (curr > max) 
				max = curr;
			sum += curr;
		}
		br.close();
		System.out.println((sum / max) * 100 / n);
	}
}
