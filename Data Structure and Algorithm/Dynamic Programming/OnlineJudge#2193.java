/*
 * 2193. 이친수 
 * https://www.acmicpc.net/problem/2193
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /* overflow occurs when N = 90 with type int */
        long[] d = new long[91]; 
        d[1] = 1;
        d[2] = 1;
        for (int i = 3; i <= n; i ++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);
    }
}