import java.util.Scanner;

public class GreenVsRed {
    private int x;
    private int y;
    private int x1;
    private int y1;
    private int N;
    private String line;
    public GreenVsRed() {
        this.x = 0;
        this.y = 0;
        this.x1 = 0;
        this.y1 = 0;
        this.N = 0;
        this.line = new String();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        String gridSize = sc.nextLine().replaceAll("\\s+", "");  // user input for number of columns and rows in the grid

        this.x = Integer.parseInt(gridSize.split("[,]")[0]); //takes the number of columns
        this.y = Integer.parseInt(gridSize.split("[,]")[1]); //takes the number of rows

        Grid grid = new Grid(this.x, this.y);

        this.line = new String();
        for (int i = 0; i < y; i++) {
            line = sc.nextLine();
            grid.create(this.line,i,x);
        }

        String arguments = sc.nextLine().replaceAll("\\s+", "");  // user input for the cell that will be observed and for number of generations
        this.x1 = Integer.parseInt(arguments.split("[,]")[0]); //observed cell column
        this.y1 = Integer.parseInt(arguments.split("[,]")[1]); //observed cell row
        this.N= Integer.parseInt(arguments.split("[,]")[2]); //number of generations

        grid.changeGenerations(grid,this.y1,this.x1,N,0);

    }

}