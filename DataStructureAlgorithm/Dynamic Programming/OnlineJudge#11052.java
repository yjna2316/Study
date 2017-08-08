/* 
 * 11052. 붕어빵 판매하기
 * https://www.acmicpc.net/submit/11052/6449688
 */
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            p[i] = sc.nextInt();
        }
        int[] d = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= i; j ++) {
                if (d[i] < d[i - j] + p[j]) {
                    d[i] = d[i - j] + p[j];
                }
            }
        }
        System.out.println(d[n]);   
    }
}