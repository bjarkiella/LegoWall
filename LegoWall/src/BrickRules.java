import java.util.ArrayList;
import java.util.List;

public class BrickRules {
    private int layers;
    private int width;
    private Bricks bricks;
    
    public BrickRules(int layers, int width) {
        this.layers = layers;
        this.width = width;
        this.bricks = new Bricks();
    }

    // Rule #A - Add bricks up to width
    public List<Integer> layerSum() {
        // This method sums up one layer to the maximum width and returns the Array
        List<Integer> oneLayer = new ArrayList<>();
        int maxCount = width * 5;
        int currentCount = 0;
        int currentSum = 0;
        
        while (currentSum != width || currentCount <= maxCount) {
            int oneBrick = bricks.getOneBrick();
            
            if (oneBrick > width) {  // Quick check to make sure the brick size does not exceed the width
                continue;
            }
            
            currentSum += oneBrick;
            
            if (currentSum == width -1) { // If there is only width left, just select the one brick
                oneLayer.add(oneBrick);
                oneLayer.add(1);
                currentSum = width;
            }

            else if (currentSum > width) {  // If the summation exceeds the width, redo and select a new brick
                currentSum -= oneBrick;
            }
            else {
                oneLayer.add(oneBrick);
            }
            currentCount += 1; 
        }
        if (currentCount == maxCount) {  // In case the max iteration is reached, the remaining width is selected
            oneLayer.add(width - currentSum);
        }
        return oneLayer;
    }
    
    // Rule B: No straight lines in two consecutvie layers
    public boolean straightCheck(List<Integer> currentLayer, List<Integer> prevLayer) {
        boolean sCheck = false;
        // Create a summation arrays

        return sCheck;
    }

    // Rule C: Hole in every line
        // Select one of the bricks and set to 0
        // Check with rule B if ok?
}
