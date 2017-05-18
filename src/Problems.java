import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Problems {

	public void p1() {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 5 == 0 | i % 3 == 0)
				sum += i;
		}
		System.out.println(sum);
	}

	public void p2() {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(1);
		ans.add(2);
		int sum = 0;
		while (ans.get(ans.size() - 1) < 4000000) {
			if (ans.get(ans.size() - 1) % 2 == 0)
				sum += ans.get(ans.size() - 1);
			ans.add((ans.get(ans.size() - 1) + ans.get(ans.size() - 2)));
		}
		System.out.println(sum);
	}

	public void p3(long num) {
		TreeSet<Long> ans = new TreeSet<Long>();
		if (num % 2 == 0) {
			ans.add((long) 2);
		}
		for (int i = 3; i < 10000; i += 2) {
			if (num % i == 0) {
				ans.add((long) i);
			}
		}
		System.out.println(ans.last());
	}

	public boolean isPal(int i, int k) {
		int prod = i * k;
		char[] temp = String.valueOf(prod).toCharArray();
		ArrayList<Character> templist = new ArrayList<Character>();
		for (char c : temp)
			templist.add(c);
		if (templist.size() % 2 != 0)
			templist.remove((templist.size() - 1) / 2);
		for (int j = 0; j < (templist.size() / 2); j++)
			if (templist.get(j) != templist.get(templist.size() - 1 - j))
				return false;
		return true;
	}

	public void p4() {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 999; i > 900; i--) {
			for (int k = 999; k > 900; k--) {
				if (isPal(i, k)) {
					ans.add(k * i);
					break;
				}
			}
		}
		System.out.println(Collections.max(ans));
	}

	public boolean isDivis(int k) {
		for (int i = 3; i <= 20; i++)
			if (k % i != 0)
				return false;
		return true;
	}

	public void p5() {
		int ans = 2520;
		while (true) {
			if (isDivis(ans))
				break;
			ans += 2;
		}
		System.out.println(ans);
	}

	public void p6() {
		int sum = 0;
		int square = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i * i;
			square += i;
		}
		square *= square;
		System.out.println(square - sum);
	}

	public boolean isPrime(int k) {
		if (k == 1)
			return false;
		if (k == 2)
			return true;
		if (k % 2 == 0)
			return false;
		for (int i = 3; i * i <= k; i += 2) {
			if (k % i == 0)
				return false;
		}
		return true;
	}

	public boolean isPrime(long k) {
		if (k == 1)
			return false;
		if (k == 2)
			return true;
		if (k % 2 == 0)
			return false;
		for (int i = 3; i * i <= k; i += 2) {
			if (k % i == 0)
				return false;
		}
		return true;
	}

	public void p7() {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int i = 0;
		while (ans.size() <= 10000) {
			if (isPrime(i))
				ans.add(i);
			i++;
		}
		System.out.println(ans.get(10000));
	}

	public void p8() {
		ArrayList<Long> ans = new ArrayList<Long>();
		long temp = 0;
		long max = 0;
		try {
			Scanner scan = new Scanner(new File("p8.txt"));
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (int i = 0; i < line.length(); i++)
					ans.add((long) Integer.parseInt(Character.toString(line.charAt(i))));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < ans.size() - 12; i++) {
			temp = ans.get(i) * ans.get(i + 1) * ans.get(i + 2) * ans.get(i + 3) * ans.get(i + 4) * ans.get(i + 5)
					* ans.get(i + 6) * ans.get(i + 7) * ans.get(i + 8) * ans.get(i + 9) * ans.get(i + 10)
					* ans.get(i + 11) * ans.get(i + 12);
			if (temp >= max)
				max = temp;
		}
		System.out.println(max);
	}

	public void p9() {
		for (int i = 1000; i > 0; i--) {
			for (int k = 1000 - i; k > 0; k--) {
				int j = 1000 - i - k;
				if (i * i + k * k - j * j == 0) {
					System.out.println(i * j * k);
					return;
				}
			}
		}
	}

	public void p10() {
		long sum = 0;
		for (int i = 1; i < 2000000; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	public void p11() {
		ArrayList<Long> ans = new ArrayList<Long>();
		long max = 0;
		try {
			Scanner scan = new Scanner(new File("p11.txt"));
			while (scan.hasNextLong())
				ans.add(scan.nextLong());
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < ans.size(); i++) {
			long down = 0;
			long right = 0;
			long diaBR = 0;
			long diaTR = 0;
			if (i + 60 <= 399)
				down = ans.get(i) * ans.get(i + 20) * ans.get(i + 40) * ans.get(i + 60);
			if ((i + 4) % 20 >= i % 20)
				right = ans.get(i) * ans.get(i + 1) * ans.get(i + 2) * ans.get(i + 3);
			if (i + 63 <= 399 & (i + 4) % 20 >= i % 20)
				diaBR = ans.get(i) * ans.get(i + 21) * ans.get(i + 42) * ans.get(i + 63);
			if (i <= 396 & (i + 4) % 20 >= i % 20 & i >= 76)
				diaTR = ans.get(i) * ans.get(i - 19) * ans.get(i - 38) * ans.get(i - 57);
			if (down > max)
				max = down;
			if (right > max)
				max = right;
			if (diaBR > max)
				max = diaBR;
			if (diaTR > max)
				max = diaTR;
		}
		System.out.println(max);
	}

	public TreeSet<Long> getFactors(long k) {
		TreeSet<Long> ans = new TreeSet<Long>();
		for (long i = (int) k / 2 + 1; i > 0; i--)
			if (k % i == 0)
				ans.add(i);
		ans.add(k);
		return ans;
	}

	public long getDivNum(long k) {
		long ans = 0;
		int i = 2;
		for (i = 2; i * i <= k; i++) {
			if (k % i == 0) {
				ans++;
			}
		}
		i--;
		if (i * i == k)
			return 2 * ans + 1;
		return 2 * ans + 2;
	}

	public void p12() {
		long Tri = 0;
		long i = 1;
		while (true) {
			Tri += i;
			if (getDivNum(Tri) > 500)
				break;
			i++;
		}
		System.out.println(Tri);
	}

	public int intCarry(int k) {
		String temp = Integer.toString(k);
		if (temp.length() == 1)
			return 0;
		return Integer.valueOf(temp.substring(0, temp.length() - 1));
	}

	public String strLast(int k) {
		String temp = Integer.toString(k);
		return Character.toString(temp.charAt(temp.length() - 1));
	}

	public void p13() {
		StringBuilder sb = new StringBuilder();
		String[] nums = new String[100];
		int tempsum = 0;
		try {
			Scanner scan = new Scanner(new File("p13.txt"));
			for (int i = 0; i < 100; i++) {
				nums[i] = scan.nextLine();
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int charnum = 49; charnum >= 0; charnum--) {
			tempsum = intCarry(tempsum);
			for (int strline = 0; strline < 100; strline++) {
				tempsum += Integer.valueOf(Character.toString(nums[strline].charAt(charnum)));
			}
			if (charnum == 0) {
				;
				sb.append(new StringBuilder(Integer.toString(tempsum)).reverse().toString());
				break;
			}
			sb.append(strLast(tempsum));

		}
		System.out.println(sb.reverse().toString().substring(0, 10));
	}

	public long getCollatzLength(long k) {
		long count = 1;
		while (k != 1) {
			if (k % 2 == 0) {
				k /= 2;
			} else {
				k = 3 * k + 1;
			}
			count++;
		}
		return count;
	}

	public void p14() {
		long length = 0;
		long maxnum = 0;
		for (long i = 1; i < 1000000; i++)
			if (getCollatzLength(i) > length) {
				length = getCollatzLength(i);
				maxnum = i;
			}
		System.out.print(maxnum);
	}

	public void p15(int n) {
		long[] ans = new long[n];
		Arrays.fill(ans, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j == 0)
					ans[j] = ans[j] + ans[n-1];
				else ans[j] = ans[j] + ans[j - 1];
			}
			if (i == 0)
				ans[i] = 2 * ans[n-1];
			else ans[i] = 2 * ans[i - 1];
		}
		System.out.println(ans[n - 1]);
	}

	public static void main(String[] args) {
		Problems prob = new Problems();
		prob.p15(20);
	}
}