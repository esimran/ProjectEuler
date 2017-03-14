import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
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
		for(int i = 1; i<=100; i++){
			sum+=i*i;
			square+=i;
		}
		square*=square;
		System.out.println(square-sum);
	}

	public boolean isPrime(int k){
		if(k%2 == 0)
			return false;
		for(int i = 3; i*i<=k; i+=2){
			if(k%i == 0)
				return false;
		}
		return true;
	}
	
	public void p7() {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int i = 0;
		while(ans.size()<=10000){
			if(isPrime(i))
				ans.add(i);
			i++;
		}
		System.out.println(ans.get(10000));
	}
	
	public static void main(String[] args) {
		Problems prob = new Problems();
		prob.p1();
		prob.p2();
		prob.p3(600851475143L);
		prob.p4();
		prob.p5();
		prob.p6();
		prob.p7();
	}
}