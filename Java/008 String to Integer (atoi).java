public class Solution {
    public static int myAtoi(String str) {
        int sign = 1;       // Sign of the number
        long num = 0;        // Integer part
        int signExp = 1;    // Sign of the exponential part
        int exp = 0;        // Exponential part
        
        int len = str.length();
        int state = 0;
        // 0 = begin
        // 10 / 11 = integer / sign
        // 20 / 21 / 22 = e with number / e / e with sign
        // 30 = end blank detected
        int curChar;
        for (int i = 0; i < len; i++){
            curChar = (int)str.charAt(i);
            switch(state){
                case 0:
                    if (curChar == (int)'+' || curChar == (int)'-'){
                        sign = (curChar == '+') ? 1 : -1;
                        state = 11;
                    }
                    else if (curChar >= (int)'0' && curChar <= (int)'9'){
                    	num = curChar - (int)'0';
                        state = 10; 
                    }
                    else if (curChar == (int)' ');
                    else return 0;
                    break;
                case 11:
                    if (curChar >= (int)'0' && curChar <= (int)'9'){
                    	num = curChar - (int)'0';
                        state = 10;
                    }
                    else return 0;
                    break;
                case 10:
                    if(curChar == (int)'e'){
                        state = 21;
                    }
                    else if (curChar >= (int)'0' && curChar <= (int)'9'){
                    	num = num * 10 + (curChar - (int)'0');
                    	if (num > Integer.MAX_VALUE) i = len;
                    }
                    else state = 30;
                    break;
                case 21:
                    if (curChar == (int)'+' || curChar == (int)'-'){
                        signExp = (curChar == (int)'+') ? 1 : -1;
                        state = 22;
                    }
                    else if(curChar >= (int)'0' && curChar <= (int)'9'){
                        exp = curChar - (int)'0';
                        state = 20;
                    }
                    else return 0;
                    break;
                case 22:
                    if(curChar >= (int)'0' && curChar <= (int)'9'){
                        exp = exp * 10 + (curChar - (int)'0');
                        state = 20;
                    }
                    else return 0;
                    break;
                case 20:
                    if(curChar >= (int)'0' && curChar <= (int)'9'){
                        exp = exp * 10 + (curChar - (int)'0');
                    }
                    else state = 30;
                    break;
                default: break;
            }
        }
        if (state % 10 == 0 || state == 21)
        {
            long number = sign * num;
            if (exp != 0){
                if (signExp == 1){
                    for (int i = 0; i < exp; i++){
                        number *= 10;
                        if (number > Integer.MAX_VALUE) break;
                    }
                }
                else if (signExp == -1){
                    for (int i = 0; i < exp; i++){
                        number /= 10;
                        if (number < Integer.MIN_VALUE) break;
                    }
                }
            }
            if (number > Integer.MAX_VALUE){
                if (sign * num > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else
                    return (int)(sign * num);
            }
            if (number < Integer.MIN_VALUE){
                if (sign * num < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                else
                    return (int)(sign * num);
            }
            return (int)number;
        }
        else
            return 0;
    }
}