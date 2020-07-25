import java.util.Arrays;

public class Grid {
    private int x, y;
    private char[][] grid;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        this.grid = new char[x][y];
    }

    public void create(String line, int row,int column) {
        for (int j = 0; j < column; j++) {
            this.grid[row][j] = line.charAt(j); //gets the elements in the array
        }
    }

    public void changeGenerations(Grid grid,int rowCell, int columnCell, int n, int greenCounter){
        char[][] nextGrid = Arrays.stream(this.grid).map(char[]::clone).toArray(char[][]::new); //creates array that will be used to find next generation

        for (int generationCounter = 0; generationCounter <= n; generationCounter++) {
            if(grid.grid[rowCell][columnCell]=='1') greenCounter++; //if cell is green, greencounter gets bigger
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    nextGrid[i][j]=neighbours(i,j,this.grid); //checks the neighbours condition
                }
            }
            nextGeneration(nextGrid);
        }
        System.out.println(greenCounter);
    }
    private void nextGeneration(char[][] nextGrid) //changes generation
    {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[0].length; j++) {
                this.grid[i][j] = nextGrid[i][j];
            }
        }
    }
    private char neighbours(int y,int x, char[][] grid) {
        char result=grid[y][x];
        int left,right,up,down, neighbours=0;
        if(y-1>=0) { up=y-1; } //checks if the cell is on the top side of the grid
        else { up=y; }

        if(x-1>=0) { left=x-1; } //checks if the cell is on the left side of the grid
        else { left=x; }

        if(y+1<grid.length) { down=y+1; } //checks if the cell is on the bottom side of the grid
        else { down=y; }

        if(x+1<grid[0].length) { right=x+1; } //checks if the cell is on the right side of the grid
        else { right=x; }

        for (int i=up; i<=down; i++) {
            for (int j = left; j <= right; j++) {
                if(i==y && j==x) {    //if we are on the cell given, we skip to next iteration
                    continue;
                }
                if(grid[i][j]=='1') {   //if the cell is green we have one more neighbour
                    neighbours++;
                }
            }
        }
        if(grid[y][x]=='0') //if the cell is red
        {
            if(neighbours==3 || neighbours==6) //if the cell has 3 or 6 green neighbours it becomes green
            {
                result='1';
            }
        }
        else if(neighbours!=2 && neighbours!=3 && neighbours!=6) { //if the cell is green and has 0,1,4,5,7,8 green neighbours it becomes red
            result='0';
        }
        return result;
    }
}
