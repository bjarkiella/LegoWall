// TODO: Perhaps move layerSum to BrickRules class, since it is techncially a rule

import java.util.ArrayList;
import java.util.List;

public class ApplyBrick {
    private int layers;
    private int width;
    private Bricks bricks;
    
    public ApplyBrick(int layers, int width) {
        this.layers = layers;
        this.width = width;
        this.bricks = new Bricks();
    }
    public List<List<Integer>> getLayout() {
        // Using a dynamic list of lists since the layers have different amount of bricks in each layer
        List<List<Integer>> fullLayout = new ArrayList<>();

        for (int i = 0; i < layers; i++){
            // if (i == 0) {
            //     List<Integer> currentLayer = layerSum();
            //     fullLayout.add(currentLayer);
            // }    
            // else {
            //     // Here there needs to be some rule checking
            //     List<Integer> prevLayer = fullLayout.get(i-1);
            // }
            
            List<Integer> currentLayer = layerSum();
            fullLayout.add(currentLayer);
        }


        return fullLayout;
    }

    private List<Integer> layerSum() {
        // This method sums up one layer to the maximum width and returns the Array
        List<Integer> oneLayer = new ArrayList<>();
        int maxCount = width * 5;
        int currentCount = 0;
        int currentSum = 0;
        
        while (currentSum != width || currentCount <= maxCount) {
            int oneBrick = bricks.getOneBrick();
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
}
