/*
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/#/discuss
 */
 
public class Solution1 {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) 
        {   
            int tail = x % 10;
            int midResult = result * 10 + tail;
            if ((midResult - tail) / 10 != result) 
            { return 0; }
            result = midResult;
            x = x / 10;
        }
        return result;
    }
}

public class Solution2 {
    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        if (sign == -1) x = x * -1;
        int result = 0;
        while (x != 0) 
        {   
            if (Integer.MAX_VALUE / 10 < result ||  Integer.MAX_VALUE - (x % 10) < result * 10) 
            { return 0; }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return sign * result;
    }
}