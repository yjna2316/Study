/**
 * 1463. 1로 만들기
 * https://www.acmicpc.net/problem/1463
 * time: O(n), space: O(n)
 */
import java.util.*;

public class Main {
    public static int[] d;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        System.out.println(go(n));
    }
    private static int go(int n) {
        if (n == 1) {
            return 0;
        }
        if (d[n] > 0) {
            return d[n];
        }
        d[n] = go(n - 1) + 1;
        if (n % 3 == 0) {
            int temp = go(n / 3) + 1;
            d[n] = (d[n] > temp) ? temp : d[n];
        }
        if (n % 2 == 0) {
            int temp = go(n / 2) + 1;
            d[n] = (d[n] > temp) ? temp : d[n];
        }
        return d[n];
    }
}