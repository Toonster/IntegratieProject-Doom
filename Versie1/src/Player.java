import java.util.Random;

public class Player {
    private final double START_HEALTH = 9;
    private double currentHealth;
    private Random random;
    private Position position;
    private Room room;

    public Player() {
        currentHealth = START_HEALTH;
        random = new Random();
        generateRandomPos();
    }

    private void generateRandomPos() {
        position = new Position(random.nextInt(room.WIDTH + 1), random.nextInt(room.HEIGTH + 1));
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void moveRandomly() {
        int newXPos = position.getXpos() + (random.nextInt(3) - 1);
        int newYPos = position.getYpos() + (random.nextInt(3) - 1);
        if (room.placeIsFree(newXPos, newYPos)) {
            position = new Position(newXPos, newYPos);
        }
    }

    public void takeDamageAndCheckHealth(double amount) {
        currentHealth -= amount;
        if (isDead()) {
            playerDies();
        }
    }

    private boolean isDead() {
        return currentHealth <= 0;
    }

    public void playerDies() {
            System.out.println("The player has died!");
            room.endRoom();
    }

    @Override
    public String toString() {
        return "P";
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public int getXpos() {
        return position.getXpos();
    }

    public int getYpos() {
        return position.getYpos();
    }
}
