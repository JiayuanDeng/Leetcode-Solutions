public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new LinkedList<Integer>();
        if (matrix == null) return list;
        if (matrix.length == 0) return list;
        if (matrix[0].length == 0) return list;
        
        
        // state: 0 = right; 1 = down; 2 = left; 3 = up
        int state = 0;
        int x = -1, y = 0;
        
        int leftWall = -1, upWall = -1;
        int rightWall = matrix[0].length;
        int downWall = matrix.length;
        
        while (true){
            switch(state){
                case 0: // Right
                    x++;
                    if (x >= rightWall - 1){
                        state = 1;
                        upWall++;
                    }
                    break;
                case 1: // Down
                    y++;
                    if (y >= downWall - 1){
                        state = 2;
                        rightWall--;
                    }
                    break;
                case 2: // Left
                    x--;
                    if (x <= leftWall + 1){
                        state = 3;
                        downWall--;
                    }
                    break;
                case 3: // Up
                	y--;
                    if (y <= upWall + 1){
                        state = 0;
                        leftWall++;
                    }
                    break;
                default:
                    break;
            }
            list.add(matrix[y][x]);
            if ((downWall == upWall + 1) || (rightWall == leftWall + 1)) break;
        }
        
        return list;
    }
}