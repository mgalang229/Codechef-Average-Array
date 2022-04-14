import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = fs.nextInt(), x = fs.nextInt();
			int[] a = new int[n];
			//for odd, the x should be the middle (always correct)
			if(n % 2 == 1) {
				a[n/2] = x;
				int low = x;
				for(int i = n / 2 - 1; i >= 0; i--) {
					low--;
					a[i] = low;
				}
				int high = x;
				for(int i = n / 2 + 1; i < n; i++) {
					high++;
					a[i] = high;
				}
			}
			//for even, x should be missing in the center
			//for example, let N = 4, X = 7
			//{5, 6, 8, 9} = 28
			//28 / 4 = 7 (exact mean)
			else {
				int start = x - 1;
				for(int i = n / 2 - 1; i >= 0; i--) {
					a[i] = start;
					start--;
				}
				start = x + 1;
				for(int i = n / 2; i < n; i++) {
					a[i] = start;
					start++;
				}
			}
			for(int i = 0; i < n; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
