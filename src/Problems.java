import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
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
					ans[j] = ans[j] + ans[n - 1];
				else
					ans[j] = ans[j] + ans[j - 1];
			}
			if (i == 0)
				ans[i] = 2 * ans[n - 1];
			else
				ans[i] = 2 * ans[i - 1];
		}
		System.out.println(ans[n - 1]);
	}

	public void p16() {
		int ans = 0;
		BigDecimal num = new BigDecimal(Math.pow(2, 1000));
		for (char c : num.toString().toCharArray())
			ans += Integer.valueOf(Character.toString(c));
		System.out.print(ans);
	}

	public void p17() {
		long ans = 0;
		int[] single = { 3, 3, 5, 4, 4, 3, 5, 5, 4 };
		int[] weird = { 3, 6, 6, 8, 8, 7, 7, 9, 8, 8 };
		int[] tens = { 6, 6, 5, 5, 5, 7, 6, 6 };
		for (int i = 0; i < single.length; i++) {
			ans += 190 * single[i];
		}
		for (int i = 0; i < weird.length; i++) {
			ans += 10 * weird[i];
		}
		for (int i = 0; i < tens.length; i++) {
			ans += 100 * tens[i];
		}
		ans += 900 * 7;
		ans += 99 * 9 * 3;
		ans += 3 + 8;
		System.out.println(ans);
	}

	public int maxPath(int row, int col, ArrayList<ArrayList<Integer>> record) {
		int current = record.get(row).get(col);
		if (row == record.size() - 1) {
			return current;
		}
		return current + Math.max(maxPath(row + 1, col, record), maxPath(row + 1, col + 1, record));
	}

	public void p18() {
		ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>();
		Scanner text;
		try {
			text = new Scanner(new File("p18.txt"));
			Scanner line;
			while (text.hasNextLine()) {
				line = new Scanner(text.nextLine());
				ArrayList<Integer> temp = new ArrayList<Integer>();
				while (line.hasNextInt()) {
					temp.add(line.nextInt());
				}
				record.add(temp);
			}
			text.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(maxPath(0, 0, record));
	}

	public void p19() {
		TreeSet<Integer> months = new TreeSet<Integer>();
		TreeSet<Integer> sundays = new TreeSet<Integer>();
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int day = 0;
		int count = 0;
		months.add(day);
		while (count < 99) {
			if (count % 4 == 3) {
				days[1] = 29;
			} else
				days[1] = 28;
			for (int i = 0; i < days.length; i++) {
				day += days[i];
				months.add(day);
			}
			count++;
		}
		for (int i = 6; i <= day; i += 7) {
			sundays.add(i);
		}
		sundays.retainAll(months);
		System.out.println(sundays.size());
	}

	public BigInteger factorial(BigInteger n) {
		if (n.toString().equals("1")) {
			return new BigInteger("1");
		}
		return factorial(n.subtract(new BigInteger("1"))).multiply(new BigInteger(n.toString()));
	}

	public void p20() {
		BigInteger num = factorial(new BigInteger("100"));
		long ans = 0;
		for (char c : num.toString().toCharArray()) {
			ans += Integer.valueOf(Character.toString(c));
		}
		System.out.println(ans);
	}

	public long getFactorSum(long n) {
		TreeSet<Long> temp = getFactors(n);
		long sum = 0;
		for (Long l : temp) {
			sum += l;
		}
		return sum - n;
	}

	// public void p21() {
	// int num = 10000;
	// long[] myCache = new long[num];
	// Arrays.fill(myCache, -1);
	// long val;
	// long ans = 0;
	// for (int i = 1; i < num; i++) {
	// if (myCache[i] != -1) {
	// val = myCache[i];
	// } else {
	// val = getFactorSum(i);
	// if (val < num)
	// myCache[i] = val;
	// }
	// long valSum;
	// if (val < num && myCache[(int) val] == -1) {
	// valSum = getFactorSum(val);
	// if (valSum < num) {
	// myCache[(int) val] = valSum;
	// }
	// } else if(val<num){
	// valSum = myCache[(int) val];
	// } else valSum = -1;
	// if(valSum != -1 && valSum == i){
	// ans+=i;
	// }
	//// System.out.println(val);
	//// System.out.println(valSum);
	// }
	// System.out.println(getFactorSum(284));
	// System.out.println(getFactorSum(220));
	//// for(int i = 0; i<num; i++){
	//// System.out.println(myCache[i]);
	//// }
	// System.out.println(ans);
	// }

	public void p21() {
		int num = 10000;
		long[] myCache = new long[num];
		Arrays.fill(myCache, -1);
		long val;
		long ans = 0;
		for (int i = 1; i < num; i++) {
			val = getFactorSum(i);
			if (val < num)
				myCache[i] = val;
		}
		for (int a = 1; a < num; a++) {
			long b = myCache[a];
			if (b == -1)
				continue;
			if (myCache[(int) b] == a && a != b) {
				ans += a;
			}
		}
		System.out.println(ans);
	}

	public long numericSumOfString(String s) {
		long ans = 0;
		for (char c : s.toCharArray())
			ans += c - 64;
		return ans;
	}

	public void p22() {
		Scanner text;
		String names = "";
		long ans = 0;
		try {
			text = new Scanner(new File("p22.txt"));
			names = text.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		names = names.replaceAll("\"", "");
		String[] val = names.split(",");
		Arrays.sort(val);
		for (long i = 0; i < val.length; i++)
			ans += numericSumOfString(val[(int) i]) * (i+1);
		System.out.println(ans);
	}

	public static void main(String[] args) {
		Problems prob = new Problems();
		prob.p22();
	}
}