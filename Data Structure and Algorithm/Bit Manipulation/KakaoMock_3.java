/**
 * https://programmers.co.kr/tryouts/1467/challenges/3528?language=java
 */

/** 
 * Using bit manipulation 
 * A xor A = 0, A xor 0 = A
 * A xor A xor B = B
 */
class Solution {
    public int[] solution(int[][] v) {
       
        int x = 0, y = 0;
        
        for (int i = 0; i < 3; i ++)
        {
            x = x ^ v[i][0]; 
            y = y ^ v[i][1];
        }
        
        return new int[]{x, y};
    }
}