public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList();
        String s;
        for(int i = 1; i <= n; i++){
            s = "";
            if (i % 3 == 0){
                s += "Fizz";
                if (i % 5 == 0){
                    s += "Buzz";
                }
            }
            else if (i % 5 == 0){
                s += "Buzz";
            }
            else{
                s += i;
            }
            list.add(s);
        }
        return list;
    }
}