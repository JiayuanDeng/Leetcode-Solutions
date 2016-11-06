public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int lenSum = 0;
        for (String word : sentence){
            if (word.length() > cols)
                return 0;
            lenSum += word.length() + 1;
        }
        int multi = cols / lenSum > 0 ? cols / lenSum - 1 : 0;
        lenSum = multi * lenSum;
        
        int sCount = 0;
        int pRow = 0, pCol = 0, nextCol, nextRow;
        String word;
        while(true){
            // Check if "multi" of group can be placed
            nextCol = pCol + lenSum;
            if (lenSum == 0 || nextCol > cols){
                for (int i = 0; i < sentence.length; i++){
                    word = sentence[i];
                    nextCol = pCol + word.length() + 1;
                    nextRow = pRow;
                    if (nextCol - 1 > cols){
                        // Require a new row
                        nextRow = pRow + 1;
                        nextCol = word.length() + 1;
                        if (nextRow > rows - 1)
                            return sCount;
                    }
                    pRow = nextRow;
                    pCol = nextCol;
                }
                sCount++;
            }
            else{
                pCol = nextCol;
                sCount += multi;
            }
        }
    }
}