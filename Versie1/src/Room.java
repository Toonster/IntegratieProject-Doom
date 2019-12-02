public class Room {
    public final int WIDTH = 50;
    public final int HEIGTH = 50;
    private Player player;
    private char[][] floorPlan = new char[WIDTH][HEIGTH];

    public Room() {
        player = new Player();
        createInitialFloorPLan();
    }

    private void createInitialFloorPLan() {
        for (int i = 0; i < HEIGTH; i+=48) {
            for (int j = 0; j < WIDTH; j++) {
                floorPlan[i][j] = '-';
            }
        }
        for (int i = 0; i < HEIGTH; i++) {
            for (int j = 0; j < WIDTH; j+=48) {
                floorPlan[i][j] = '|';
            }
        }
    }

    public void drawFloorPlan() {
        for (int i = 0; i < HEIGTH; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(floorPlan[i][j]);
            }
            System.out.println();
        }
    }

    public void endRoom() {
        drawFloorPlan();
        System.out.println("The game has finished");
        System.out.printf("Health: %.1f\n", player.getCurrentHealth());
    }

    public boolean placeIsFree(int xPos, int yPos) {
        return floorPlan[xPos][yPos] == ' ';
    }

    public void updateRoom() {
        floorPlan[player.getXpos()][player.getYpos()] = player.toString().charAt(0);
    }
}
