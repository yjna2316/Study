/*
 * 11722. 가장 긴 감소하는 부분 수열
 * https://www.acmicpc.net/problem/11722
 */

/* Solution 1 - from the front */
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i=1; i<=n; i++) {
            d[i] = 1;
            for (int j=1; j<i; j++) {
                if (a[j] > a[i] && d[i] < d[j]+1) {
                    d[i] = d[j]+1;
                }
            }
        }
        int ans = d[1];
        for (int i=2; i<=n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }
}

/* Solution 2 - from the back */
import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        int[] d = new int[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i=n; i>=1; i--) {
            d[i] = 1;
            for (int j=i+1; j<=n; j++) {
                if (a[i] > a[j] && d[i] < d[j]+1) {
                    d[i] = d[j]+1;
                }
            }
        }
        int ans = d[1];
        for (int i=2; i<=n; i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }
}
