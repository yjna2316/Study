/*
 * 2579. 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */ 
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }
        int[][] d = new int[n+1][3];
        d[1][1] = a[1];
        for (int i=2; i<=n; i++) {
            d[i][2] = d[i-1][1] + a[i];
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + a[i];
        }
        System.out.println(Math.max(d[n][1], d[n][2]));
    }
}