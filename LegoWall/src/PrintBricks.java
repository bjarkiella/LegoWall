
import java.util.List;

public class PrintBricks {
    private List<List<Integer>> brickLayout;
    private Bricks bricks;

    public PrintBricks(List<List<Integer>> BrickLayout) {
        this.brickLayout = BrickLayout;
        this.bricks = new Bricks();
    }
    public void printLayout() {
        String[] printSigns = new String[] {"x","-"};
        int maxBrick = bricks.getMaxBrick();

        // Printing backwards to match with that the first layer in the list is the bottom layer printed
        for (int i = brickLayout.size() - 1; i >= 0 ; i--) {
            List<Integer> currentLayer = brickLayout.get(i);

            for (int j = 0; j < currentLayer.size(); j++) {
                int currentSignIdx = j % 2;
                String currentSign = printSigns[currentSignIdx];
            
                if (currentLayer.get(j) > maxBrick) {  // In case the brick has been removed
                    currentLayer.set(j,currentLayer.get(j) - maxBrick);  // Replacing the modified value with the original one
                    currentSign = " ";
                }

                for (int k = 0; k < currentLayer.get(j);k++) {
                    System.out.print(currentSign);
                }
            }
            System.out.println(" ");
        }
    }
}
