public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int y = 0; y < grid.length; y++){
            for (int x = 0; x < grid[0].length; x++){
                if (grid[y][x] == '1'){
                    paintIsland(grid, x, y);
                    count++;
                }
            }
        }
        return count;
    }
    
    
    private void paintIsland(char[][] grid, int x, int y){
        grid[y][x] = 'i';
        if (x - 1 >= 0){
            if (grid[y][x - 1] == '1'){
                paintIsland(grid, x - 1, y);
            }
        }
        if (x + 1 <= grid[0].length - 1){
            if (grid[y][x + 1] == '1'){
                paintIsland(grid, x + 1, y);
            }
        }
        if (y - 1 >= 0){
            if (grid[y - 1][x] == '1'){
                paintIsland(grid, x, y - 1);
            }
        }
        if (y + 1 <= grid.length - 1){
            if (grid[y + 1][x] == '1'){
                paintIsland(grid, x, y + 1);
            }
        }
    }
}