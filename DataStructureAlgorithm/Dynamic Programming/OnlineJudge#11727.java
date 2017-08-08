/**
 * 11727. 2xn 타일링 2
 * https://www.acmicpc.net/problem/11727
 * time: O(n), space: O(1)
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1001];
        d[1] = 1;
        d[2] = 3; 
        for (int i = 3; i <= n; i ++) {
            d[i] = d[i - 1] + 2 * d[i - 2];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
    }
}

