import java.util.Hashtable;

public class ValidWordAbbr {
    Hashtable<String, String> wordTable;
    Hashtable<String, Integer> abbrTable;
    
    public ValidWordAbbr(String[] dictionary) {
        wordTable = new Hashtable<String, String>();
        abbrTable = new Hashtable<String, Integer>();
        for (String s : dictionary){
            String abbr = GetAbbr(s);
            
            if (wordTable.get(s) == null){
                //New word found
                wordTable.put(s, abbr);
                if (abbrTable.get(abbr) == null){
                    abbrTable.put(abbr, 1);
                }
                else{
                    abbrTable.put(abbr, abbrTable.get(abbr) + 1);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = wordTable.get(word);
        Integer count = abbrTable.get(GetAbbr(word));
        if (abbr == null && count == null){
            return true;
        }
        if (abbr != null && count == 1){
            return true;
        }
        return false;
    }
    
    private String GetAbbr(String word){
        if (word.length() > 2){
            word = word.charAt(0) + "" + (word.length() - 2) + "" +  word.charAt(word.length() - 1);
        }
        return word;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");