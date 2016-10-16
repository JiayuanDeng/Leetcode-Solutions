public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<String>();
        if (digits.length() == 0) return list;
        Queue<String> queue = new LinkedList<String>();
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String tmp;
        String letter;
        queue.offer("");
        while (!queue.isEmpty()){
            tmp = queue.poll();
            if (tmp.length() == digits.length()){
                list.add(tmp);
            }
            else{
                letter = mapping[ (int)digits.charAt(tmp.length()) - 48 ];
                for (int i = 0; i < letter.length(); i++) {
                    queue.offer(tmp + letter.charAt(i));
                }
            }
        }
        return list;
    }
}