public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null) return 0;
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int w = grid[0].length;
        int h = grid.length;
        int[][] col = new int[h][w];
        int[][] row = new int[h][w];
        
        int maxCount = 0;
        
        for (int j = 0; j < h; j++){
            for (int i = 0; i < w; i++){
                if (j > 0 && grid[j-1][i] != 'W'){
                    col[j][i] = col[j-1][i];
                }
                else{
                    col[j][i] = ColEnemy(grid, i, j);
                }
                
                if (i > 0 && grid[j][i-1] != 'W'){
                    row[j][i] = row[j][i-1];
                }
                else{
                    row[j][i] = RowEnemy(grid, i, j);
                }
                
                if (grid[j][i] == '0'){
                    maxCount = maxCount >= col[j][i] + row[j][i] ? maxCount : col[j][i] + row[j][i];
                }
            }
        }
        return maxCount;
    }
    
    // Calculate number of enemy number below x, y until a wall
    public int ColEnemy(char[][] grid, int x, int y){
        int count = 0;
        for (int j = y; j < grid.length; j++){
            if (grid[j][x] == 'W') break;
            if (grid[j][x] == 'E') count++;
        }
        return count;
    }
    
    public int RowEnemy(char[][] grid, int x, int y){
        int count = 0;
        for (int i = x; i < grid[0].length; i++){
            if (grid[y][i] == 'W') break;
            if (grid[y][i] == 'E') count++;
        }
        return count;
    }
}