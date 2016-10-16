public class Solution {
    public boolean isNumber(String s) {
        if (s.length() == 0) return false;
        
        /*  ***************State Code***************
        /       0  = Start
        /       10 = [+]
        / valid 1  = [(+)1]
        /       20 = [(+).]
        / valid 2  = [(+)1.] or [(+).1] or [(+)1.1]
        /       30 = [*e]
        /       31 = [*e+]
        / valid 3  = [*e(+)1]
        / valid 4  = Finishing and expecting ' ' only
        /   **************************************** */
        
        int state = 0;
        int cur;
        for (int i = 0; i < s.length(); i++){
            cur = (int)s.charAt(i);
            switch(state){
                case 0:{    // Start
                    if (cur == (int)'+' || cur == (int)'-') state = 10;
                    else if (cur >= (int)'0' && cur <= (int)'9') state = 1;
                    else if (cur == (int)'.') state = 20;
                    else if (cur == (int)' ') ;
                    else return false;
                    break;
                }
                case 10:{    // [+]
                    if (cur >= (int)'0' && cur <= (int)'9') state = 1;
                    else if (cur == (int)'.') state = 20;
                    else return false;
                    break;
                }
                case 1:{    // [(+)1]
                    if (cur >= (int)'0' && cur <= (int)'9') ;
                    else if (cur == (int)'.') state = 2;
                    else if (cur == (int)'e') state = 30;
                    else if (cur == (int)' ') state = 4;
                    else return false;
                    break;
                }
                case 20:{    // [(+).]
                    if (cur >= (int)'0' && cur <= (int)'9') state = 2;
                    else return false;
                    break;
                }
                case 2:{    // [(+)1.] or [(+).1] or [(+)1.1]
                    if (cur >= (int)'0' && cur <= (int)'9') ;
                    else if (cur == (int)'e') state = 30;
                    else if (cur == (int)' ') state = 4;
                    else return false;
                    break;
                }
                case 30:{    // [*e]
                    if (cur >= (int)'0' && cur <= (int)'9') state = 3;
                    else if (cur == (int)'+' || cur == (int)'-') state = 31;
                    else return false;
                    break;
                }
                case 31:{    // [*e+]
                    if (cur >= (int)'0' && cur <= (int)'9') state = 3;
                    else return false;
                    break;
                }
                case 3:{    // [*e(+)1]
                    if (cur >= (int)'0' && cur <= (int)'9') ;
                    else if (cur == (int)' ') state = 4;
                    else return false;
                    break;
                }
                case 4:{    // Finishing and expecting ' ' only
                    if (cur == (int)' ') ;
                    else return false;
                    break;
                }
                default:{
                	System.out.print("Wrong State Code: " + state + "\n");
                }
            }
        }
        if (state > 0 && state < 5) return true;
        else return false;
    }
}