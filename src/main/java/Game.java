public class Game {

    private int gridHeight = 10;
    private int gridWidth = 10;

    public int[][] grid = new int[gridHeight][gridWidth];
    public int[][] neighbors = new int[gridHeight][gridWidth];

    public int getGridHeight() {
        return gridHeight;
    }
    public void setGridHeight(int gridHeight) {
        this.gridHeight = gridHeight;
    }
    public int getGridWidth() {
        return gridWidth;
    }
    public void setGridWidth(int gridWidth) {
        this.gridWidth = gridWidth;
    }

    public void changeSpecificNode(int height, int width) {
        if (grid[height][width] == 0) grid[height][width] = 1;
        else grid[height][width] = 0;
    }

    public void createEmptyGame() {
        for (int y=0; y < gridHeight; y++) {
            for (int x = 0; x < gridWidth; x++) {
                 grid[y][x] = 0;
            }
        }
    }
    public void createRandomGame() {
        for (int y=0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                int rand = (int)(Math.random() * 2) + 0;
                if (rand == 1) { grid[y][x] = 1; }
                else { grid[y][x] = 0; }
            }
        }
    }
    public void generateGameGrid() {
        for (int y=0; y < gridHeight; y++) {
            for (int x=0; x < gridWidth; x++)  {
                if (grid[y][x] == 1) System.out.print("x");
                else System.out.print(".");
            }
            System.out.println();
        }
    }
    public void findLife() {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                int count = 0;
                for (int k = -1; k < 2; k++) {
                    if (i + k >= 0 && i + k < gridHeight) {
                        for (int l = -1; l < 2; l++) {
                            if (j + l >= 0 && j + l < gridWidth) {
                                if (!(i+k == i && l+j == j) && grid[i + k][j + l] == 1)
                                    count++;
                            }
                        }
                    }
                }
                neighbors[i][j] = count;
            }
        }
    }
    public void death() {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] == 1 && (neighbors[i][j] < 2 || neighbors[i][j] > 3))
                    grid[i][j] = 0;
            }
        }
    }
    public void birth() {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] == 0 && neighbors[i][j] == 3)
                    grid[i][j] = 1;
            }
        }
    }
}
