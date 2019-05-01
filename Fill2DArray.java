public class Fill2DArray {
    public static boolean[][] makeGrid(int rows, int cols)
    {
        boolean[][] grid = new boolean[rows][cols];
        for(int row = 0; row<rows; row++){
            for(int column = 0; column<cols; column++){
                //Checks to see if to fill true or false
                if((row%2 == 1 && column%2 == 1) || (row%2 == 0 && column%2 ==0)){
                    grid[row][column] = true;
                }
                else
                    grid[row][column] = false;
            }
        }
        return grid;
    }
}
