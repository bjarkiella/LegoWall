import java.util.Random;

public class Bricks {
    public int[] brickSizes;

    public Bricks() {
        brickSizes = new int[] {1,2,3,4,6,8,10,12};
    }
    public int[] getBrickSizes() {
        return this.brickSizes;
    }
    public int getOneBrick() {
        Random rand = new Random();
        int numberOfBricks = this.brickSizes.length;
        int randBrick = rand.nextInt(numberOfBricks);

        return this.brickSizes[randBrick];
    }
}
